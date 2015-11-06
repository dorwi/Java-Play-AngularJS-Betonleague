package models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dori on 23.10.15.
 */

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq_gen")
    @SequenceGenerator(name = "team_seq_gen", sequenceName = "team_id_seq")
    long id;

    @OneToMany(mappedBy = "team")
    List<MatchTeam> matches;

    @OneToMany(mappedBy = "team")
    List<LeagueTeam> leagueTeams;


    String currentName;

    @Version
    long version;


    /*Constructors*/

    public Team() {
    }

    public Team(String currentName) {
        this.currentName = currentName;
    }


    /*Getters Setters*/

    public long getId() {
        return id;
    }

    public String getCurrentName() {
        return currentName;
    }

    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }
}
