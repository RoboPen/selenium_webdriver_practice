package org.example.pages.the_internet_herokuapp;

import org.example.pages.BasePage;
import org.example.pages.the_internet_herokuapp.utils.AlertType;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

import static org.example.pages.the_internet_herokuapp.utils.AlertType.*;

public class JsAlertsPage extends BasePage {
    private final String url = "http://the-internet.herokuapp.com/javascript_alerts";
    private String alertMessageText;

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    private WebElement jsAlertBtn;
    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    private WebElement jsConfirmBtn;
    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    private WebElement jsPromptBtn;
    @FindBy (id = "result")
    private WebElement result;

    public JsAlertsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public JsAlertsPage open() {
        webDriver.get(url);
        return this;
    }

    public Alert clickAlertBtn(AlertType alertType) {
        Map<AlertType, WebElement> map = Map.of(ALERT, jsAlertBtn, CONFIRM, jsConfirmBtn, PROMPT, jsPromptBtn);
        map.get(alertType).click();
        return webDriver.switchTo().alert();
    }

    public JsAlertsPage acceptAlert(Alert alert) {
        this.alertMessageText = alert.getText();
        alert.accept();
        return this;
    }

    public JsAlertsPage cancelAlert(Alert alert) {
        this.alertMessageText = alert.getText();
        alert.dismiss();
        return this;
    }

    public String getAlertMessageText(){
        return alertMessageText;
    }

    public void sendTextToAlert(Alert alert, String text) {
        alert.sendKeys(text);
    }

    public String getResultText() {
        return result.getText();
    }
}
