package galaxy.controller.main;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PortalControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/mail/Portal");
        PortalController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/mail/Portal.jsp"));
    }
}
