package steps;


import io.cucumber.java.PendingException;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Login {
    private WebDriver driver;
    @Dado("^que acesso o site$")
    public void queAcessoOSite() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.get("https://www.google.com");
    }

    @E("^clico no login$")
    public void clicoNoLogin() {
    }

    @Quando("^coloco \"([^\"]*)\" e \"([^\"]*)\"$")
    public void colocoE(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Então("^é exibido  a tela de dashborad$")
    public void éExibidoATelaDeDashborad() {
        driver.close();
    }
}
