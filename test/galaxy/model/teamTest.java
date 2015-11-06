package galaxy.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class teamTest extends AppEngineTestCase {

    private TeamModel model = new TeamModel();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
