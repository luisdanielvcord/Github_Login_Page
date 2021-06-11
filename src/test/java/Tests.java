import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BasePage;
import pages.LoginPage;
import utilities.DriverSetup;

public class Tests {

    private final String username = "use_your_github_username";
    private final String password = "use_your_github_password";
    private WebDriver driver;
    private DriverSetup driverSetup;

    @BeforeMethod
    public void setup() {
        driverSetup = new DriverSetup();
        driver = driverSetup.getWebDriver();
        driver.get("https://www.github.com/login");
    }

    @Test
    public void validLogin() {
        //Given
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        //When
        loginPage.login(username, password);

        //Then
        Assert.assertEquals(loginPage.getPageUrl(), "https://github.com/");
    }

    @Test
    public void invalidLogin() {
        //Given
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        //When
        loginPage.login("joedoe25@protonmail.com", "DoeJoe25");

        //Then
        Assert.assertEquals(loginPage.getPageUrl(), "https://github.com/session");
    }

    @Test
    public void resetPassword() {
        //Given
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        //When
        loginPage.forgotPassword();

        //Then
        Assert.assertEquals(loginPage.getPageUrl(), "https://github.com/password_reset");
    }

    @Test
    public void createAccount() {
        //Given
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        //When
        loginPage.createAccount();

        //Then
        Assert.assertEquals(loginPage.getPageUrl(), "https://github.com/join?source=login");
    }

    @AfterMethod
    public void closeDriver() {
        driverSetup.closeDriver();
    }

    @AfterSuite
    public void quitDriver() {
        driverSetup.quitDriver();
    }
}
