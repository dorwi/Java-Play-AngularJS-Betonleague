package API;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by dori on 29.11.15.
 */
public class AdminAuth extends Controller {

    public Result authenticate() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode json = request().body().asJson();
        if (json.has("username")){
            if (json.get("username").asText().equals("faszkalap")){
                if (json.has("password")){
                    if (json.get("password").asText().equals("govnar")){
                        return ok("{\"success\": true}");
                    }
                }
            }
        }
        return status(488,"Bad username or password");
    }

}
