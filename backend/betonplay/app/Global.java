import play.GlobalSettings;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;

/**
 * Created by dori on 02.11.15.
 */
public class Global extends GlobalSettings{
    private class ActionWrapper extends Action.Simple {
        // For CORS
        public ActionWrapper(Action<?> action) {
            this.delegate = action;
        }

        @Override
        public F.Promise<Result> call(Http.Context ctx) throws java.lang.Throwable {
            F.Promise<Result> result = this.delegate.call(ctx);
            Http.Response response = ctx.response();
            response.setHeader("Access-Control-Allow-Origin", "*");
            return result;
        }
    }

    @Override
    public Action<?> onRequest(Http.Request request,
                               java.lang.reflect.Method actionMethod) {
        return new ActionWrapper(super.onRequest(request, actionMethod));
    }
}
