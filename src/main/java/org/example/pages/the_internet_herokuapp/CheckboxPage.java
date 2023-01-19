package org.example.pages.the_internet_herokuapp;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckboxPage extends BasePage {
    private final String url = "http://the-internet.herokuapp.com/checkboxes";

    @FindBy(xpath = "//form[@id='checkboxes']/input")
    private List<WebElement> checkBoxList;

    public CheckboxPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CheckboxPage open() {
        webDriver.get(url);
        return this;
    }

    public CheckboxPage selectCheckbox(int index){
        try {
            WebElement checkbox = checkBoxList.get(index-1);
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        } catch (IndexOutOfBoundsException e){
            System.err.println("Indexing starts from 1");
        }
        return this;
    }

    public CheckboxPage unselectCheckbox(int index){
        try {
            WebElement checkbox = checkBoxList.get(index-1);
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        } catch (IndexOutOfBoundsException e){
            System.err.println("Indexing starts from 1");
        }
        return this;
    }

    public boolean isCheckboxSelected(int index){
        try {
            WebElement checkbox = checkBoxList.get(index-1);
            if (checkbox.isSelected()) {
                return true;
            }
        } catch (IndexOutOfBoundsException e){
            System.err.println("Indexing starts from 1");
        }

        return false;
    }
}
