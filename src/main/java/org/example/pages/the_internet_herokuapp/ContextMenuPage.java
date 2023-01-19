package org.example.pages.the_internet_herokuapp;

import org.example.pages.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends BasePage {
    private final String url = "http://the-internet.herokuapp.com/context_menu";
    private String alertMessageText;

    @FindBy(id = "hot-spot")
    private WebElement hotspot;

    public ContextMenuPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ContextMenuPage open() {
        webDriver.get(url);
        return this;
    }

    public ContextMenuPage performRightClickOnHotspot(){
        Actions actions = new Actions(webDriver);
        actions.contextClick(hotspot).perform();
        return this;
    }

    public ContextMenuPage acceptAlert(){
        Alert alert = webDriver.switchTo().alert();
        this.alertMessageText = alert.getText();
        alert.accept();
        return this;
    }

    public String getAlertMessageText(){
        return this.alertMessageText;
    }


}
