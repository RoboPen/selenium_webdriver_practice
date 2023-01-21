package org.example.pages.the_internet_herokuapp;

import org.example.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class KeyPressPage extends BasePage {
    private String url = "http://the-internet.herokuapp.com/key_presses";

    @FindBy(id = "target")
    private WebElement inputField;

    @FindBy(id = "result")
    private WebElement resultField;

    public KeyPressPage(WebDriver webDriver) {
        super(webDriver);
    }

    public KeyPressPage open() {
        webDriver.get(url);
        return this;
    }

    public KeyPressPage pressKey(Keys key){
        new Actions(webDriver).sendKeys(key).perform();
        return this;
    }

    public String getResultText(){
        return resultField.getText();
    }

}

