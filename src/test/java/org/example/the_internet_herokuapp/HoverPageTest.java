package org.example.the_internet_herokuapp;

import org.example.BaseTest;
import org.example.pages.the_internet_herokuapp.HoverPage;
import org.example.pages.the_internet_herokuapp.utils.UserType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverPageTest extends BaseTest {
    private HoverPage hoverPage = new HoverPage(webDriver);

    @Test
    public void verifyUserNameWhenHoverOverAvatar(){
        String expectedName = "user1";
        String actualName = hoverPage.open().hoverOverUserAvatar(UserType.USER1).getUserName(UserType.USER1);

        Assert.assertEquals(actualName, expectedName, "Incorrect user's name");
    }
}
