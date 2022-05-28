package modules.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest {

    private WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        // Configuração do chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver\\chromedriver.exe" );
        this.driver = new ChromeDriver();

        // Maximizar navegador
        this.driver.manage().window().maximize();

        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navegar até a lojinha
        this.driver.get("https://samuraibs-web-kennedy.herokuapp.com");
    }

    @Test
    @DisplayName("Deve fazer login com sucesso")
    public void testAuthenticateWithSucess() {
        String userLogged = new LoginPage(driver)
                .fillCredentials()
                .submitCredentials()
                .verifyUserLogged();

        Assertions.assertEquals("Kennedy Silva de Oliveira", userLogged);
    }
}
