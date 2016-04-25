package pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Secure {

    By greenMessage = By.id("flash");

    public WebDriver _driver;

    public Secure(WebDriver driver){
        _driver = driver;
    }

    public  boolean isLoggedIn(){
        return _driver.findElement(greenMessage).isDisplayed();
    }
}
