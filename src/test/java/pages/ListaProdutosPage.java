package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListaProdutosPage {
    public WebDriver driver;
    public ListaProdutosPage(WebDriver sdriver){
        driver = sdriver;
        PageFactory.initElements(sdriver, this);
    }

    @FindBy(css = ".waves-effect")
    WebElement botaoAddProduto;

    @FindBy(css = "h3")
    WebElement paginaListaProduto;

    @FindBy(css = ".toast")
    WebElement mensagemInsucesso;

    @FindBy(css = ".grey")
    WebElement cliqueBotaoLista;

    @FindBy(linkText = "Boas vindas, admin!")
    WebElement mensagemLoginValido;

    public void botaoAddProduto(){
        botaoAddProduto.click();
    }

    public String paginaListaProduto(){
        return paginaListaProduto.getText();
    }

    public String mensagemInsucesso(){
        return mensagemInsucesso.getText();
    }

    public String mensagemLoginValido(){
        return mensagemLoginValido.getText();
    }
}