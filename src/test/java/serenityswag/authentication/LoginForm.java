package serenityswag.authentication;

import org.openqa.selenium.By;

class LoginForm {
    static By USER_NAME = By.cssSelector("[data-test='username']");
    static By PASSWORD = By.cssSelector("[data-test='password']");
    static By LOGIN_BUTTON = By.cssSelector("[data-test='login-button']");
}
