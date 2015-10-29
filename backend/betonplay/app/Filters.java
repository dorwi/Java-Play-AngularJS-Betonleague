import play.api.mvc.EssentialFilter;
import play.http.HttpFilters;
import play.filters.cors.CORSFilter;

import javax.inject.Inject;

/**
 * Created by dori on 28.10.15.
 */
public class Filters implements HttpFilters {

    @Inject
    CORSFilter corsFilter;

    public EssentialFilter[] filters() {
        return new EssentialFilter[] { corsFilter };
    }
}