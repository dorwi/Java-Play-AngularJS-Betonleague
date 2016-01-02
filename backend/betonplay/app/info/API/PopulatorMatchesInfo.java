package info.API;

import models.*;
import play.db.jpa.JPA;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dori on 01.01.16.
 */
public class PopulatorMatchesInfo {

    public static List<String> matchesCSV(String seasonName) throws Exception {
        List<String> res = new ArrayList<>();
        res.add("League,Round,Home,Away,Goals Home,Goals Away");
        Season season = JPA.em().createQuery("SELECT s FROM Season s Where s.name=\'" + seasonName + "\'",
                Season.class).getSingleResult();
        for (League league: season.getLeagues()){
            for (Round round: league.getRounds()){
                for (Match match: round.getMatches()){
                    StringBuilder sb = new StringBuilder();
                    sb.append(league.getName() + ",");
                    sb.append(round.getOrderNumber() + ",");
                    sb.append(match.getHome().getTeamName() + ",");
                    sb.append(match.getAway().getTeamName());
                    if (match.isPlayed()){
                        sb.append("," + match.getHome().getGoals());
                        sb.append("," + match.getAway().getGoals());
                    }
                    res.add(sb.toString());
                }
            }
        }
        return res;
    }

}
