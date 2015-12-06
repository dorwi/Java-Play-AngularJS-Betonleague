package models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by dori on 23.10.15.
 */

@Entity
@Table(name="team")
public class Team {

    @Id
    @Column(name="id", updatable = false, columnDefinition = "uuid")
    @Type(type="pg-uuid")
    private UUID id;


    @OneToMany(mappedBy = "team")
    List<MatchTeam> matches;

    @OneToMany(mappedBy = "team")
    List<LeagueTeam> leagueTeams;


    @Column(name = "current_name")
    String currentName;

/*
    @Version
    long version;
*/


    /*Constructors*/

    public Team() {
        id = UUID.randomUUID();
    }

    public Team(String currentName) {
        this();
        this.currentName = currentName;
    }


    /*Getters Setters*/

    public UUID getId() {
        return id;
    }

    public String getCurrentName() {
        return currentName;
    }

    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }

    public List<MatchTeam> getMatches() {
        return matches;
    }
}
