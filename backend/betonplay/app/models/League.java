package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dori on 23.10.15.
 */

@Entity
public class League {
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
    }

    public League(Season season, String name) {
        this.name = name;
        this.season = season;
        leagueTeams = new ArrayList<>();
    }

    /*Adders*/
    public void addLeagueTeam(LeagueTeam leagueTeam){
        leagueTeams.add(leagueTeam);
    }

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

    public long getVersion() {
        return version;
    }
}
