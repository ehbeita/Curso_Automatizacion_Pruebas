package selenium;

import PageObjects.ProductPage;
import PageObjects.SearchPage;
import dataProviders.ProductsProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Products;

public class TestProduct extends BaseClass {

    @Description("Validate that products prices currency from Json match their prices on product page")
    @Test(dataProvider = "getProductsFromJson", dataProviderClass = ProductsProvider.class,
            description = "Test Product Currency With Data on Product Page")
    public void Test_Product_Currency_WithData(Products testData){
        //SETUP
        SearchPage searchPage = new SearchPage(driver);
        ProductPage productPage = new ProductPage(driver);
        String productPrice;
        productPrice = "";
        double price=0.0;

        //RUN
        searchPage.Fill_Search(testData.getProduct());
        searchPage.goToProduct();

        productPage.clickOnCurrencyButton();
        productPage.clickOnDollarCurrencyButton();

        //ALL CURRENCY SETUP
        productPrice = productPage.getProductPrice();
        productPrice = productPrice.replace(",", "");

        //DOLLAR SETUP
        productPrice = productPrice.replace("$", "");
        price = Double.parseDouble(productPrice);
        //DOLLAR VALIDATION
        Assert.assertEquals(price, testData.getDolarsPrice());


        //RUN
        productPage.clickOnCurrencyButton();
        productPage.clickOnPoundCurrencyButton();

        //ALL CURRENCY SETUP
        productPrice = productPage.getProductPrice();
        productPrice = productPrice.replace(",", "");

        //POUND SETUP
        productPrice = productPrice.replace("£", "");
        price = Double.parseDouble(productPrice);
        //POUND VALIDATION
        Assert.assertEquals(price, testData.getPoundsPrice());


        //RUN
        productPage.clickOnCurrencyButton();
        productPage.clickOnEuroCurrencyButton();

        //ALL CURRENCY SETUP
        productPrice = productPage.getProductPrice();
        productPrice = productPrice.replace(",", "");

        //EURO SETUP
        productPrice = productPrice.replace("€", "");
        price = Double.parseDouble(productPrice);
        //EURO VALIDATION
        Assert.assertEquals(price, testData.getEurosPrice());
    }
}
