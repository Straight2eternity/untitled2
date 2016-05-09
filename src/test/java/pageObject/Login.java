package pageObject;

import static com.codeborne.selenide.Selenide.$;

public class Login {
    public void logginIn(String login, String password){
        $("#username").setValue(login);
        $("#password").setValue(password);
        $(".radius").click();

    }
}


