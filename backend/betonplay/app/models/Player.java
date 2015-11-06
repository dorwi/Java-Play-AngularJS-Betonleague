package models;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dori on 23.10.15.
 */
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_seq_gen")
    @SequenceGenerator(name = "player_seq_gen", sequenceName = "player_id_seq")
    long id;

    String firstName;
    String lastName;
    String nickName;
/*
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    DateTime birthday;
*/

    @OneToMany(mappedBy = "player")
    List<LeagueTeamPlayer> leagueTeamPlayers;

    @Version
    long version;




    /*Constructors*/

    public Player() {
        leagueTeamPlayers = new ArrayList<>();
    }
}
