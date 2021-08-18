package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage{

    private WebDriver driver;

    //elementos
    private By SearchInputLocator = By.name("search");
    private By ProductsLocator = By.cssSelector(".product-thumb");

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void Fill_Search(String searchCriteria){
        driver.findElement(SearchInputLocator).sendKeys(searchCriteria, Keys.ENTER);
    }

    public int getProductResults(){
        return driver.findElements(ProductsLocator).size();
    }
}
