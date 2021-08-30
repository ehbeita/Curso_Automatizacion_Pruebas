package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{

    //elementos
    public String ProductTitleSelector = "//h1[text()='<name>']";
    public By ProductQuantityInputSelector = By.id("input-quantity");
    public By AddButtonSelector = By.id("button-cart");
    public By AlertSuccess = By.cssSelector(".alert-success");
    public By ShoppingCartSuccessSelector = By.linkText("shopping cart");
    public By CurrencyButtonLocator = By.xpath("//*[@id=\"form-currency\"]/div/button");
    public By CurrencyDollarButtonLocator = By.xpath("//*[@id=\"form-currency\"]/div/ul/li[3]/button");
    public By CurrencyPoundButtonLocator = By.xpath("//*[@id=\"form-currency\"]/div/ul/li[2]/button");
    public By CurrencyEuroButtonLocator = By.xpath("//*[@id=\"form-currency\"]/div/ul/li[1]/button");
    public By ProductPriceLocator = By.xpath("//*[@id=\"content\"]/div/div[2]/ul[2]/li[1]/h2");

    public ProductPage(WebDriver _driver){
        super(_driver);
    }

    public boolean isTitleDisplayed(String name){
        return driver.findElement(By.xpath(ProductTitleSelector.replace("<name>", name))).isDisplayed();
    }

    public void SetQuantity(int quantity){
        driver.findElement(ProductQuantityInputSelector).clear();
        driver.findElement(ProductQuantityInputSelector).sendKeys("" + quantity);
    }

    public void clickAddButton(){
        driver.findElement(AddButtonSelector).click();
    }

    public boolean isAlertSuccessDisplayed(){
        return driver.findElement(AlertSuccess).isDisplayed();
    }

    public void clickShoppingCartSuccessLink(){
        driver.findElement(ShoppingCartSuccessSelector).click();
    }

    public void clickOnCurrencyButton(){ driver.findElement(CurrencyButtonLocator).click(); }

    public void clickOnDollarCurrencyButton(){ driver.findElement(CurrencyDollarButtonLocator).click(); }

    public void clickOnPoundCurrencyButton(){ driver.findElement(CurrencyPoundButtonLocator).click(); }

    public void clickOnEuroCurrencyButton(){ driver.findElement(CurrencyEuroButtonLocator).click(); }

    public String getProductPrice(){
        return driver.findElement(ProductPriceLocator).getText();
    }
}