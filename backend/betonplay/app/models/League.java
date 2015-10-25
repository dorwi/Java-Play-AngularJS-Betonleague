package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dori on 23.10.15.
 */

@Entity
public class League {
    /*TODO change primary key so that it reflects the fact that for every leage there can be just one
    * round with the given order number*/
    @Id @GeneratedValue
    long id;

    @ManyToOne
    Season season;

    @OneToMany(mappedBy = "league")
    List<LeagueTeam> leagueTeams;


    @OneToMany(mappedBy = "league")
    List<Round> rounds;


    String name;

    @Version
    long version;

    /*Constructors*/

    public League(){
        leagueTeams = new ArrayList<>();
        rounds = new ArrayList<>();
    }

    public League(Season season, String name) {
        this.name = name;
        this.season = season;
        leagueTeams = new ArrayList<>();
        rounds = new ArrayList<>();
    }

    /*Creaters*/

    public static League createLeague(EntityManager em, Season season, String name){
        League league = new League(season,name);
        em.persist(league);
        return league;
    }

    /*Finders*/
    public Round findRoundByOrderNr(int orderNr) throws Exception {
        for (Round r:rounds){
            if (r.getOrderNumber()==orderNr){
                return r;
            }
        }
        throw new Exception("There is no Round " + orderNr + " in league " + this.getName());
    }



    /**
     * If exists returns the round, if not creates a new one with the given order number
     * @param orderNr
     * @return
     */
    public Round findRoundByOrderNrOrCreate(EntityManager em, int orderNr){
        for (Round r:rounds){
            if (r.getOrderNumber() == orderNr){
                return r;
            }
        }
        return Round.createRound(em,this,orderNr);
    }

    public Team findTeamByName(String name) throws Exception {
        for (LeagueTeam lt:leagueTeams){
            if (lt.getTeamName().equals(name)){
                return lt.getTeam();
            }
        }
        throw new Exception("Team with name: " + name + " cannot be found in the league: " + this.getName());
    }

    /*Adders*/
    public void addLeagueTeam(LeagueTeam leagueTeam){
        leagueTeams.add(leagueTeam);
    }

    public void addRound(Round round) {this.rounds.add(round);}

    /*Getters and Setters*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LeagueTeam> getLeagueTeams() {
        return leagueTeams;
    }

    public void setLeagueTeams(List<LeagueTeam> leagueTeams) {
        this.leagueTeams = leagueTeams;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public long getVersion() {
        return version;
    }


    /*Custom functions*/


}
