package org.example.the_internet_herokuapp;

import org.example.BaseTest;
import org.example.pages.the_internet_herokuapp.BasicAuthPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthPageTest extends BaseTest {
    private final BasicAuthPage basicAuthPage = new BasicAuthPage(webDriver);

    @Test
    public void basicAuthTest(){
        String expectedMessage = "Congratulations! You must have the proper credentials.";
        String username = "admin";
        String password = "admin";

        String actualMessage = basicAuthPage.open()
                .signIn(username, password)
                .getWelcomeMessage();

        Assert.assertEquals(actualMessage, expectedMessage, "Incorrect welcome message");
    }
}
