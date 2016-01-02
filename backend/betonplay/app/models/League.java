package models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by dori on 23.10.15.
 */

@Entity
@Table(name="league")
public class League {
    /*TODO change primary key so that it reflects the fact that for every league there can be just one
    * round with the given order number*/
    @Id
    @Column(name="id", updatable = false, columnDefinition = "uuid")
    @Type(type="pg-uuid")
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="season_fk")
    Season season;

    @OneToMany(mappedBy = "league", cascade = CascadeType.ALL, orphanRemoval = true)
    List<LeagueTeam> leagueTeams;


    @OneToMany(mappedBy = "league", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Round> rounds;

    @Column(name="name")
    String name;

/*
    @Version
    long version;
*/

    /*Constructors*/

    public League(){
        id = UUID.randomUUID();
        leagueTeams = new ArrayList<>();
        rounds = new ArrayList<>();
    }

    public League(Season season, String name) {
        this();
        this.name = name;
        this.season = season;
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

    public UUID getId() {
        return id;
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


    /*Custom functions*/


}
