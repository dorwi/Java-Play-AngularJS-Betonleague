package API;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import info.match.MatchInfo;
import models.Match;
import models.Team;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.UUID;

import static play.mvc.Controller.request;
import static play.mvc.Results.ok;

/**
 * Created by dori on 29.11.15.
 */
public class Matches extends Controller {

    @Transactional
    public Result updateMatch() throws IOException {

        EntityManager em = JPA.em();
        JsonNode json = request().body().asJson();
        MatchInfo matchInfo = validate(json);
        Match match = (Match)em.createQuery("Select m FROM Match m where m.id=:id")
                        .setParameter("id",matchInfo.getMatchId())
                        .getSingleResult();
        match.getHome().setGoals(matchInfo.getGoalsHome());
        match.getAway().setGoals(matchInfo.getGoalsAway());
        match.setPlayed(matchInfo.isPlayed());

        match.save(em);
        return ok(match.toString());
    }


    MatchInfo validate(JsonNode json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json.toString(),MatchInfo.class);
    }
}
