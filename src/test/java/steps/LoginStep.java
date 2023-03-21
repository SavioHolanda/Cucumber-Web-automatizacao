package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;

import java.time.Duration;

public class LoginStep {
    public WebDriver driver;
    public LoginPage lp;

    @Before
    public void criarDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        lp= new LoginPage(driver);
    }
    @Dado("que estou na tela de login do sistema")
    public void queEstouNaTelaDeLoginDoSistema() {
        driver.get("http://165.227.93.41/lojinha-web/v2/");
    }

    @Quando("preencho o usuario e senha")
    public void preenchoOUsuarioESenha() {
        lp.escreverUsuario("admin");
        lp.escreverSenha("admin");
    }
    @Quando("clico em Entrar")
    public void clicoEmEntrar() {
        lp.cliqueSubmitLogin();
    }
    @Entao("acesso a tela principal do sistema")
    public void acessoATelaPrincipalDoSistema() {
        Assert.assertEquals("Boas vindas, admin!",lp.mensagemLoginValido());
    }

    @Quando("preencho o usuario e senha invalidos")
    public void preenchoOUsuarioESenhaInvalidos() {
        lp.escreverUsuario("admin");
        lp.escreverSenha("123");
    }
    @Entao("apresenta uma mensagem {string}")
    public void apresentaUmaMensagem(String mensagem) {
        Assert.assertEquals(mensagem, lp.mensagemLoginInvalido());
    }
    @Entao("continua na tela de login")
    public void continuaNaTelaDeLogin() {
        Assert.assertEquals(lp.telaLogin(),"Acessar a Lojinha");
    }

    @Quando("preencho o usuario e senha em branco")
    public void preenchoOUsuarioESenhaEmBranco() {
        lp.escreverUsuario(" ");
        lp.escreverSenha(" ");
    }

    @After
    public void after(){
        driver.close();
    }
}