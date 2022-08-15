package com.restapiexample.dummy.utils.resources;

import net.serenitybdd.core.Serenity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class ValidatorManager {
    private static String reportContent = "";
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidatorManager.class);
    public static final String REPORT = "Report";
    public static final String SUCCESS_RESULT = "Validation is OK";
    public static final String FAILED_RESULT = "Validation is FAILED";

    private ValidatorManager(){

    }

    public static boolean isFalse(Boolean[] verifications){
        boolean result = true;
        for (Boolean e : verifications){
            result = result && e;
        }
        return result;
    }

    public static boolean isFalse(List<Boolean> verifications){
        boolean result = true;
        for (Boolean e : verifications){
            result = result && e;
        }
        return result;
    }

    public static boolean compareDifferences(Object expected, Object founded, String titleOfField){
        boolean result;
        String content;
        if (expected != null) {
            result = expected.equals(founded);
        } else {
            result = expected == founded;
        }

        String valueOfValidation = result ? SUCCESS_RESULT : FAILED_RESULT;
        content = String.format("%s%nValue Expected: %s%nValue Found: %s%nValidation result is: %s%n%n", titleOfField, expected, founded, valueOfValidation);
        reportContent += content;
        LOGGER.info(content);
        Serenity.setSessionVariable(REPORT).to(reportContent);
        return result;
    }

    public static void generatedReport(String reportTitle){
        Serenity.recordReportData().withTitle(reportTitle).andContents(Serenity.sessionVariableCalled(REPORT));
        reportContent = "";
    }
}
