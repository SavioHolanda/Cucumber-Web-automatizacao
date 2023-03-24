package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdicionarProdutoPage {
    public WebDriver driver;
    public AdicionarProdutoPage(WebDriver sdriver){
        driver = sdriver;
        PageFactory.initElements(sdriver, this);
    }

    @FindBy(id = "produtonome")
    WebElement txtNomeProduto;

    @FindBy(id = "produtovalor")
    WebElement txtValorProduto;

    @FindBy(id = "produtocores")
    WebElement txtCoresProduto;

    @FindBy(css = ".btn:nth-child(1)")
    WebElement botaoSalvarProduto;

    public void preencherNomeProduto(String nomeProduto){
        txtNomeProduto.sendKeys(nomeProduto);
    }

    public void preencherValorProduto(String valorProduto){
        txtValorProduto.sendKeys(valorProduto);
    }

    public void preencherCoresProduto(String coresProduto){
        txtCoresProduto.sendKeys(coresProduto);
    }

    public void botaoSalvarProduto(){
        botaoSalvarProduto.click();
    }
}