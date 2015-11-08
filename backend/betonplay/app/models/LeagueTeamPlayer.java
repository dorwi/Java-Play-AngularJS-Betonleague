package models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by dori on 23.10.15.
 */
@Entity
@Table(name="league_team_player")
public class LeagueTeamPlayer {
    @Id
    @Column(name="id", updatable = false, columnDefinition = "uuid")
    @Type(type="pg-uuid")
    private UUID id;

    @ManyToOne
    @JoinColumn(name="leagueteam_fk")
    LeagueTeam leagueTeam;

    @ManyToOne
    @JoinColumn(name="player_fk")
    Player player;

/*
    @Version
    long version;
*/



    /*Constructors*/

    public LeagueTeamPlayer() {
        id = UUID.randomUUID();
    }
}
