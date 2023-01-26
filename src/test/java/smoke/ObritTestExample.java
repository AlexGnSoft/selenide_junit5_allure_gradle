package smoke;

import base.BaseTest;
import base.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestListener.class)
public class ObritTestExample extends BaseTest {

    private static Logger logger = LogManager.getLogger(ObritTestExample.class);


    @Test()
    public void Fake_OBBIT_T1() {
        Assertions.assertTrue(true);
    }

    @Test()
    public void Fake_OBBIT_T2() {
        Assertions.assertTrue(false);
    }



}
