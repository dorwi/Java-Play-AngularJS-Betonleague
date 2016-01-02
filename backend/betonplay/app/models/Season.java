package models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.annotations.Type;

/**
 * Created by dori on 23.10.15.
 */

@Entity
@Table(name="season")
public class Season {


    @Id
    @Column(name="id", updatable = false, columnDefinition = "uuid")
    @Type(type="pg-uuid")
    private UUID id;

    @Column(name="name")
    String name;


    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL)
    List<League> leagues;


    /*TODO add Knockout phase*/

/*
    @Version
    long version;
*/

    /*Constructors*/

    public Season(){
        this.id = UUID.randomUUID();
        this.name = "Unknown";
        this.leagues = new ArrayList<>();
    }

    public Season(String name){
        this();
        this.name = name;
    }

    /*Adders*/

    public void addLeague(League league){
        leagues.add(league);
    }


    /*Finders*/

    public League findLeagueByName(String name) throws Exception {
        for (League l:leagues){
            if (l.getName().equals(name)){
                return l;
            }
        }
        throw new Exception("No league: " + name + " found in season " + this.getName());
    }

    public League findLeagueByNameOrCreate(EntityManager em, String name){
        for (League l:leagues){
            if (l.getName().equals(name)){
                return l;
            }
        }
        return League.createLeague(em,this,name);
    }


    /*Getters and Setters*/

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
    }

}
