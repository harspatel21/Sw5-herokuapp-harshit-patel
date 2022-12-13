package com.herokuapp.pages;

import com.herokuapp.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

/**
 * Created by Harshit Patel
 */
public class LoginPage extends Utility {


    @CacheLookup
    @FindBy(id = "username")
    WebElement userNameBox;

    @CacheLookup
    @FindBy(id = "password")
    WebElement userPasswordbox;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h2[text()=' Secure Area']")
    WebElement secureAreaText;

    @CacheLookup
    @FindBy(xpath = "//div[@id='flash-messages']")
    WebElement invalidCredentialMessage;


    public void enterUserName(String userNameText) {
        Reporter.log("Enter User Name " + userNameBox + " in to username field " + userNameBox.toString());
        sendTextToElement(userNameBox, userNameText);
    }

    public void enterPassword(String passwordText) {
        Reporter.log("Enter Password" + userPasswordbox + " into Password Field " + userPasswordbox.toString());
        sendTextToElement(userPasswordbox, passwordText);
    }

    public void clickOnLoginButton() {
        Reporter.log("Click on Login Button" + loginButton.toString());
        clickOnElement(loginButton);
    }

    public String getSecureAreaText() {
        Reporter.log("Get Secure Area Text " + secureAreaText.toString());
        return getTextFromElement(secureAreaText);
    }

    public String invalidUserAndPasswordMessage() {
        Reporter.log("Verify Invalid Credential Message" + invalidCredentialMessage.toString());
        return getTextFromElement(invalidCredentialMessage).substring(0, 25);
    }

}
