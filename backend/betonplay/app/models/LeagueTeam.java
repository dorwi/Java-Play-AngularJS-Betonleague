package models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dori on 23.10.15.
 */

@Entity
public class LeagueTeam {
    @Id @GeneratedValue
    long id;

    @ManyToOne
    Team team;

    @ManyToOne
    League league;


    @OneToMany(mappedBy = "leagueTeam")
    List<LeagueTeamPlayer> leagueTeamPlayers;


    String teamName;


    @Version
    long version;

    /*Constructors*/
    public LeagueTeam() {
    }

    public LeagueTeam(Team team, League league) {
        this(team,league,team.getCurrentName());
    }

    public LeagueTeam(Team team, League league, String teamName) {
        this.team = team;
        this.league = league;
        this.teamName = teamName;
    }

    /*Getters Setters*/
}
