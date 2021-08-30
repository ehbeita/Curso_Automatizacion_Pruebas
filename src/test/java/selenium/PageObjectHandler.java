package selenium;
import PageObjects.*;
import org.openqa.selenium.WebDriver;

public class PageObjectHandler {

    public WebDriver driver;

    private HeaderPage headerPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private SearchPage searchPage;
    private ProductPage productPage;
    private ShoppingCartPage cartPage;

    public PageObjectHandler(){}

    public HeaderPage headerPage(){
        if(this.headerPage == null)
            headerPage = new HeaderPage(driver);
        return headerPage;
    }
    public LoginPage loginPage(){
        if(this.loginPage == null)
            loginPage = new LoginPage(driver);
        return loginPage;
    }
    public RegisterPage registerPage(){
        if(this.registerPage == null)
            registerPage = new RegisterPage(driver);
        return registerPage;
    }

    public SearchPage searchPage(){
        if(this.searchPage == null)
            searchPage = new SearchPage(driver);
        return searchPage;
    }

    public ProductPage productPage(){
        if(this.productPage == null)
            productPage = new ProductPage(driver);
        return productPage;
    }
    public ShoppingCartPage shoppingCartPage(){
        if(this.cartPage == null)
            cartPage = new ShoppingCartPage(driver);
        return cartPage;
    }
}
