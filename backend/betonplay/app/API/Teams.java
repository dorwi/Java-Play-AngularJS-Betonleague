package API;

import com.fasterxml.jackson.databind.ObjectMapper;
import info.API.RoundsInfo;
import info.API.TeamsInfo;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by dori on 06.12.15.
 */
public class Teams extends Controller {

    @Transactional(readOnly = true)
    public Result getPage()
            throws Exception {
        TeamsInfo  teamsInfo = new TeamsInfo();
        ObjectMapper mapper = new ObjectMapper();
        return ok(mapper.writeValueAsString(teamsInfo));
    }
}
