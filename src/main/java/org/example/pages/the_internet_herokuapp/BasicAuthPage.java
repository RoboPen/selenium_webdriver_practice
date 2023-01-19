package org.example.pages.the_internet_herokuapp;

import org.example.pages.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasicAuthPage extends BasePage {
    private final String url = "http://the-internet.herokuapp.com/basic_auth";

    @FindBy(xpath = "//div[@id='content']//p")
    private WebElement welcomeHeader;

    public BasicAuthPage(WebDriver webDriver) {
        super(webDriver);
    }

    public BasicAuthPage open() {
        webDriver.get(url);
        return this;
    }

    public BasicAuthPage signIn(String username, String password){
        //selenium is 3 is limited to this solution
        webDriver.get("https://" +username +":" +password +"@"+ "the-internet.herokuapp.com/basic_auth");
        return this;
    }

    public String getWelcomeMessage(){
        return waitForElementVisibility(welcomeHeader).getText();
    }
}
