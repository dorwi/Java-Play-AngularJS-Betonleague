package models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dori on 23.10.15.
 */

@Entity
public class Season {


    @Id @GeneratedValue
    long id;


    String name;


    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL, orphanRemoval = true)
    List<League> leagues;


    /*TODO add Knockout phase*/

    @Version
    long version;

    /*Constructors*/

    public Season(){
        this.name = "Unknown";
        this.leagues = new ArrayList<>();
    }

    public Season(String name){
        this.name = name;
        this.leagues = new ArrayList<>();
    }

    /*Adders*/

    public void addLeague(League league){
        leagues.add(league);
    }


    /*Finders*/

    public League findLeagueByName(EntityManager em, String name){
        for (League l:leagues){
            if (l.getName().equals(name)){
                return l;
            }
        }
        return League.createLeague(em,this,name);
    }


    /*Getters and Setters*/

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

    public long getVersion() {
        return version;
    }
}
