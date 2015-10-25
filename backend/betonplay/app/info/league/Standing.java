package info.league;

import com.fasterxml.jackson.annotation.JsonIgnore;
import models.Team;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dori on 24.10.15.
 */
public class Standing implements Comparable<Standing>{
    @JsonIgnore
    Team team;

    String name;
    int position;
    int played;
    int wins;
    int draws;
    int losses;
    int goalsFor;
    int goalsAgainst;
    int points;
    int fine;   //number of points that got deducted

    @JsonIgnore
    Map<Team, Integer> map;  //the goal difference against the other teams

    public Standing(Team team, String name) {
        this.team = team;
        this.name = name;
        this.wins = 0;
        this.draws = 0;
        this.losses = 0;
        this.goalsFor = 0;
        this.goalsAgainst = 0;
        this.points = 0;
        this.fine = 0;
        this.map = new HashMap<>();
    }

    public void increasePlayed(){
        ++played;
    }

    public void increaseWins(){
        ++wins;
    }
    public void increaseDraws(){
        ++draws;
    }
    public void increaseLosses(){
        ++losses;
    }

    public void addPoints(int p){
        points+=p;
    }

    public void addGoalsFor(int g){
        goalsFor+=g;
    }

    public void addGoalsAgainst(int g){
        goalsAgainst+=g;
    }

    public void addTeam(Team team, int diff){
        Integer current = map.get(team);
        if (current==null){
            current = 0;
        }
        map.put(team,current+diff);
    }


    public int getGoalDifference(){
        return goalsFor - goalsAgainst;
    }

    public int compareTeamMatches(Team t){
        Integer current = map.get(t);
        return (current == null) ? 0 : -current; //if the goal difference is higher the better
    }


    /*Getters and Setters*/

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public Map<Team, Integer> getMap() {
        return map;
    }

    public void setMap(Map<Team, Integer> map) {
        this.map = map;
    }


    @Override
    public int compareTo(Standing s) {
        if (this.getPoints() == s.getPoints()){
            if (this.getGoalDifference() == s.getGoalDifference()){
                if (this.getGoalsFor() == s.getGoalsFor()){
                    if (this.compareTeamMatches(s.getTeam()) == 0){
                        return this.getName().compareTo(s.getName());
                    } else {
                        return this.compareTeamMatches(s.getTeam());
                    }
                } else {
                    return s.getGoalsFor() - this.getGoalsFor();
                }
            } else {
                return s.getGoalDifference() - this.getGoalDifference();
            }
        } else {
            return s.getPoints() - this.getPoints();
        }
    }
}
