package galaxy.controller.main;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class PortalController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("Portal.jsp");
    }
}
