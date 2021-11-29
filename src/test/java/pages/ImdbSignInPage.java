package pages;

import driver.DriverConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImdbSignInPage {

    private final WebDriver driver = DriverConfig.getInstance().getWebDriver();

    @Step("Go to IMDB")
    public void openImdb(){
        driver.get("https://www.imdb.com/");
    }

    @Step("Go to sign in page")
    public void openSignInPage(){
        openImdb();
        WebElement href = driver.findElement(new By.ByXPath( "/html/body/div/nav/div/div/a[@class='ipc-button ipc-button--single-padding ipc-button--center-align-content ipc-button--default-height ipc-button--core-baseAlt ipc-button--theme-baseAlt ipc-button--on-textPrimary ipc-text-button imdb-header__signin-text']/div"));
        href.click();
    }
    
     @Step("Go to create new account page")
     public void createNewAccountClick(){
         driver.findElement(new By.ByLinkText("Create a New Account")).click();
     }

    public Boolean isFormDisplayed(){
        return  driver.findElement(new By.ById("ap_customer_name")) != null &&
                driver.findElement(new By.ById("ap_email")) != null &&
                driver.findElement(new By.ById("ap_password")) != null &&
                driver.findElement(new By.ById("ap_password_check")) != null;
    }

     @Step("Type name")
     public void enterName(String name){
        driver.findElement(new By.ById("ap_customer_name")).sendKeys(name);
     }

     @Step("Type email")
     public void enterEmail(String email){
         driver.findElement(new By.ById("ap_email")).sendKeys(email);
     }

     @Step("Type password")
     public void enterPassword(String password){
         driver.findElement(new By.ById("ap_password")).sendKeys(password);
     }

     @Step("Confirm password")
     public void reenterPassword(String password){
         driver.findElement(new By.ById("ap_password_check")).sendKeys(password);
     }

     @Step("Submit registration form")
     public void continueRegistration(){
         driver.findElement(new By.ById("continue")).click();
     }

     @Step("Fill all the fields in registration form")
     public void fillInRegistrationForm(String name, String email, String password, String passwordConfirm){
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        reenterPassword(passwordConfirm);
        continueRegistration();
     }

     @Step("Shows alert")
     public Boolean isAlert(){
         return driver.findElement(new By.ByClassName("a-alert-heading")).isDisplayed();
     }

     @Step("Get text of alert")
     public String getAlertText(){
        return driver.findElement(new By.ByCssSelector("span.a-list-item")).getText();
     }
}
