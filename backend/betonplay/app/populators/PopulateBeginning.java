package populators;

import com.fasterxml.jackson.databind.JsonNode;
import com.typesafe.config.ConfigFactory;
import models.*;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Result;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static play.mvc.Results.ok;

/**
 * Created by dori on 24.10.15.
 */
public class PopulateBeginning {

    @Transactional
    public static void populateMatches(EntityManager em) throws Exception {
        String rootdir = ConfigFactory.load("global.conf").getConfig("global").getString("rootdir");
        String historydir = ConfigFactory.load("global.conf").getConfig("global").getString("historydir");

        CSVReader reader = new CSVReader();
        List<JsonNode> list = reader.read(rootdir + historydir + "/matches-league-1.csv");
        Season season = em.createQuery("SELECT s FROM Season s WHERE s.name=\'Betonleague 2015/2016\'", Season.class)
                .getSingleResult();
        for (JsonNode node : list) {
            System.out.println(node);
        }
        System.out.println(season.getName());

    }

    @Transactional
    public static void populateFromBeginning(EntityManager em) throws Exception {
        String rootdir = ConfigFactory.load("global.conf").getConfig("global").getString("rootdir");
        String historydir = ConfigFactory.load("global.conf").getConfig("global").getString("historydir");

/*
        Creating Leagues
*/
        Season season14 = new Season("Betonleague 2014/2015");
        Season season15 = new Season("Betonleague 2015/2016");

        System.out.println(season14.getId());
        System.out.println(season15.getId());
        League west = new League(season15, "West");
        League east = new League(season15, "East");
        season15.addLeague(west);
        season15.addLeague(east);

        /*Saving the seasons and corresponding leagues*/
        em.persist(season14);
        em.persist(season15);
        em.persist(west);
        em.persist(east);

        em.flush();

/*
* Creating Team League connections
* */
        /*
        * Create all teams from Betonleague 2015/2016
        * */
        String dir = "/2015-16";
        CSVReader reader = new CSVReader();
        List<JsonNode> teamsPerSeason = reader.read(rootdir + historydir + "/team-names-per-seasons.csv");
        for (JsonNode node : teamsPerSeason) {
            Team team = new Team(node.get("Betonleague 2015/2016").textValue());
            em.persist(team);
        }


        List<JsonNode> teamPerLeague = reader.read(rootdir + historydir + dir + "/team-league.csv");
        for (JsonNode node : teamPerLeague) {
            Team team = em.createQuery("SELECT t FROM Team t Where t.currentName=\'" + node.get("Team").asText() + "\'",
                    Team.class).getSingleResult();
            League league = null;
            for (League l : season15.getLeagues()) {
                if (l.getName().equals(node.get("League").asText())) {
                    league = l;
                    break;
                }
            }
            if (league == null) {
                throw new Exception("There is no such a league in the database");
            }
            LeagueTeam leagueTeam = new LeagueTeam(team, league);
            em.persist(leagueTeam);
            league.addLeagueTeam(leagueTeam);
            em.persist(league);
            System.out.println(leagueTeam.getTeamName());
        }
        em.flush();

/*
* Creating Matches
* */
        List<JsonNode> matches = reader.read(rootdir + historydir + dir + "/matches-league-1.csv");
        for (JsonNode node : matches) {
            League league = season15.findLeagueByNameOrCreate(em, node.get("League").asText());
            Round round = league.findRoundByOrderNrOrCreate(em, node.get("Round").asInt());
            Team homeTeam = league.findTeamByName(node.get("Home").asText());
            Team awayTeam = league.findTeamByName(node.get("Away").asText());
            int homeGoals = (node.has("Goals Home")) ? node.get("Goals Home").asInt() : -1;
            int awayGoals = (node.has("Goals Away")) ? node.get("Goals Away").asInt() : -1;
            Match match = Match.createMatch(em, null, null, round, (homeGoals > -1));
            MatchTeam mtHome = MatchTeam.createMatchTeam(em, homeTeam, match,homeGoals, false);
            MatchTeam mtAway = MatchTeam.createMatchTeam(em, awayTeam, match,awayGoals, false);
            match.setHome(mtHome);
            match.setAway(mtAway);
            em.persist(match);
            System.out.println(match);
        }

    }


    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
//        populate(em);
        populateMatches(em);
        em.getTransaction().commit();
        emf.close();
    }


    @Transactional
    public Result runFromBeginning() throws Exception {
        EntityManager em = JPA.em();
        PopulateBeginning.populateFromBeginning(em);

        return ok("Populated");
    }
}
