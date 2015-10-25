package models;

import play.db.jpa.Transactional;

import javax.persistence.*;

/**
 * Created by dori on 23.10.15.
 */

@Entity
public class MatchTeam {
    @Id @GeneratedValue
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

    public MatchTeam(Team team) {
        this(team,0,false);
    }

    public MatchTeam(Team team, int goals) {
        this(team, goals, false);
    }

    public MatchTeam(Team team, int goals, boolean fined) {
        this.team = team;
        this.goals = goals;
        this.fined = fined;
    }

    /*Creators*/

    @Transactional
    public static MatchTeam createMatchTeam(EntityManager em,Team team, int goals, boolean fined){
        MatchTeam matchTeam = new MatchTeam(team,goals,fined);
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

    public boolean isFined() {
        return fined;
    }

    public void setFined(boolean fined) {
        this.fined = fined;
    }

    public long getVersion() {
        return version;
    }
}
