package controllers;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import info.league.LeagueInfo;
import models.League;
import models.LeagueTeam;
import models.Season;
import models.Team;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.*;

import views.html.*;

import java.io.IOException;
import java.util.*;



public class Application extends Controller {

    @Transactional
    public Result index() throws Exception {

        return ok("Running");
    }


    @Transactional
    public Result homePage() throws IOException {
        String name = "Betonleague 2015/2016";
        Season season = JPA.em().createQuery("SELECT e FROM Season e WHERE e.name=\'"+name+"\'", Season.class)
                                .getSingleResult();

        LeagueInfo leagueInfo = new LeagueInfo(season.getLeagues().get(0));
        LeagueInfo leagueInfo2 = new LeagueInfo(season.getLeagues().get(1));

        ObjectNode ret = new ObjectNode(JsonNodeFactory.instance);
        ret.putPOJO(leagueInfo.getLeague().getName(), leagueInfo.getJson());
        ret.putPOJO(leagueInfo2.getLeague().getName(), leagueInfo2.getJson());
        return ok(ret);
    }
}


