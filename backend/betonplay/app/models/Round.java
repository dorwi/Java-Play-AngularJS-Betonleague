package models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dori on 23.10.15.
 */
@Entity
public class Round {
    @Id @GeneratedValue
    long id;


    @ManyToOne
    League league;

    @OneToMany(mappedBy = "round")
    List<Match> matches;

    int orderNumber;

    @Version
    long version;


    /*Constructors*/

    public Round() {
    }
}
