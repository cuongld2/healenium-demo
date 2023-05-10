package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TherapyHomePage {

    WebDriver driver;
    WebDriverWait wait;

    public TherapyHomePage(WebDriver driver) {
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    By therapyMenu=By.xpath("//a[text()=' Therapies']");

    public void navigateToTherapiesPage() {
        driver.findElement(therapyMenu).click();
    }

}
