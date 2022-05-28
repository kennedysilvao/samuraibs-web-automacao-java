package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashPage {
    private WebDriver driver;

    public DashPage(WebDriver driver) {
        this.driver = driver;
    }

    public String verifyUserLogged() {
        return driver.findElement(By.cssSelector("a strong")).getText();
    }
}
