package org.example.pages.the_internet_herokuapp;

import org.example.pages.BasePage;
import org.example.pages.the_internet_herokuapp.utils.UserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

import static org.example.pages.the_internet_herokuapp.utils.UserType.*;

public class HoverPage extends BasePage {
    private String url = "http://the-internet.herokuapp.com/hovers";

    @FindBy(xpath = "//div[@class='figure']")
    private List<WebElement> userAvatarElements;

    @FindBy(xpath = "//div[@class='figcaption']/h5")
    private List<WebElement> userNames;


    public HoverPage(WebDriver webDriver) {
        super(webDriver);
    }

    public HoverPage open() {
        webDriver.get(url);
        return this;
    }

    public HoverPage hoverOverUserAvatar(UserType userType){
        Map<UserType, WebElement> map = Map.of(USER1, userAvatarElements.get(0),
                USER2, userAvatarElements.get(1), USER3, userAvatarElements.get(2));
        new Actions(webDriver).moveToElement(map.get(userType)).perform();
        return this;
    }

    public String getUserName(UserType userType){
        Map<UserType, WebElement> map = Map.of(USER1, userNames.get(0),
                USER2, userNames.get(1), USER3, userNames.get(2));
        return map.get(userType).getText().split(" ")[1];
    }


}
