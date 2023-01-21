package org.example.the_internet_herokuapp;

import org.example.BaseTest;
import org.example.pages.the_internet_herokuapp.KeyPressPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressPageTest extends BaseTest {
    private final KeyPressPage keyPressPage = new KeyPressPage(webDriver);

    @Test
    public void enterSpace(){
        String expected = "You entered: SPACE";
        String actual = keyPressPage.open().pressKey(Keys.SPACE).getResultText();

        Assert.assertEquals(actual, expected, "Incorrect result's text");
    }
}
