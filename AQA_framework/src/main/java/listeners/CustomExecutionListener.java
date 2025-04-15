package listeners;

import org.testng.IExecutionListener;
import org.apache.log4j.Logger;

public class CustomExecutionListener implements IExecutionListener {
    private static final Logger logger = Logger.getLogger(CustomExecutionListener.class);

    @Override
    public void onExecutionStart() {
        logger.info("Test execution started.");
    }

    @Override
    public void onExecutionFinish() {
        logger.info("Test execution finished.");
    }
}
