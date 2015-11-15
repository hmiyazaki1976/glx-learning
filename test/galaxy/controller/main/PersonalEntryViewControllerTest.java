package galaxy.controller.main;

import org.slim3.tester.ControllerTestCase;

import galaxy.controller.main.PersonalEntryViewController;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PersonalEntryViewControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/master/personalEntryView");
        PersonalEntryViewController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/master/personalEntryView.jsp"));
    }
}
