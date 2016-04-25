package testPF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageFactory.Login;
import pageObject.Secure;

public class LoginTests {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/login");
    }

    @Test
    public void loginTest1(){
        Login login1 = PageFactory.initElements(driver, Login.class);

        login1.logginIn("tomsmith", "SuperSecretPassword!");

        Secure SecurePage = new Secure(driver);
        Assert.assertTrue(SecurePage.isLoggedIn());
    }
}