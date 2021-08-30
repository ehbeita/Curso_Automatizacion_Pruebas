package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    /*public WebElement waitForVisibleElement(By selector){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selector));
        return element;
    }*/

}