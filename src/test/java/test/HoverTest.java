package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Администратор on 09.05.2016.
 */
public class HoverTest {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/hovers");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test
    public void Hover() {
        Actions actions = new Actions(driver);
        List<WebElement> ava = driver.findElements(By.cssSelector("img[alt='User Avatar']"));
        actions.moveToElement(ava.get(2)).build().perform();

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"figure\"][3]"))
                .findElement(By.cssSelector("div a")).isDisplayed());
    }
}
