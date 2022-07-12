package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.Utils.takeScreenshot;

public class SignupPage {
    private WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignupPage fillDataFields(String name, String email, String password) {
        driver.findElement(By.cssSelector("input[placeholder^=Nome]")).sendKeys(name);
        driver.findElement(By.cssSelector("input[placeholder$=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("input[placeholder*=senha]")).sendKeys(password);
        takeScreenshot(driver, "/signupTest/evidencia");
        return this;
    }

    public SignupPage submitRegisterFormWithDataIncorrect() {
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        return this;
    }

    public LoginPage submitRegisterForm() {
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        return new LoginPage(driver);
    }

    public String verifyAlertMessageCurtPass() {
        takeScreenshot(driver, "/signupTest/evidencia");
        return driver.findElement(By.xpath("//div//small[contains(text(),'Pelo menos 6 caracteres')]")).getText();
    }

    public String verifyAlertMessageNameIsRequired() {
        takeScreenshot(driver, "/signupTest/evidencia");
        return driver.findElement(By.xpath("//div//small[contains(text(), 'Nome é obrigatório')]")).getText();
    }

    public String verifyAlertMessageEmailIsRequired() {
        takeScreenshot(driver, "/signupTest/evidencia");
        return driver.findElement(By.xpath("//div//small[contains(text(), 'E-mail é obrigatório')]")).getText();
    }

    public String verifyAlertMessagePasswordIsRequired() {
        takeScreenshot(driver, "/signupTest/evidencia");
        return driver.findElement(By.xpath("//div//small[contains(text(), 'Senha é obrigatória')]")).getText();
    }

    public String verifyAlertMessageEmailIsIncorrect() {
        takeScreenshot(driver, "/signupTest/evidencia");
        return driver.findElement(By.xpath("//div//small[contains(text(), 'Informe um email válido')]")).getText();
    }

    public SignupPage submitButtonRegisterFormWithEmptyFields() {
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        return this;
    }

}
