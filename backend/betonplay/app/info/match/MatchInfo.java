package info.match;

import models.Match;

import java.util.UUID;

/**
 * Created by dori on 25.10.15.
 */
public class MatchInfo {
    UUID matchId;
    String home;
    String away;
    boolean sluzbeno;
    int goalsHome;
    int goalsAway;

    public MatchInfo(Match match) throws Exception {
        this.matchId = match.getId();
        this.home = match.getHome().getTeamName();
        this.away = match.getAway().getTeamName();
        this.goalsHome = (match.isPlayed()) ? match.getHome().getGoals() : 0;
        this.goalsAway = (match.isPlayed()) ? match.getAway().getGoals() : 0;
        this.sluzbeno = (match.getHome().isFined() || match.getAway().isFined());
    }
    

    /*Getters and Setters*/

    public UUID getMatchId() {
        return matchId;
    }

    public void setMatchId(UUID matchId) {
        this.matchId = matchId;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public boolean isSluzbeno() {
        return sluzbeno;
    }

    public void setSluzbeno(boolean sluzbeno) {
        this.sluzbeno = sluzbeno;
    }

    public int getGoalsHome() {
        return goalsHome;
    }

    public void setGoalsHome(int goalsHome) {
        this.goalsHome = goalsHome;
    }

    public int getGoalsAway() {
        return goalsAway;
    }

    public void setGoalsAway(int goalsAway) {
        this.goalsAway = goalsAway;
    }
}
