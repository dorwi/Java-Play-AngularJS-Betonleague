package models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by dori on 23.10.15.
 */

@Entity
@Table(name="league_team")
public class LeagueTeam {
    @Id
    @Column(name="id", updatable = false, columnDefinition = "uuid")
    @Type(type="pg-uuid")
    private UUID id;

    @ManyToOne
    @JoinColumn(name="team_fk")
    Team team;

    @ManyToOne
    @JoinColumn(name="league_fk")
    League league;


    @OneToMany(mappedBy = "leagueTeam", cascade = CascadeType.ALL, orphanRemoval = true)
    List<LeagueTeamPlayer> leagueTeamPlayers;


    String teamName;


/*
    @Version
    long version;
*/

    /*Constructors*/
    public LeagueTeam() {
        id = UUID.randomUUID();
    }

    public LeagueTeam(Team team, League league) {
        this(team,league,team.getCurrentName());
    }

    public LeagueTeam(Team team, League league, String teamName) {
        this();
        this.team = team;
        this.league = league;
        this.teamName = teamName;
    }

    /*Getters Setters*/

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
