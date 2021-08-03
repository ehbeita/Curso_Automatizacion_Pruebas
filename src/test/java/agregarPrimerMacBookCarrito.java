import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class agregarPrimerMacBookCarrito {
    @Test
    public void Test_Agregar_Primer_MacBook_Successful(){
        String searchElement = "macbook";

        String pathToDriver = Test.class.getResource("/chromedriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver", pathToDriver);

        WebDriver driver = new ChromeDriver();
        //Go to website
        driver.get("https://demo.opencart.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Go to search bar and enter "macbook" in order to search them
        driver.findElement(By.name("search")).sendKeys(searchElement);
        //Find and click on search button
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Go to the first macbook element and add it to the cart
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div[1]/div[2]/div[2]/button[1]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Search for the success alert on page after adding the item on cart
        //Assert true if the alert is displayed and hence, test is run and executed successfully.
        WebElement successfulAddAlert = driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible"));
        Assert.assertTrue(successfulAddAlert.isDisplayed());

        driver.close();
        driver.quit();
    }
}
