package models;

import javax.persistence.*;

/**
 * Created by dori on 23.10.15.
 */
@Entity
public class LeagueTeamPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "league_team_player_seq_gen")
    @SequenceGenerator(name = "league_team_player_seq_gen", sequenceName = "league_team_player_id_seq")
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
