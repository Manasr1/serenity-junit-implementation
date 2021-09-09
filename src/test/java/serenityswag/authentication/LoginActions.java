package serenityswag.authentication;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class LoginActions extends UIInteractionSteps {

    @Step("login as a {0}")
    public void as(User user) {

        openUrl("https://www.saucedemo.com/");

        // login as a standard user
        $(LoginForm.USER_NAME).sendKeys(user.getUserName());
        $(LoginForm.PASSWORD).sendKeys(user.getPassword());
        $(LoginForm.LOGIN_BUTTON).click();
    }
}
