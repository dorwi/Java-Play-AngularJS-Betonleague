package info.API;

import models.Season;
import models.Team;
import play.db.jpa.JPA;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dori on 06.12.15.
 */
public class TeamsInfo {

    List<TeamInfo> teams;

    public TeamsInfo() throws Exception {
        this.teams = new ArrayList<>();
        List<Team> teams  = JPA.em().createQuery("SELECT t FROM Team t", Team.class).getResultList();
        for (Team team: teams){
            this.teams.add(new TeamInfo(team));
        }
    }


    public List<TeamInfo> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamInfo> teams) {
        this.teams = teams;
    }
}
