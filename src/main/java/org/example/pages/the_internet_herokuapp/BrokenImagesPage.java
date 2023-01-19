package org.example.pages.the_internet_herokuapp;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrokenImagesPage extends BasePage {
    private final String url = "http://the-internet.herokuapp.com/broken_images";

    @FindBy(xpath = "//div[@id='content']//img")
    private List<WebElement> imagesList;

    public BrokenImagesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public BrokenImagesPage open() {
        webDriver.get(url);
        return this;
    }

    public int getNumberOfBrokenImages() {
        int brokenImagesCounter = 0;
        try {
            System.out.println("The page has " + imagesList.size() + " images");
            for (WebElement img : imagesList) {
                if (img != null) {
                    HttpClient client = HttpClientBuilder.create()
                            .build();
                    HttpGet request = new HttpGet(img.getAttribute("src"));
                    HttpResponse response = client.execute(request);
                    if (response.getCode() != 200) {
                        System.out.println(img.getAttribute("outerHTML") + " is broken.");
                        brokenImagesCounter++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return brokenImagesCounter;
    }
}
