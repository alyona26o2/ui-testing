package pages;

import driver.DriverConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class ImdbSearchPage {

    private final WebDriver driver = DriverConfig.getInstance().getWebDriver();

    @Step("Go to IMDB")
    public void openImdb(){
        driver.get("https://www.imdb.com/");
    }

    @Step("Type search query into search field")
    public void inputSearchField(String query) {
        driver.findElement(new By.ById("suggestion-search")).sendKeys(query);
    }

    @Step("Search the query: {query}")
    public void search(String query) {
        inputSearchField(query);
        driver.findElement(new By.ById("suggestion-search-button")).click();
    }

    @Step("Get Header on a page")
    public String getHeader(){
        return driver.findElement(new By.ByClassName("findHeader")).getText();
    }

    @Step("Get first title from the list")
    public String getFirstTitle(){
        return driver.findElements(new By.ByClassName("result_text")).get(0).getText();
    }

    @Step("Click 'Exact matches' button")
    public void clickExactMatches(){
        driver.findElement(new By.ByLinkText("Exact title matches")).click();
    }

    @Step("Get all titles")
    public List<String> getAllExactResults(){
        clickExactMatches();
        List<WebElement> titles = driver.findElements(new By.ByClassName("result_text"));
        List<String> results = new ArrayList<String>();
        for (WebElement title: titles) {
            results.add(title.getText());
        }
        return results;
    }

}
