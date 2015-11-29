package API;

import com.fasterxml.jackson.databind.JsonNode;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

import javax.persistence.EntityManager;
import java.util.UUID;

/**
 * Created by dori on 29.11.15.
 */
public class AdminAuth extends Controller {

    @Transactional(readOnly = true)
    public Result authenticate(){

        EntityManager em = JPA.em();
        JsonNode json = request().body().asJson();
        if (json.has("username")){
            if (json.get("username").asText().equals("faszkalap")){
                if (json.has("password")){
                    if (json.get("password").asText().equals("govnar")){
                        return ok("Matched username and password");
                    }
                }
            }
        }
        return status(488,"Bad username or password");
    }

}
