package org.example.the_internet_herokuapp;

import org.example.BaseTest;
import org.example.pages.the_internet_herokuapp.JsAlertsPage;
import org.example.pages.the_internet_herokuapp.utils.AlertType;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

public class JsAlertsPageTest extends BaseTest {
    private final JsAlertsPage jsAlertsPage = new JsAlertsPage(webDriver);

    @Test
    public void AlertTest() {
        String expectedAlertMessage = "I am a JS Alert";
        String expectedResult = "You successfully clicked an alert";

        Alert alert = jsAlertsPage.open().clickAlertBtn(AlertType.ALERT);
        String actualAlertMessage = jsAlertsPage.acceptAlert(alert).getAlertMessageText();

        softAssert.assertEquals(actualAlertMessage, expectedAlertMessage,
                "Incorrect alert's message");
        softAssert.assertEquals(jsAlertsPage.getResultText(), expectedResult,
                "Incorrect result's text");
        softAssert.assertAll();
    }

    @Test
    public void acceptConfirmTest() {
        String expectedAlertMessage = "I am a JS Confirm";
        String expectedResult = "You clicked: Ok";

        Alert alert = jsAlertsPage.open().clickAlertBtn(AlertType.CONFIRM);
        String actualAlertMessage = jsAlertsPage
                                        .acceptAlert(alert)
                                        .getAlertMessageText();

        softAssert.assertEquals(actualAlertMessage, expectedAlertMessage,
                "Incorrect alert's message");
        softAssert.assertEquals(jsAlertsPage.getResultText(), expectedResult,
                "Incorrect result's text");
        softAssert.assertAll();
    }

    @Test
    public void cancelConfirmTest() {
        String expectedAlertMessage = "I am a JS Confirm";
        String expectedResult = "You clicked: Cancel";

        Alert alert = jsAlertsPage.open().clickAlertBtn(AlertType.CONFIRM);
        String actualAlertMessage = jsAlertsPage
                                        .cancelAlert(alert)
                                        .getAlertMessageText();

        softAssert.assertEquals(actualAlertMessage, expectedAlertMessage,
                "Incorrect alert's message");
        softAssert.assertEquals(jsAlertsPage.getResultText(), expectedResult,
                "Incorrect result's text");
        softAssert.assertAll();
    }

    @Test
    public void emptyPromptAcceptTest() {
        String expectedAlertMessage = "I am a JS prompt";
        String expectedResult = "You entered:";

        Alert alert = jsAlertsPage.open().clickAlertBtn(AlertType.PROMPT);
        String actualAlertMessage = jsAlertsPage
                                        .acceptAlert(alert)
                                        .getAlertMessageText();

        softAssert.assertEquals(actualAlertMessage, expectedAlertMessage,
                "Incorrect alert's message");
        softAssert.assertEquals(jsAlertsPage.getResultText(), expectedResult,
                "Incorrect result's text");
        softAssert.assertAll();
    }

    @Test
    public void emptyPromptCancelTest() {
        String expectedAlertMessage = "I am a JS prompt";
        String expectedResult = "You entered: null";

        Alert alert = jsAlertsPage.open().clickAlertBtn(AlertType.PROMPT);
        String actualAlertMessage = jsAlertsPage
                                        .cancelAlert(alert)
                                        .getAlertMessageText();

        softAssert.assertEquals(actualAlertMessage, expectedAlertMessage,
                "Incorrect alert's message");
        softAssert.assertEquals(jsAlertsPage.getResultText(), expectedResult,
                "Incorrect result's text");
        softAssert.assertAll();
    }

    @Test
    public void fillPromptAcceptTest() {
        String text = "Message";
        String expectedAlertMessage = "I am a JS prompt";
        String expectedResult = "You entered: " + text;

        Alert alert = jsAlertsPage.open().clickAlertBtn(AlertType.PROMPT);
        jsAlertsPage.sendTextToAlert(alert, text);
        String actualAlertMessage = jsAlertsPage
                                        .acceptAlert(alert)
                                        .getAlertMessageText();

        softAssert.assertEquals(actualAlertMessage, expectedAlertMessage,
                "Incorrect alert's message");
        softAssert.assertEquals(jsAlertsPage.getResultText(), expectedResult,
                "Incorrect result's text");
        softAssert.assertAll();
    }

    @Test
    public void fillPromptCancelTest() {
        String text = "Message";
        String expectedAlertMessage = "I am a JS prompt";
        String expectedResult = "You entered: null";

        Alert alert = jsAlertsPage.open().clickAlertBtn(AlertType.PROMPT);
        jsAlertsPage.sendTextToAlert(alert, text);
        String actualAlertMessage = jsAlertsPage
                                        .cancelAlert(alert)
                                        .getAlertMessageText();

        softAssert.assertEquals(actualAlertMessage, expectedAlertMessage,
                "Incorrect alert's message");
        softAssert.assertEquals(jsAlertsPage.getResultText(), expectedResult,
                "Incorrect result's text");
        softAssert.assertAll();
    }
}
