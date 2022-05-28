package modules.signup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.SignupPage;

import java.time.Duration;
import java.util.List;

@DisplayName("Testes Web do Módulo de Cadastro")
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
    @DisplayName("Deve registrar um usuário com sucesso")
    public void testRegisterANewUserWithSucess() {
        String expectMessage = new LoginPage(driver)
                .navigateToPageSignup()
                .fillDataFields()
                .submitRegisterForm()
                .captureMessage();

        Assertions.assertEquals("Agora você se tornou um(a) Samurai, faça seu login para ver seus agendamentos!", expectMessage);
    }

    @Test
    @DisplayName("Campo nome é obrigatório")
    public void testNameIsRequired() {
        String nameIsRequired = new LoginPage(driver)
                .navigateToPageSignup()
                .submitButtonRegisterFormWithEmptyFields()
                .verifyAlertMessageNameIsRequired();

        Assertions.assertEquals("Nome é obrigatório", nameIsRequired);
    }

    @Test
    @DisplayName("Campo email é obrigatório")
    public void testEmailIsRequired() {
        String emailIsRequired = new LoginPage(driver)
                .navigateToPageSignup()
                .submitButtonRegisterFormWithEmptyFields()
                .verifyAlertMessageEmailIsRequired();

        Assertions.assertEquals("E-mail é obrigatório", emailIsRequired);
    }

    @Test
    @DisplayName("Campo senha é obrigatório")
    public void testPasswordIsRequired() {
        String passIsRequired = new LoginPage(driver)
                .navigateToPageSignup()
                .submitButtonRegisterFormWithEmptyFields()
                .verifyAlertMessagePasswordIsRequired();

        Assertions.assertEquals("Senha é obrigatória", passIsRequired);
    }

    @Test
    @DisplayName("Email deve ser válido")
    public void testEmailShouldBeValid() {
        String emailIncorrect = new LoginPage(driver)
                .navigateToPageSignup()
                .fillDataFieldsWithEmailIncorrect()
                .submitRegisterFormWithDataIncorrect()
                .verifyAlertMessageEmailIsIncorrect();

        Assertions.assertEquals("Informe um email válido", emailIncorrect);
    }

    @Test
    @DisplayName("Senha deve ter pelo menos 6 caractéres")
    public void testPasswordCurt() {
        String curtPass = new LoginPage(driver)
                .navigateToPageSignup()
                .fillDataFieldsWithCurtPassword()
                .submitRegisterFormWithDataIncorrect()
                .verifyAlertMessageCurtPass();

        Assertions.assertEquals("Pelo menos 6 caracteres", curtPass);
    }
}
