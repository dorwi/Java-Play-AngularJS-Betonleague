package models;

import org.hibernate.annotations.Type;
import play.db.jpa.Transactional;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by dori on 23.10.15.
 */

@Entity
@Table(name="match")
public class Match {

    @Id
    @Column(name="id", updatable = false, columnDefinition = "uuid")
    @Type(type="pg-uuid")
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "home_fk")
    MatchTeam home;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "away_fk")
    MatchTeam away;

    @ManyToOne
    @JoinColumn(name="round_fk")
    Round round;

    boolean played;


/*
    @Version
    long version;
*/
    /*Constructors*/

    public Match() {
        id = UUID.randomUUID();
    }

    public Match(MatchTeam home, MatchTeam away, Round round, boolean played) {
        this();
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
