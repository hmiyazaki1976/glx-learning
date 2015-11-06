package galaxy.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class personTest extends AppEngineTestCase {

    private PersonModel model = new PersonModel();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
