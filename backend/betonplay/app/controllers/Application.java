package controllers;

import models.League;
import models.LeagueTeam;
import models.Season;
import models.Team;
import org.hibernate.jpa.internal.EntityManagerImpl;
import play.*;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.*;

import populaters.PopulateBeginning;
import views.html.*;

import javax.persistence.EntityManager;
import java.util.List;

public class Application extends Controller {

    @Transactional
    public Result index() {

        PopulateBeginning.populate();

        List<Team> teams = JPA.em().createQuery("select e from Team e", Team.class).getResultList();
        List<League> leagues = JPA.em().createQuery("select e from League e", League.class).getResultList();
        List<LeagueTeam> leagueTeams = JPA.em().createQuery("select e from LeagueTeam e", LeagueTeam.class).getResultList();

        return ok(index.render("Leagues: " + leagues.size() + "\nLeagueTeams: " + leagueTeams.size() +
                "\nteams: " + teams.size()));
    }

}
