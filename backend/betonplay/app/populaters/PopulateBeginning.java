package populaters;

import models.League;
import models.LeagueTeam;
import models.Season;
import models.Team;
import play.db.jpa.JPA;

/**
 * Created by dori on 24.10.15.
 */
public class PopulateBeginning {
    public static void populate(){
//        Creating Leagues
        Season season = new Season("Betonleague 2015/2016");
        League west = new League(season, "West");
        League east = new League(season, "East");
        season.addLeague(west);
        season.addLeague(east);

//        Creating Teams for West
        Team cartel = new Team("Cartel de Medellin");
        JPA.em().persist(cartel);
        LeagueTeam l1 = new LeagueTeam(cartel, west);
        west.addLeagueTeam(l1);
        JPA.em().persist(l1);
        Team hiper = new Team("Hiperventilacija");
        JPA.em().persist(hiper);
        LeagueTeam l2 = new LeagueTeam(hiper, west);
        west.addLeagueTeam(l2);
        JPA.em().persist(l2);
        Team sremcica = new Team("Sremcica");
        JPA.em().persist(sremcica);
        LeagueTeam l3 = new LeagueTeam(sremcica, west);
        west.addLeagueTeam(l3);
        JPA.em().persist(l3);
        Team alkohol = new Team("Alkohol Junajted");
        JPA.em().persist(alkohol);
        LeagueTeam l4 = new LeagueTeam(alkohol, west);
        west.addLeagueTeam(l4);
        JPA.em().persist(l4);
        Team fantazija = new Team("Fantazija stogod");
        JPA.em().persist(fantazija);
        LeagueTeam l5 = new LeagueTeam(fantazija, west);
        west.addLeagueTeam(l5);
        JPA.em().persist(l5);
        Team sestari = new Team("Sestari");
        JPA.em().persist(sestari);
        LeagueTeam l6 = new LeagueTeam(sestari, west);
        west.addLeagueTeam(l6);
        JPA.em().persist(l6);



//        Creating Teams for East
        Team kufa = new Team("Kufa");
        JPA.em().persist(kufa);
        LeagueTeam l11 = new LeagueTeam(kufa, east);
        west.addLeagueTeam(l11);
        JPA.em().persist(l11);

        Team crveni = new Team("Crveni djavoli");
        JPA.em().persist(crveni);
        LeagueTeam l21 = new LeagueTeam(crveni, east);
        west.addLeagueTeam(l21);
        JPA.em().persist(l21);

        Team vozdovac = new Team("Vozdovac");
        LeagueTeam l31 = new LeagueTeam(vozdovac, east);
        JPA.em().persist(vozdovac);
        west.addLeagueTeam(l31);
        JPA.em().persist(l31);

        Team legija = new Team("Legija stranaca");
        LeagueTeam l41 = new LeagueTeam(legija, east);
        JPA.em().persist(legija);
        west.addLeagueTeam(l41);
        JPA.em().persist(l41);

        Team anchorage = new Team("Anchorage");
        JPA.em().persist(anchorage);
        LeagueTeam l51 = new LeagueTeam(anchorage, east);
        west.addLeagueTeam(l51);
        JPA.em().persist(l51);

        Team lekino = new Team("Lekino United");
        JPA.em().persist(lekino);
        LeagueTeam l61 = new LeagueTeam(lekino, east);
        JPA.em().persist(lekino);
        west.addLeagueTeam(l61);
        JPA.em().persist(l61);


        JPA.em().persist(season);
        JPA.em().persist(east);
        JPA.em().persist(west);



    }
}
