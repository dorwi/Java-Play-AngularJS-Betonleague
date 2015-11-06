package models;

import play.db.jpa.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dori on 23.10.15.
 */
@Entity
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "round_seq_gen")
    @SequenceGenerator(name = "round_seq_gen", sequenceName = "round_id_seq")
    long id;


    @ManyToOne
    League league;

    @OneToMany(mappedBy = "round")
    List<Match> matches;

    int orderNumber;

    @Version
    long version;


    /*Constructors*/

    public Round() {
    }

    public Round(League league, int orderNumber) {
        this.league = league;
        this.orderNumber = orderNumber;
    }

    @Transactional
    public static Round createRound(EntityManager em, League league, int orderNumber){
        System.out.println("Creating round " + orderNumber + " in league " + league.getName());
        Round r = new Round(league,orderNumber);
        league.addRound(r);
        em.persist(r);
        return r;
    }

    /*Getters and Setters*/

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    /*Custom Functions*/

    public String getName(){
        return "Round " + this.orderNumber + ".";
    }
}
