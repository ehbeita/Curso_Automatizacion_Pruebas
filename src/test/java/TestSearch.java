import PageObjects.RegisterPage;
import PageObjects.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class TestSearch extends BaseClass{
    @Test
    @Parameters({"searchCriteria", "expectedResult"})
    public void Validate_Search(@Optional("macbook") String searchCriteria, @Optional("3") String expectedResult){
        int results = Integer.parseInt(expectedResult);

        SearchPage searchPage = new SearchPage(driver);

        //RUN
        searchPage.Fill_Search(searchCriteria);

        //VALIDATION
        Assert.assertTrue(driver.getCurrentUrl().contains("search="+searchCriteria));

        Assert.assertEquals(searchPage.getProductResults(), results,
                "Expecting " + expectedResult + " results, but got " + searchPage.getProductResults());
    }

    @Test
    public void Test_Empty_Results(){
        String searchCriteria = "Star Wars";
        int expectedResult = 0;

        SearchPage searchPage = new SearchPage(driver);

        //RUN
        searchPage.Fill_Search(searchCriteria);

        //VALIDATION
        Assert.assertEquals(searchPage.getProductResults(), expectedResult,
                "Expecting " + expectedResult + " results, but got " + searchPage.getProductResults());
    }

}

