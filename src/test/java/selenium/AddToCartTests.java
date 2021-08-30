package selenium;

import PageObjects.*;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddToCartTests extends BaseClass {
    @Description("Validate that add to cart is working")
    @Test
    public void Test_Add_To_Cart_Functionality(){
        /**
         * opciones de navegación
         * 1. search
         * 2. home add to cart  *****
         * 3. home -> Product Page -> add to cart
         * 4. contruir la URL
         * */
        int quantity = 5;

        HeaderPage headerPage = new HeaderPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        String name = homePage.selectFirstProductAndGetName();
        Assert.assertTrue(productPage.isTitleDisplayed(name));
        productPage.SetQuantity(quantity);
        productPage.clickAddButton();
        Assert.assertTrue(productPage.isAlertSuccessDisplayed());
        headerPage.clickOnCartButton();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Assert.assertTrue(shoppingCartPage.isProductNameDisplayed(name), "Title was not displayed");
        Assert.assertEquals(shoppingCartPage.getProductQuantity(), quantity, "Quantity is not matching");

    }

    @Description("Validate that added products to cart cannot be checked out")
    @Test(description = "Test Shopping Cart Checkout")
    @Parameters({"searchCriteria", "quantity"})
    public void Test_Shopping_Cart_Checkout(@Optional("macbook air") String searchCriteria, @Optional("5") int quantity){
        //SETUP
        SearchPage searchPage = new SearchPage(driver);
        ProductPage productPage = new ProductPage(driver);
        ShoppingCartPage cartPage = new ShoppingCartPage(driver);

        //RUN
        searchPage.Fill_Search(searchCriteria);
        searchPage.goToProduct();
        productPage.SetQuantity(quantity);
        productPage.clickAddButton();

        //VALIDATION
        Assert.assertTrue(productPage.isAlertSuccessDisplayed());

        //RUN
        productPage.clickShoppingCartSuccessLink();
        cartPage.clickOnCheckoutButton();

        //VALIDATION
        Assert.assertTrue(cartPage.isAlertDangerDisplayed());
    }

}