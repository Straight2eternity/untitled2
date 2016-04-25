package testPO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.Login;
import pageObject.Secure;

import java.util.concurrent.TimeUnit;

import static org.testng.annotations.AfterTest.*;

/**
 * Created by Администратор on 21.04.2016.
 */
public class LoginTests {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/login");
    }


    @Test
    public void loginTest1() throws InterruptedException {
        Login loginPage = new Login(driver);
        loginPage.logginIn("tomsmith", "SuperSecretPassword!");

        Secure SecurePage = new Secure(driver);
        Assert.assertTrue(SecurePage.isLoggedIn());
    }

    @Test
    public void loginTest2() {
        //driver.get("http://the-internet.herokuapp.com/login"); //Still impossible without this one
        Login loginPage = new Login(driver);
        loginPage.typeLogin("tomsmith")
            .typePass("SuperSecretPassword!")
            .clickLogin();

        Secure SecurePage = new Secure(driver);
        Assert.assertTrue(SecurePage.isLoggedIn());
    }


    @AfterMethod
    public void goNext1() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/login");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
