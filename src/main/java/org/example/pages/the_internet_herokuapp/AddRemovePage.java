package org.example.pages.the_internet_herokuapp;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddRemovePage extends BasePage {
    private String url = "http://the-internet.herokuapp.com/add_remove_elements/";

    @FindBy(xpath = "//button[@onclick='addElement()']")
    private WebElement addElementBtn;
    @FindBy(xpath= "//div[@id='elements']/button")
    private List<WebElement> deleteButtonsList;

    public AddRemovePage(WebDriver webDriver) {
        super(webDriver);
    }

    public AddRemovePage open() {
        webDriver.get(url);
        return this;
    }

    public AddRemovePage clickAddElementBtn(){
        addElementBtn.click();
        return this;
    }

    public List<WebElement> getDeleteButtonsList(){
        return deleteButtonsList;
    }

}
