package org.sc.mvc;

import org.junit.Before;
import org.junit.Test;
import org.sc.mvc.command.CalcRequestCommand;
import org.sc.mvc.model.CalcResponse;
import org.sc.mvc.wsresponse.StaffUtilizationResult;

public class CalcRequestControllerTest {

    private CalcResponse calcResponse = null;
    private StaffUtilizationResult utilResult = null;
    private CalcRequestCommand command = null;

    @Before
    public void populateTestObjects() {
        calcResponse = new CalcResponse();
        utilResult = new StaffUtilizationResult();
        command = new CalcRequestCommand();

    }

    @Test
    public void testPopulateResponse() {

    }
}
