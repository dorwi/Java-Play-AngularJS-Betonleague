package info.league;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dori on 24.10.15.
 */
public class LeagueInfo {
    League league;
    Map<Team, Standing> standings;

    public void addMatch(Match match){
        Standing home = standings.get(match.getHome().getTeam());
        Standing away = standings.get(match.getAway().getTeam());
        home.increasePlayed();
        away.increasePlayed();
        home.addGoalsFor(match.getHome().getGoals());
        home.addGoalsAgainst(match.getAway().getGoals());
        away.addGoalsFor(match.getAway().getGoals());
        away.addGoalsAgainst(match.getHome().getGoals());
        home.addTeam(match.getAway().getTeam(),match.getHome().getGoals() - match.getAway().getGoals());
        away.addTeam(match.getHome().getTeam(),match.getAway().getGoals() - match.getHome().getGoals());

        if (match.getHome().getGoals() > match.getAway().getGoals()){
            //HomeInfo is a winner
            home.increaseWins();
            away.increaseLosses();
            home.addPoints(3); //TODO change it to be a constant

        } else if (match.getHome().getGoals() < match.getAway().getGoals()){
            //Away is a winner
            home.increaseLosses();
            away.increaseWins();
            away.addPoints(3);
        } else {
            //It's a draw
            home.increaseDraws();
            away.increaseDraws();
            home.addPoints(1);
            away.addPoints(1);
        }

    }


    public LeagueInfo(League league) {
        this.league = league;
        standings = new HashMap<>();
        int i=0;
        for (LeagueTeam leagueTeam: league.getLeagueTeams()){
            standings.put(leagueTeam.getTeam(), new Standing(leagueTeam.getTeam(),leagueTeam.getTeamName()));
        }
        for (Round round: league.getRounds()){
            for (Match match: round.getMatches()){
                if (match.isPlayed()){
                    addMatch(match);
                }
            }
        }

    }

    public ArrayNode getJson() throws IOException {
        ArrayList<Standing> list = new ArrayList<>(getStandings().values());
        Collections.sort(list);
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        int position=1;
        for (Standing s:list){
            s.setPosition(position);
            arrayNode.add(mapper.readTree(mapper.writeValueAsString(s)));
            ++position;
        }
        return arrayNode;
    }


    /*Getters and Setters*/

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Map<Team, Standing> getStandings() {
        return standings;
    }

    public void setStandings(Map<Team, Standing> standings) {
        this.standings = standings;
    }
}
