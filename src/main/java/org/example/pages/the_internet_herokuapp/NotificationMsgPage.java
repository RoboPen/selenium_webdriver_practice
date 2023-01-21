package org.example.pages.the_internet_herokuapp;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationMsgPage extends BasePage {
    private String url = "http://the-internet.herokuapp.com/notification_message_rendered";

    @FindBy(xpath = "//a[@href='/notification_message']")
    private WebElement link;
    @FindBy(id = "flash")
    private WebElement notificationMessage;

    public NotificationMsgPage(WebDriver webDriver) {
        super(webDriver);
    }

    public NotificationMsgPage open() {
        webDriver.get(url);
        return this;
    }

    public NotificationMsgPage clickLink(){
        link.click();
        return this;
    }

    public String getNotificationMsg(){
        return notificationMessage.getText();
    }
}
