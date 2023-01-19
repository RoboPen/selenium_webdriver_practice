package org.example.pages.the_internet_herokuapp;

import org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {
    private final String url = "http://the-internet.herokuapp.com/dropdown";

    Select dropdown;

    public DropdownPage(WebDriver webDriver) {
        super(webDriver);
    }

    public DropdownPage open() {
        webDriver.get(url);
        dropdown = new Select(webDriver.findElement(By.id("dropdown")));
        return this;
    }

    public DropdownPage selectByText(String text){
        dropdown.selectByVisibleText(text);
        return this;
    }

    public String getSelectedText(){
        return dropdown.getFirstSelectedOption().getText();
    }
}
