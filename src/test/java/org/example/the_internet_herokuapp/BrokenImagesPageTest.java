package org.example.the_internet_herokuapp;

import org.example.BaseTest;
import org.example.pages.the_internet_herokuapp.BrokenImagesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrokenImagesPageTest extends BaseTest {
    private final BrokenImagesPage brokenImagesPage = new BrokenImagesPage(webDriver);

    @Test
    public void verifyIfImagesAreBroken() {
        int brokenImagesCounter = brokenImagesPage.open().getNumberOfBrokenImages();
        Assert.assertEquals(brokenImagesCounter, 0, "There are broken images");
    }


}
