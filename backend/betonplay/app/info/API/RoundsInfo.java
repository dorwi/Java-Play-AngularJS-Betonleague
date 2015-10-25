package info.API;

import info.round.RoundInfo;
import models.League;
import models.Round;
import models.Season;
import play.db.jpa.JPA;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dori on 25.10.15.
 */
public class RoundsInfo {
    List<RoundInfo> roundsPerLeague1;
    List<RoundInfo> roundsPerLeague2;

    /*Constructor*/

    public RoundsInfo(String seasonName, String leagueName1, String leagueName2) throws Exception {
        roundsPerLeague1 = new ArrayList<>();
        roundsPerLeague2 = new ArrayList<>();
        Season season = JPA.em().createQuery("SELECT s FROM Season s WHERE s.name=\'" + seasonName
                + "\'", Season.class).getSingleResult();
        League league1 = season.findLeagueByName(leagueName1);
        League league2 = season.findLeagueByName(leagueName2);
        for (Round round: league1.getRounds()){
            roundsPerLeague1.add(new RoundInfo(round));
        }
        for (Round round: league2.getRounds()){
            roundsPerLeague2.add(new RoundInfo(round));
        }
    }

    /*Getters and Setters*/

    public List<RoundInfo> getRoundsPerLeague1() {
        return roundsPerLeague1;
    }

    public void setRoundsPerLeague1(List<RoundInfo> roundsPerLeague1) {
        this.roundsPerLeague1 = roundsPerLeague1;
    }

    public List<RoundInfo> getRoundsPerLeague2() {
        return roundsPerLeague2;
    }

    public void setRoundsPerLeague2(List<RoundInfo> roundsPerLeague2) {
        this.roundsPerLeague2 = roundsPerLeague2;
    }
}
