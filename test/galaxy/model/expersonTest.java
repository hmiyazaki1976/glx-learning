package galaxy.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class expersonTest extends AppEngineTestCase {

    private ExPersonModel model = new ExPersonModel();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
