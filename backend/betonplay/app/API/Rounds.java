package API;

import com.fasterxml.jackson.databind.ObjectMapper;
import info.API.HomeInfo;
import info.API.RoundsInfo;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import static play.mvc.Results.ok;

/**
 * Created by dori on 25.10.15.
 */
public class Rounds extends Controller {



    @Transactional(readOnly = true)
    public Result getPage(String seasonName, String leagueName1, String leagueName2)
            throws Exception {
        RoundsInfo rounds  = new RoundsInfo(seasonName,leagueName1,leagueName2);
        ObjectMapper mapper = new ObjectMapper();
        return ok(mapper.writeValueAsString(rounds));
    }

}
