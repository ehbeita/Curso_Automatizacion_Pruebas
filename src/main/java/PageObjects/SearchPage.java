package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    private static final String ERROR_MESSAGE_NO_RESULTS_DISPLAYED = "There is no product that matches the search criteria.";

    //elementos
    private By SearchInputLocator = By.name("search");
    private By ProductsLocator = By.cssSelector(".product-thumb");
    private By noResultsSelector = By.id("content");
    private By ProductsNameLocator = By.xpath("*//div[@class='product-thumb']/div[2]/div[1]/h4/a");
    private By SearchSelector = By.xpath("//*[@id='search']/span/button");

    public SearchPage(WebDriver driver){
        super(driver);
    }

    public void Fill_Search(String searchCriteria){
        driver.findElement(SearchInputLocator).sendKeys(searchCriteria, Keys.ENTER);
    }
    public void goToProductsResults(){
        driver.findElement(SearchSelector).click();
    }

    public void goToProduct(){
        driver.findElement(ProductsNameLocator).click();
    }

    public int getProductResults(){
        return driver.findElements(ProductsLocator).size();
    }

    public boolean isNoResultsVisible(){
        return driver.findElement(noResultsSelector).getAttribute("innerHTML").contains(ERROR_MESSAGE_NO_RESULTS_DISPLAYED);
    }
}
