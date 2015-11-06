package models;

import play.db.jpa.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dori on 23.10.15.
 */

@Entity
public class MatchTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "match_team_seq_gen")
    @SequenceGenerator(name = "match_team_seq_gen", sequenceName = "match_team_id_seq")
    long id;

    @ManyToOne
    Team team;

    @ManyToOne
    Match match;

    int goals;

    boolean fined;


    @Version
    long version;


    /*Constructor*/

    public MatchTeam() {}

    public MatchTeam(Team team, Match match, int goals, boolean fined) throws Exception {
        this.team = team;
        this.goals = goals;
        this.fined = fined;
        this.match = match;
        /*
        League league = getMatch().getRound().getLeague();
        List<LeagueTeam> leagueTeams = league.getLeagueTeams();
        for (LeagueTeam lt:leagueTeams){
            if (lt.getTeam().getId() == this.team.getId()){
                this.teamName = lt.getTeamName();
            }
        }
        throw new Exception("In the league: " + league.getName() + " there is no team for: "
                + team.getCurrentName());
*/

    }

    /*Creators*/

    @Transactional
    public static MatchTeam createMatchTeam(EntityManager em,Team team,Match match, int goals, boolean fined) throws Exception {
        MatchTeam matchTeam = new MatchTeam(team,match,goals,fined);
        em.persist(matchTeam);
        return matchTeam;
    }

    /*Getters Setters*/

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public boolean isFined() {
        return fined;
    }

    public void setFined(boolean fined) {
        this.fined = fined;
    }

    public long getVersion() {
        return version;
    }

    /*Custom*/
    public String getTeamName() throws Exception {
        League league = getMatch().getRound().getLeague();
        List<LeagueTeam> leagueTeams = league.getLeagueTeams();
        for (LeagueTeam lt:leagueTeams){
            if (lt.getTeam().getId() == this.team.getId()){
                return lt.getTeamName();
            }
        }
        throw new Exception("In the league: " + league.getName() + " there is no team for: "
                + team.getCurrentName());
    }
}
