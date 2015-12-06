package info.API;

import info.match.MatchInfo;
import info.statistics.Statistics;
import models.Match;
import models.MatchTeam;
import models.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by dori on 06.12.15.
 */
public class TeamInfo {

    String currentName;
    UUID id;
    String surname;
    String firstname;

    Statistics statistics;

    List<MatchInfo> matches;

    /****************************************************/

    public TeamInfo(Team team) throws Exception {
        this.matches = new ArrayList<>();
        this.currentName = team.getCurrentName();
        this.id = team.getId();
        this.statistics = new Statistics(team);
        for (MatchTeam mt : team.getMatches()) {
            Match match = mt.getMatch();
            if (match.isPlayed()) {
                matches.add(new MatchInfo(match));
            }
        }
    }

    /*************************************/

    public String getCurrentName() {
        return currentName;
    }

    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public List<MatchInfo> getMatches() {
        return matches;
    }
}
