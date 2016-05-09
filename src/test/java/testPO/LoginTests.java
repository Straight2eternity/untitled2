package testPO;

import com.codeborne.selenide.Condition;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.Login;

import static com.codeborne.selenide.Selenide.*;

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
    public void loginTest1(){
        login.logginIn("tomsmith","SuperSecretPassword!");
        $("#flash").shouldBe(Condition.visible);
    }

    @Test
    public void loginTest2(){
        login.logginIn("tomsmith1","SuperSecretPassword!");
        $("#flash").shouldNotBe(Condition.visible);
    }

}
