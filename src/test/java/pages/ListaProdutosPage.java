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

    @FindBy(css = ".btn:nth-child(1)")
    WebElement botaoSalvarProduto;

    @FindBy(id = "produtonome")
    WebElement txtNomeProduto;

    @FindBy(id = "produtovalor")
    WebElement txtValorProduto;

    @FindBy(id = "produtocores")
    WebElement txtCoresProduto;

    @FindBy(css = ".m4>.row:nth-child(1)")
    WebElement paginaEditarProduto;

    @FindBy(css = ".toast")
    WebElement mensagemSucesso;

    @FindBy(css = "h3")
    WebElement paginaListaProduto;

    @FindBy(css = ".toast")
    WebElement mensagemInsucesso;

    public void botaoAddProduto(){
        botaoAddProduto.click();
    }

    public void botaoSalvarProduto(){
        botaoSalvarProduto.click();
    }

    public void preencherNomeProduto(String nomeProduto){
        txtNomeProduto.sendKeys(nomeProduto);
    }

    public void preencherValorProduto(String valorProduto){
        txtValorProduto.sendKeys(valorProduto);
    }

    public void preencherCoresProduto(String coresProduto){
        txtCoresProduto.sendKeys(coresProduto);
    }

    public String paginaEditarProdutotarProduto(){
        return paginaEditarProduto.getText();
    }

    public String mensagemSucesso(){
        return mensagemSucesso.getText();
    }

    public String paginaListaProduto(){
        return paginaListaProduto.getText();
    }

    public String mensagemInsucesso(){
        return mensagemInsucesso.getText();
    }
}