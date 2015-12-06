package info.statistics;

import models.MatchTeam;

/**
 * Created by dori on 06.12.15.
 */
public class GoalStatistics {
    int wins;
    int losses;
    int draws;
    int goalsFor;
    int goalsAgainst;


    public GoalStatistics() {
    }

    public void addPlayedMatch(MatchTeam mt, MatchTeam opponent){
        wins += (mt.getGoals() > opponent.getGoals())?1:0;
        draws += (mt.getGoals() == opponent.getGoals())?1:0;
        losses += (mt.getGoals() < opponent.getGoals())?1:0;
        goalsFor += mt.getGoals();
        goalsAgainst += opponent.getGoals();
    }


    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }
}
