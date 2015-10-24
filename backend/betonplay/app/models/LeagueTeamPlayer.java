package models;

import javax.persistence.*;

/**
 * Created by dori on 23.10.15.
 */
@Entity
public class LeagueTeamPlayer {
    @Id @GeneratedValue
    long id;

    @ManyToOne
    LeagueTeam leagueTeam;

    @ManyToOne
    Player player;

    @Version
    long version;



    /*Constructors*/

    public LeagueTeamPlayer() {
    }
}
