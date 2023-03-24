package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditarProdutoPage {
    public WebDriver driver;
    public EditarProdutoPage (WebDriver sdriver){
        driver = sdriver;
        PageFactory.initElements(sdriver, this);
    }
    @FindBy(css = ".m4>.row:nth-child(1)")
    WebElement paginaEditarProduto;
    @FindBy(css = ".toast")
    WebElement mensagemSucesso;
    public String paginaEditarProdutotarProduto(){
        return paginaEditarProduto.getText();
    }
    public String mensagemSucesso(){
        return mensagemSucesso.getText();
    }
}