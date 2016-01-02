package API;

import info.API.PopulatorMatchesInfo;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created by dori on 01.01.16.
 */
public class Populator extends Controller {

    @Transactional(readOnly = true)
    public Result getMatchesCSV(String seasonName) throws Exception {

        List<String> matches = PopulatorMatchesInfo.matchesCSV(seasonName);
        return ok(String.join("\n", matches));
    }

}
