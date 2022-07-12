package modules.login;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.HTMLReporter;
import database.Database;
import factories.browserFactory.BrowserFactory;
import factories.usuarioFactory.UsuarioDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

import static io.restassured.RestAssured.*;

@DisplayName("Login module web tests")
public class LoginTest {
    private static Database db = new Database();
    private BrowserFactory navegador = new BrowserFactory();
    private WebDriver driver;

    @BeforeAll
    public static void setup() {

        try {
            db.deleteUser("kennedy@automacao.com");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        baseURI = "https://samuraibs-api-kennedy.herokuapp.com";
        basePath = "/";

        given()
                .contentType(ContentType.JSON)
                .body(UsuarioDataFactory.userData())
                .when()
                .post("/users")
                .then()
                .statusCode(200);
    }

    @BeforeEach
    public void beforeEach() {
        // Configuração do chrome driver
        navegador.chooseBrowser("webdriver.chrome.driver", "C:\\drivers\\chromedriver\\chromedriver.exe" );
//        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver\\chromedriver.exe");
        this.driver = new ChromeDriver();

        // Maximizar navegador
        this.driver.manage().window().maximize();

        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navegar até a lojinha
        this.driver.get("https://samuraibs-web-kennedy.herokuapp.com");
    }

    @Test
    @DisplayName("Should be login with sucess")
    public void testAuthenticateWithSucess() throws IOException {
        String userLogged = new LoginPage(driver)
                .fillCredentials(UsuarioDataFactory.userData().getEmail(), UsuarioDataFactory.userData().getPassword())
                .submitCredentials()
                .verifyUserLogged();

        System.out.println(LoginTest.class);
        Assertions.assertEquals("Kennedy Silva de Oliveira", userLogged);
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }
}
