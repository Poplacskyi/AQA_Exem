package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.apache.log4j.Logger;

public class CustomSuiteListener implements ISuiteListener {
    private static final Logger logger = Logger.getLogger(CustomSuiteListener.class);

    @Override
    public void onStart(ISuite suite) {
        logger.info("Suite started: " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        logger.info("Suite finished: " + suite.getName());
    }
}
