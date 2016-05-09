package test;

import com.codeborne.selenide.Condition;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PO.Login;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

/**
 * Created by Администратор on 21.04.2016.
 */
public class LoginTests {

     Login login = new Login();

    @BeforeTest
    public void setup() {
        open("http://the-internet.herokuapp.com/login");
    }

    @AfterMethod
    public void goNext1(){
        open("http://the-internet.herokuapp.com/login");
    }

    @AfterClass
    public void tearDown(){
        close();
    }

    @Test
    public void loginTest1() throws InterruptedException {
        Thread.sleep(1000);
        login.logginIn("tomsmith","SuperSecretPassword!");
        $("#flash").shouldBe(Condition.visible);
    }

    @Test
    public void loginTest2() throws InterruptedException {
        login.logginIn("tomsmith1","SuperSecretPassword!");
        $("#flash").shouldNotBe(Condition.visible);
    }

    @Test
    public void loginTest3() throws InterruptedException {
        login.logginIn("tomsmith","SuperSecretPassword!");
        Thread.sleep(5000);
        assertEquals("http://the-internet.herokuapp.com/secure",url());
    }

    @Test
    public void loginTest4() throws InterruptedException {
        login.logginIn("tomsmit1h","SuperSecretPassword!");
        Thread.sleep(5000);
        assertEquals("http://the-internet.herokuapp.com/login",url());
    }
}
