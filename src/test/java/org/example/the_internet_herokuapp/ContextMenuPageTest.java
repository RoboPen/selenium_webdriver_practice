package org.example.the_internet_herokuapp;

import org.example.BaseTest;
import org.example.pages.the_internet_herokuapp.ContextMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuPageTest extends BaseTest {
    private final ContextMenuPage contextMenuPage = new ContextMenuPage(webDriver);

    @Test
    public void verifyAlertMessageText(){
        String expectedAlertMessage = "You selected a context menu";

        String actualAlertMessage = contextMenuPage.open()
                .performRightClickOnHotspot()
                .acceptAlert()
                .getAlertMessageText();

        Assert.assertEquals(actualAlertMessage, expectedAlertMessage, "Incorrect alert message");
    }
}
