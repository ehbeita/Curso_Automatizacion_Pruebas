package dataProviders;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import pojo.Products;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ProductsProvider {
    @DataProvider(name = "getProducts")
    private Object[][] getProducts(){
        return new Object[][]{
                {new Products("macbook", "macbook_1-47x47.jpg", 602.00,
                        454.10, 518.16)}
        };
    }

    @DataProvider(name = "getProductsFromJson")
    private Object[][] getProductsFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/testData/products.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<Products> testData = new Gson().fromJson(dataSet, new TypeToken<List<Products>>() {}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }
}
