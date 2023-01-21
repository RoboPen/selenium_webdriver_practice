package org.example.the_internet_herokuapp;

import org.example.BaseTest;
import org.example.pages.the_internet_herokuapp.NotificationMsgPage;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.containsString;

public class NotificationMsgPageTest extends BaseTest {
    private NotificationMsgPage notificationMsgPage = new NotificationMsgPage(webDriver);

    @Test
    public void verifyNotificationMsg(){
        String expectedMessageSuccessful = "Action successful";
        String expectedMessageUnsuccessful = "Action unsuccesful, please try again";

        String actualMessage = notificationMsgPage.open().clickLink().getNotificationMsg();

        assertThat(actualMessage, anyOf(containsString(expectedMessageSuccessful),
                containsString(expectedMessageUnsuccessful)));
    }
}
