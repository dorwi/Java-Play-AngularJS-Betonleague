package API;

import com.fasterxml.jackson.databind.JsonNode;
import models.Match;
import models.Team;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.persistence.EntityManager;
import java.util.UUID;

import static play.mvc.Controller.request;
import static play.mvc.Results.ok;

/**
 * Created by dori on 29.11.15.
 */
public class Matches extends Controller {

    @Transactional
    public Result updateMatch(){

        EntityManager em = JPA.em();
        JsonNode json = request().body().asJson();
        if (!valid(json)){
            return ok("E pa nece moci!");
        }
        UUID matchId = UUID.fromString(json.get("matchId").asText());
        Match match = (Match)em.createQuery("Select m FROM Match m where m.id=:id")
                        .setParameter("id",matchId)
                        .getSingleResult();
        System.out.println(match);
        match.getHome().setGoals(json.get("homeGoals").asInt());
        match.getAway().setGoals(json.get("awayGoals").asInt());
        em.persist(match);
        return ok(match.toString());
    }


    boolean valid(JsonNode json){
        if (json.has("matchId") && json.has("homeGoals") && json.has("awayGoals") ){
            if ((json.get("homeGoals").asInt() >= 0) && (json.get("awayGoals").asInt() >= 0)){
                return true;
            }
        }
        return false;
    }
}
