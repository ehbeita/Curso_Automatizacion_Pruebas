package selenium;

import PageObjects.*;
import dataProviders.UsersProvider;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pojo.UserAccount;

import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestAccount extends BaseClass {

    public static final String ERROR_EMAIL_AND_PASSWORD_INVALID_MESSAGE = "warning: no match for e-mail address and/or password.";

    //elements
    public By logOutButtonLocator = By.linkText("Logout");
    public By alertMessageLocator = By.xpath("//div[contains(@class, 'alert-danger')]");

    @Description("Validate test login was successful")
    @Test(description = "Test Login Success")
    public void Test_Login_Successful(){
        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        String username = "juan.piedra@ucreativa.com";
        String password = "asdf";

        //Go To Login Page
        headerPage.clickOnMyAccount();
        headerPage.clickOnLoginButton();

        /*
        EJEMPLO DE LISTAS Y WEBELEMENTS SOLOS
        WebElement WishList = driver.findElement(By.linkText("Wish List"));
        ArrayList<> WishListList = driver.findElements(By.linkText("Wish List"));
        */

        //Llenar formulario
        loginPage.EnterEmail(username);
        loginPage.EnterPassword(password);
        loginPage.ClickSubmitButton();

        WebElement logOutButton = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logOutButton.isDisplayed());
    }

    @Description("Validate that the login is working with non valid credentials")
    @Test(description = "Test Login Not Success")
    public void Test_Login_Unsuccessful(){

        /*Test Driven Development
         * AS A USER I want to be to able to login properly
         *
         * GIVEN I am at login page
         * AND I log in with juan.piedra@ucreativa and asdf
         * WHEN when user is at dashboard page
         * THEN logout button is displayed
         * */

        LoginPage loginPage = new LoginPage(driver);
        String username = "juan.piedra@ucreativa.com";
        String password = "asdfasdf";
        String expectedMessage = "warning: no match for e-mail address and/or password.";

        loginPage.GoTo();
        loginPage.login(username, password);

        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertEquals(expectedMessage.toLowerCase(), alertMessage.getText().toLowerCase().trim());
    }

    @Test (dataProvider = "getUsersData", dataProviderClass = UsersProvider.class)
    public void Test_Login_With_Data(UserAccount testUser){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.GoTo();
        loginPage.login(testUser.getEmail(), testUser.getPassword());

        if(testUser.isValidAccount())
            Assert.assertTrue(driver.findElement(logOutButtonLocator).isDisplayed());
        else
            Assert.assertEquals(ERROR_EMAIL_AND_PASSWORD_INVALID_MESSAGE.toLowerCase(), driver.findElement(alertMessageLocator).getText().toLowerCase().trim());
    }

    @Description("Validate that a new account can be registered")
    @Test(description = "Test Create New Account")
    public void Test_Create_New_Account(){
        //SETUP
        String firstName = "Esteban";
        String lastName = "Hernandez";
        String email = Utils.generateRandomEmail();
        String telephone = "11111";
        String password = "asdf";
        String expectedMessage = "Your Account Has Been Created!";
        RegisterPage registerPage = new RegisterPage(driver);

        //RUN
        registerPage.GoTo();
        registerPage.FillForm(firstName, lastName, email, telephone, password);

        //VALIDATION
        Assert.assertEquals(registerPage.GetConfirmationMessage(), expectedMessage);
    }


    @Description("Validate that a duplicated email account cannot be registered")
    @Test(description = "Test New Account with Duplicated Email")
    public void Test_Duplicated_Email(@Optional("juan.piedra@ucreativa.com") String duplicatedEmail){
        //SETUP
        String expectedMessage = "Warning: E-Mail Address is already registered!";
        String firstName = "Esteban";
        String lastName = "Hernandez";
        String email = duplicatedEmail;
        String telephone = "11111";
        String password = "asdf";
        RegisterPage registerPage = new RegisterPage(driver);

        //RUN
        registerPage.GoTo();
        registerPage.FillForm(firstName, lastName, email, telephone, password);

        //VALIDATION
        Assert.assertEquals(registerPage.GetEmailRegisteredMessage(), expectedMessage);
    }
        //ShoppingCartPage shop = new ShoppingCartPage(driver);
        //shop.GoTo();
}
