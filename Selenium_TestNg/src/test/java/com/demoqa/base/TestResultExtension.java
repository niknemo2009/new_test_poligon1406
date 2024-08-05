package com.demoqa.base;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import util.Color;

public class TestResultExtension implements AfterTestExecutionCallback {
    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        System.out.println("Test Result: " + context.getDisplayName() + " " + (!context.getExecutionException().isEmpty() ?
                Color.RED.value() + "FAIL" + Color.RESET.value() : Color.GREEN.value() + "PASS" + Color.RESET.value()));
    }

}