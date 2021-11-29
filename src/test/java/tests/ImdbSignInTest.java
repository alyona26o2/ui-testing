package tests;

import pages.ImdbSignInPage;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Sign In")
public class ImdbSignInTest {
    private final ImdbSignInPage signInPage = new ImdbSignInPage();

    @Test
    @DisplayName("Should open create account form ")
    public void openSignInPage(){
        signInPage.openImdb();
        signInPage.openSignInPage();
        signInPage.createNewAccountClick();
        assertTrue(signInPage.isFormDisplayed());
    }

    @Test
    @DisplayName("Alert must occur")
    public void signInTest(){
        signInPage.openImdb();
        signInPage.openSignInPage();
        signInPage.createNewAccountClick();
        signInPage.fillInRegistrationForm("1111", "@1111", "qwerty", "qwerty");
        assertTrue(signInPage.isAlert());
    }

    @Test
    @DisplayName("Alert about invalid email must occur")
    public void signInTestWithInvalidEmail(){
        signInPage.openImdb();
        signInPage.openSignInPage();
        signInPage.createNewAccountClick();
        signInPage.fillInRegistrationForm("alyona", "@1111", "qwerty", "qwerty");
        String alert = signInPage.getAlertText();
        assertEquals(alert, "Enter a valid email address");
    }

    @Test
    @DisplayName("Alert about invalid password must occur")
    public void signInTestWithInvalidPassword(){
        signInPage.openImdb();
        signInPage.openSignInPage();
        signInPage.createNewAccountClick();
        signInPage.fillInRegistrationForm("alyona", "alyona@gmail.com", "qwerty", "12345qwerty");
        String alert = signInPage.getAlertText();
        assertEquals(alert, "Passwords must match");
    }
}
