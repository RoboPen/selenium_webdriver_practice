package org.example.the_internet_herokuapp;

import org.example.BaseTest;
import org.example.pages.the_internet_herokuapp.AddRemovePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemovePageTest extends BaseTest {
    private final AddRemovePage addRemovePage = new AddRemovePage(webDriver);

    @Test
    public void verifyDeleteBtnIsCreatedAfterClickingAddBtn(){
        String expectedDeleteBtnText = "Delete";
        int numOfDeleteBtn = addRemovePage.open()
                                            .clickAddElementBtn()
                                            .getDeleteButtonsList()
                                            .size();

        String actualDeleteBtnText = addRemovePage.getDeleteButtonsList().get(0).getText();

        softAssert.assertEquals(numOfDeleteBtn, 1, "Incorrect number of delete buttons");
        softAssert.assertEquals(actualDeleteBtnText, expectedDeleteBtnText,
                "Incorrect text of delete buttons");
        softAssert.assertAll();
    }

    @Test
    public void verifyDeleteBtnIsDeletedAfterClickingIt(){
         addRemovePage.open()
                    .clickAddElementBtn()
                    .getDeleteButtonsList()
                    .get(0)
                    .click();

         Assert.assertEquals(addRemovePage.getDeleteButtonsList().size(), 0,
                 "Incorrect number of delete elements");
    }


}
