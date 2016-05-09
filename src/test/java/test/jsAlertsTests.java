package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class jsAlertsTests {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test
    public void JsAlerts1() throws InterruptedException {
        driver.findElement(By.xpath("html/body/div[2]/div/div/ul/li[1]/button")).click();
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='result']")).isDisplayed());
    }

    @Test
    public void JsAlerts2() {
        driver.findElement(By.xpath("html/body/div[2]/div/div/ul/li[2]/button")).click();
        driver.switchTo().alert().dismiss();
        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='result']")).isDisplayed());
    }

    @Test
    public void JsAlerts3() {
        driver.findElement(By.xpath("html/body/div[2]/div/div/ul/li[3]/button")).click();
        driver.switchTo().alert().sendKeys("Hello, Vitaly");
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='result']")).isDisplayed());
    }

    @Test
    public void JsAlerts4() {
        driver.findElement(By.xpath("html/body/div[2]/div/div/ul/li[3]/button")).click();
        driver.switchTo().alert().sendKeys("Hello, Vitaly");
        driver.switchTo().alert().dismiss();
        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='result']")).isDisplayed());
    }

    @Test
    public void JsAlerts5() {
        driver.findElement(By.xpath("html/body/div[2]/div/div/ul/li[2]/button")).click();
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='result']")).isDisplayed());
    }

}
