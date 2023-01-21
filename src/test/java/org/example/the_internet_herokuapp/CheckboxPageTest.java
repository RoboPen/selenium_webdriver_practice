package org.example.the_internet_herokuapp;

import org.example.BaseTest;
import org.example.pages.the_internet_herokuapp.CheckboxPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxPageTest extends BaseTest {
    private final CheckboxPage checkboxPage = new CheckboxPage(webDriver);

    @Test
    public void verifyIfCheckboxIsSelectedAfterSelection(){
        boolean isSelected = checkboxPage.open()
                .selectCheckbox(1)
                .isCheckboxSelected(1);

        Assert.assertTrue(isSelected, "Checkbox is not selected");
    }

    @Test
    public void verifyCheckboxIsUnselectedAfterUnselecting(){
        boolean isSelected = checkboxPage.open()
                .selectCheckbox(1)
                .unselectCheckbox(1)
                .isCheckboxSelected(1);

        Assert.assertFalse(isSelected, "Checkbox is selected");
    }
}
