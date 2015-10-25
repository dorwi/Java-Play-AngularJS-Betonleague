package API;

import com.fasterxml.jackson.databind.ObjectMapper;
import info.API.HomeInfo;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by dori on 25.10.15.
 */
public class Home extends Controller {

    @Transactional(readOnly = true)
    public Result getPage(String seasonName, String leagueName1, String leagueName2, int roundNumber1, int roundNumber2)
            throws Exception {
        HomeInfo homeInfo = new HomeInfo(seasonName,leagueName1,leagueName2,roundNumber1,roundNumber2);
        ObjectMapper mapper = new ObjectMapper();
        return ok(mapper.writeValueAsString(homeInfo.getJson()));
    }
}
