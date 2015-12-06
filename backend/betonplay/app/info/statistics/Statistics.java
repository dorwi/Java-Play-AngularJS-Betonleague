package info.statistics;

import models.Match;
import models.MatchTeam;
import models.Team;
import play.db.jpa.JPA;
import scala.concurrent.java8.FuturesConvertersImpl;

import java.util.List;

/**
 * Created by dori on 06.12.15.
 */
public class Statistics {

    GoalStatistics home;
    GoalStatistics away;
    GoalStatistics overall;

    public Statistics(Team team) {
        home = new GoalStatistics();
        away = new GoalStatistics();
        overall = new GoalStatistics();

        for (MatchTeam mt: team.getMatches()){
            if (mt.getMatch().isPlayed()){
                MatchTeam opponent = getOpponent(mt);
                if (mt.getMatch().getHome().getId() == mt.getId()){
                    home.addPlayedMatch(mt,opponent);
                } else {
                    away.addPlayedMatch(mt,opponent);
                }
                overall.addPlayedMatch(mt,opponent);
            }
        }
    }

    private MatchTeam getOpponent(MatchTeam mt){
        Match match = mt.getMatch();
        if (match.getHome().getId() == mt.getId()){
            return match.getAway();
        } else {
            return match.getHome();
        }
    }


    /*************************************************/

    public GoalStatistics getHome() {
        return home;
    }

    public GoalStatistics getAway() {
        return away;
    }

    public GoalStatistics getOverall() {
        return overall;
    }
}
