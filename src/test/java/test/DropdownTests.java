package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * Created by Администратор on 09.05.2016.
 */
public class DropdownTests {
    public WebDriver driver;

    @Test
    public void Option1Test() throws Exception {
        WebElement selected = driver.findElement(By.xpath("//*[@id='dropdown']/option[2]")); //no idea how to Assert non-text this way
        Assert.assertEquals(selected.getText(),"Option 1");
    }

    @Test
    public void Option2Test() throws Exception {
        WebElement selected = driver.findElement(By.xpath("//*[@id='dropdown']/option[3]"));
        Assert.assertEquals(selected.getText(),"Option 2");
    }

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dropdown");

    }
    @AfterMethod
    public void goNext1(){
        driver.get("http://the-internet.herokuapp.com/dropdown");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
