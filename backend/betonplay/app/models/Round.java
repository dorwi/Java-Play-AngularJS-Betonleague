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
@Table(name="round")
public class Round {
    @Id
    @Column(name="id", updatable = false, columnDefinition = "uuid")
    @Type(type="pg-uuid")
    private UUID id;


    @ManyToOne
    @JoinColumn(name="league_fk")
    League league;

    @OneToMany(mappedBy = "round", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Match> matches;

    @Column(name = "order_number")
    int orderNumber;

/*
    @Version
    long version;
*/


    /*Constructors*/

    public Round() {
        id = UUID.randomUUID();
    }

    public Round(League league, int orderNumber) {
        this();
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
