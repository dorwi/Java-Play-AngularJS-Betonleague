package models;

import play.db.jpa.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dori on 23.10.15.
 */
@Entity
public class Round {
    @Id @GeneratedValue
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
        Round r = new Round(league,orderNumber);
        em.persist(r);
        return r;
    }

    /*Getters and Setters*/

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
}
