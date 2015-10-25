package models;

import play.db.jpa.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dori on 23.10.15.
 */

@Entity
public class Match {

    @Id
    @GeneratedValue
    long id;

    @OneToOne
    MatchTeam home;

    @OneToOne
    MatchTeam away;

    @ManyToOne
    Round round;

    boolean played;


    @Version
    long version;
    /*Constructors*/

    public Match() {
    }

    public Match(MatchTeam home, MatchTeam away, Round round, boolean played) {
        this.home = home;
        this.away = away;
        this.round = round;
        this.played = played;
    }

    /*Creators*/

    @Transactional
    public static Match createMatch(EntityManager em, MatchTeam home, MatchTeam away, Round round, boolean played){
        Match match = new Match(home,away,round,played);
        em.persist(match);
        return match;
    }

    /*Getters Setters*/

    public MatchTeam getHome() {
        return home;
    }

    public void setHome(MatchTeam home) {
        this.home = home;
    }

    public MatchTeam getAway() {
        return away;
    }

    public void setAway(MatchTeam away) {
        this.away = away;
    }

    public boolean isPlayed() {
        return played;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public long getVersion() {
        return version;
    }


    @Override
    public String toString() {

        return "Round " +
                round.getOrderNumber() +
                ": " +
                home.getTeam().getCurrentName() +
                " - " +
                away.getTeam().getCurrentName() +
                " " +
                home.getGoals() +
                ":" +
                away.getGoals();
    }
}
