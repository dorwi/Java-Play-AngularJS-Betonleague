package info.API;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import info.league.LeagueInfo;
import info.round.RoundInfo;
import models.League;
import models.Round;
import models.Season;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Result;

import java.io.IOException;

import static play.mvc.Results.ok;

/**
 * Created by dori on 25.10.15.
 */
public class HomeInfo {
    LeagueInfo leagueInfo1;
    LeagueInfo leagueInfo2;
    RoundInfo roundInfo1;
    RoundInfo roundInfo2;

    /*Constructors*/

    public HomeInfo(String seasonName, String leagueName1, String leagueName2, int roundNumber1, int roundNumber2)
            throws Exception {
        System.out.println(seasonName);
        Season season = JPA.em().createQuery("SELECT s FROM Season s WHERE s.name=\'" + seasonName
                                    + "\'", Season.class).getSingleResult();
        League league1 = season.findLeagueByName(leagueName1);
        League league2 = season.findLeagueByName(leagueName2);
        Round round1 = league1.findRoundByOrderNr(roundNumber1);
        Round round2 = league2.findRoundByOrderNr(roundNumber2);
        this.leagueInfo1 = new LeagueInfo(league1);
        this.leagueInfo2 = new LeagueInfo(league2);
        this.roundInfo1 = new RoundInfo(round1);
        this.roundInfo2 = new RoundInfo(round2);
        System.out.println("Here");
    }

    /*Getters and Setters*/

    public LeagueInfo getLeagueInfo1() {
        return leagueInfo1;
    }

    public void setLeagueInfo1(LeagueInfo leagueInfo1) {
        this.leagueInfo1 = leagueInfo1;
    }

    public LeagueInfo getLeagueInfo2() {
        return leagueInfo2;
    }

    public void setLeagueInfo2(LeagueInfo leagueInfo2) {
        this.leagueInfo2 = leagueInfo2;
    }

    public RoundInfo getRoundInfo1() {
        return roundInfo1;
    }

    public void setRoundInfo1(RoundInfo roundInfo1) {
        this.roundInfo1 = roundInfo1;
    }

    public RoundInfo getRoundInfo2() {
        return roundInfo2;
    }

    public void setRoundInfo2(RoundInfo roundInfo2) {
        this.roundInfo2 = roundInfo2;
    }

    /*Custom*/
    public JsonNode getJson() throws IOException {
        ObjectNode ret = new ObjectNode(JsonNodeFactory.instance);
        ret.putPOJO("leagueInfo1",leagueInfo1.getJson());
        ret.putPOJO("leagueInfo2",leagueInfo2.getJson());
        ret.putPOJO("roundInfo1",roundInfo1);
        ret.putPOJO("roundInfo2",roundInfo2);
        return ret;
    }
}
