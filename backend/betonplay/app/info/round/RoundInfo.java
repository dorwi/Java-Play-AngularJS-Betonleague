package info.round;

import info.match.MatchInfo;
import models.Match;
import models.Round;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dori on 25.10.15.
 */
public class RoundInfo {
    String name;
    List<MatchInfo> matches;



    /*Constructors*/

    public RoundInfo(Round round) throws Exception {
        this.name = round.getName();
        this.matches = new ArrayList<>();
        System.out.println(round.getName());
        System.out.println("Matches: " + round.getMatches());
        for (Match match: round.getMatches()){
            this.matches.add(new MatchInfo(match));
        }
    }

    /*Getters and setters*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MatchInfo> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchInfo> matches) {
        this.matches = matches;
    }

}
