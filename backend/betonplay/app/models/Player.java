package models;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by dori on 23.10.15.
 */
@Entity
@Table(name="player")
public class Player {

    @Id
    @Column(name="id", updatable = false, columnDefinition = "uuid")
    @Type(type="pg-uuid")
    private UUID id;

    @Column(name="first_name")
    String firstName;

    @Column(name="last_name")
    String lastName;

    @Column(name="nick_name")
    String nickName;
/*
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    DateTime birthday;
*/

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    List<LeagueTeamPlayer> leagueTeamPlayers;

/*
    @Version
    long version;
*/




    /*Constructors*/

    public Player() {
        id = UUID.randomUUID();
        leagueTeamPlayers = new ArrayList<>();
    }
}
