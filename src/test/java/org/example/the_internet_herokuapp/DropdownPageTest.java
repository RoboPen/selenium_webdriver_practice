package org.example.the_internet_herokuapp;

import org.example.BaseTest;
import org.example.pages.the_internet_herokuapp.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownPageTest extends BaseTest {
    private final DropdownPage dropdownPage = new DropdownPage(webDriver);

    @Test
    public void verifyDefaultSelectedOptionText(){
        String expectedText = "Please select an option";
        String actualText = dropdownPage.open().getSelectedText();

        Assert.assertEquals(actualText, expectedText, "Incorrect default selected option text");
    }

    @Test
    public void verifyOptionIsSelected(){
        String expectedText = "Option 1";
        String actualText = dropdownPage.open().selectByText(expectedText).getSelectedText();

        Assert.assertEquals(actualText, expectedText, "Incorrect selected option text");
    }
}
