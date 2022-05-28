package modules.signup;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.time.Duration;

@DisplayName("Signup module web tests")
public class SignupTest {
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
    @DisplayName("Should be signup with sucess")
    public void testRegisterANewUserWithSucess() {
        String expectMessage = new LoginPage(driver)
                .navigateToPageSignup()
                .fillDataFields("Kennedy Silva de Oliveira", "kennedy@automacao.com", "pwd123")
                .submitRegisterForm()
                .captureMessage();

        Assertions.assertEquals("Agora você se tornou um(a) Samurai, faça seu login para ver seus agendamentos!", expectMessage);
    }

    @Test
    @DisplayName("Field name is required")
    public void testNameIsRequired() {
        String nameIsRequired = new LoginPage(driver)
                .navigateToPageSignup()
                .submitButtonRegisterFormWithEmptyFields()
                .verifyAlertMessageNameIsRequired();

        Assertions.assertEquals("Nome é obrigatório", nameIsRequired);
    }

    @Test
    @DisplayName("Field email is required")
    public void testEmailIsRequired() {
        String emailIsRequired = new LoginPage(driver)
                .navigateToPageSignup()
                .submitButtonRegisterFormWithEmptyFields()
                .verifyAlertMessageEmailIsRequired();

        Assertions.assertEquals("E-mail é obrigatório", emailIsRequired);
    }

    @Test
    @DisplayName("Field password is required")
    public void testPasswordIsRequired() {
        String passIsRequired = new LoginPage(driver)
                .navigateToPageSignup()
                .submitButtonRegisterFormWithEmptyFields()
                .verifyAlertMessagePasswordIsRequired();

        Assertions.assertEquals("Senha é obrigatória", passIsRequired);
    }

    @Test
    @DisplayName("Email should be valid")
    public void testEmailShouldBeValid() {
        String emailIncorrect = new LoginPage(driver)
                .navigateToPageSignup()
                .fillDataFields("Kennedy Silva de Oliveira", "kennedy.automacao.com", "pwd123")
                .submitRegisterFormWithDataIncorrect()
                .verifyAlertMessageEmailIsIncorrect();

        Assertions.assertEquals("Informe um email válido", emailIncorrect);
    }

    @Test
    @DisplayName("Password should not be curt")
    public void testPasswordCurt() {
        String curtPass = new LoginPage(driver)
                .navigateToPageSignup()
                .fillDataFields("Kennedy Silva de Oliveira", "kennedy@automacao.com", "pwd12")
                .submitRegisterFormWithDataIncorrect()
                .verifyAlertMessageCurtPass();

        Assertions.assertEquals("Pelo menos 6 caracteres", curtPass);
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }
}
