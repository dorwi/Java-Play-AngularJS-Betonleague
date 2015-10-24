package models;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dori on 23.10.15.
 */
@Entity
public class Player {

    @Id @GeneratedValue
    long id;

    String firstName;
    String lastName;
    String nickName;

    DateTime birthday;


    @OneToMany(mappedBy = "player")
    List<LeagueTeamPlayer> leagueTeamPlayers;

    @Version
    long version;




    /*Constructors*/

    public Player() {
        leagueTeamPlayers = new ArrayList<>();
    }
}
