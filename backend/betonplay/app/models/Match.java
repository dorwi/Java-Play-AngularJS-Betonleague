package models;

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

    @OneToMany(mappedBy = "match")
    List<MatchTeam> homes;
/*
    @OneToOne
    MatchTeam away;
*/
    @ManyToOne
    Round round;

    boolean played;


    @Version
    long version;
    /*Constructors*/

    public Match() {
    }

    public Match(List<MatchTeam> homes/*, MatchTeam away*/) {
        this(homes/*,away*/,false);
    }

    public Match(List<MatchTeam> homes/*, MatchTeam away*/, boolean played) {
        this.homes = homes;
  //      this.away = away;
        this.played = played;
    }

    /*Getters Setters*/

    public List<MatchTeam> getHomes() {
        return homes;
    }

    public void setHome(List<MatchTeam> homes) {
        this.homes = homes;
    }

    /*public MatchTeam getAway() {
        return away;
    }

    public void setAway(MatchTeam away) {
        this.away = away;
    }*/

    public boolean isPlayed() {
        return played;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    public long getVersion() {
        return version;
    }
}
