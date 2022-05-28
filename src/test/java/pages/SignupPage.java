package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    private WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignupPage fillDataFields(String name, String email, String password) {
        driver.findElement(By.cssSelector("input[placeholder^=Nome]")).sendKeys(name);
        driver.findElement(By.cssSelector("input[placeholder$=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("input[placeholder*=senha]")).sendKeys(password);

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
        return driver.findElement(By.xpath("//div//small[contains(text(),'Pelo menos 6 caracteres')]")).getText();
    }

    public String verifyAlertMessageNameIsRequired() {
        return driver.findElement(By.xpath("//div//small[contains(text(), 'Nome é obrigatório')]")).getText();
    }

    public String verifyAlertMessageEmailIsRequired() {
       return driver.findElement(By.xpath("//div//small[contains(text(), 'E-mail é obrigatório')]")).getText();
    }

    public String verifyAlertMessagePasswordIsRequired() {
       return driver.findElement(By.xpath("//div//small[contains(text(), 'Senha é obrigatória')]")).getText();
    }

    public String verifyAlertMessageEmailIsIncorrect() {
        return driver.findElement(By.xpath("//div//small[contains(text(), 'Informe um email válido')]")).getText();
    }

    public SignupPage submitButtonRegisterFormWithEmptyFields() {
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        return this;
    }

}
