package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    By loginInput = By.id("username");
    By passInput = By.id("password");
    By loginButton = By.cssSelector("button.radius");

    public WebDriver _driver;

    public Login(WebDriver driver){
        _driver = driver;
    }

    public void logginIn(String login,String password){
        _driver.findElement(loginInput).sendKeys(login);
        _driver.findElement(passInput).sendKeys(password);
        _driver.findElement(loginButton).click();
    }
}