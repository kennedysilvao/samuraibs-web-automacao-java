package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

import java.io.IOException;

import static utils.Utils.takeScreenshot;

public class DashPage {
    private WebDriver driver;

    public DashPage(WebDriver driver) {
        this.driver = driver;
    }
    private Utils utils = new Utils();
    public String verifyUserLogged() throws IOException {
        String texto = driver.findElement(By.cssSelector("a strong")).getText();
        takeScreenshot(driver, "/loginTest/evidencia");
        return texto;
    }
}
