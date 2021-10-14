package com.oracle.ICICI.common.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.acs.util.BrowserDriverUtil;


public class LoginPage extends BrowserDriverUtil {
    Common_Library cmnLib = new Common_Library();
    static final Logger log = LoggerFactory.getLogger(LoginPage.class);


    @FindBy(xpath = "//input[@id='userid']")
    public WebElement UserName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement Password;

    @FindBy(xpath = "//button[contains(.,'Sign In')]")
    public WebElement SignIn;

    @FindBy(xpath = "//*[contains(@id,'UIScmil1u::icon')]")
    public static WebElement customerLogoutNameLink;

    @FindBy(linkText = "Sign Out")
    public static WebElement signoutLink;

    @FindBy(id = "Confirm")
    public static WebElement confirmButton;


    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
        log.info("LoginPage is initialized");
    }

    //HomePage
    public HomePage login(String strUserName, String strPassword) throws IOException {
        try {
            UserName.sendKeys(strUserName);
            log.info("UserName is entered");
            Password.sendKeys(strPassword);
            log.info("Password is entered");
            SignIn.click();
            log.info("SignIn is Clicked");
            cmnLib.waitForPageLoaded();
            return new HomePage();
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Signin failed");
            return null;

        }

    }


    public boolean logout() {
        boolean flag = false;
        try {
            customerLogoutNameLink.click();
            if (cmnLib.clickOnWebElement(customerLogoutNameLink) == true && (cmnLib.waitForElementToBeVisible(signoutLink))) {
                cmnLib.clickOnWebElement(signoutLink);
                log.info("CLICKED ON CUSTOMER");
            }
            cmnLib.waitForElementToBeVisible(UserName);
            log.info("LOGGED OUT OF FUSION APPLICATION SUCCESSFULLY");
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Unable to logout from the application");
        }
        return flag;
    }
}

