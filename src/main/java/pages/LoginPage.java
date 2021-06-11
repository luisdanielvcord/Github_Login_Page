package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameField = By.id("login_field");
    private final By passwordField = By.id("password");
    private final By signInButton = By.name("commit");
    private final By forgotPasswordLink = By.linkText("Forgot password?");
    private final By createAccountLink = By.partialLinkText("Create an account");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        elementVisible(usernameField).sendKeys(username);
        find(passwordField).sendKeys(password);
        find(signInButton).click();
    }

    public void forgotPassword() {
        elementVisible(forgotPasswordLink).click();
    }

    public void createAccount() {
        elementVisible(createAccountLink).click();
    }

    public String getPageUrl() {
        return getUrl();
    }
}
