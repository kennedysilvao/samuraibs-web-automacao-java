package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignupPage navigateToPageSignup() {
        driver.findElement(By.cssSelector("a[href='/signup']")).click();

        return new SignupPage(driver);
    }

    public String captureMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='toast'] p")));
        return driver.findElement(By.cssSelector("div[class*='toast'] p")).getText();
    }

    public LoginPage fillCredentials(String email, String pass) {
        driver.findElement(By.cssSelector("input[placeholder='Seu email']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[placeholder$=secreta]")).sendKeys(pass);

        return this;
    }

    public DashPage submitCredentials() {
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        return new DashPage(driver);
    }

}
