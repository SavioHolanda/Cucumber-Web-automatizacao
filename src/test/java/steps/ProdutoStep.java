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
import pages.ListaProdutosPage;
import pages.LoginPage;

import java.time.Duration;

public class ProdutoStep {

    public WebDriver driver;
    public LoginPage lp;
    public ListaProdutosPage pp;

    @Before
    public void criarDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://165.227.93.41/lojinha-web/v2/");
        lp = new LoginPage(driver);
        pp = new ListaProdutosPage(driver);
    }

    @Dado("que o usuario logado no sistema")
    public void queOUsuarioLogadoNoSistema() {
        lp.escreverUsuario("admin");
        lp.escreverSenha("admin");
        lp.cliqueSubmitLogin();
    }
    @Dado("clique no botão Adicionar Produto")
    public void cliqueNoBotãoAdicionarProduto() {
        pp.botaoAddProduto();
    }
    @Quando("preenche Nome do produto, valor do produto e cores do produto")
    public void preencheNomeDoProdutoValorDoProdutoECoresDoProduto() {
        pp.preencherNomeProduto("Iphone");
        pp.preencherValorProduto("500000");
        pp.preencherCoresProduto("Azul");
    }
    @Quando("clique no botão Salvar")
    public void cliqueNoBotãoSalvar() {
        pp.botaoSalvarProduto();
    }
    @Entao("O produto sera cadastrado e o usuario sera direcionado a pagina de editar produto")
    public void oProdutoSeraCadastradoEOUsuarioSeraDirecionadoAPaginaDeEditarProduto() {
        Assert.assertEquals("Editar produto", pp.paginaEditarProdutotarProduto());
    }
    @Entao("aparecera  mensagem {string}")
    public void apareceraMensagem(String string) {
        Assert.assertEquals("Produto adicionado com sucesso", pp.mensagemSucesso());
    }

    @Quando("preenche {string}, {int} e {string}")
    public void preencheE(String NomeProduto, Integer valorProduto, String corProduto) {
        if(valorProduto <= 0){
            pp.preencherNomeProduto(NomeProduto);
            pp.preencherValorProduto("0");
            pp.preencherCoresProduto(corProduto);
        }else if(valorProduto >= 700001){
            pp.preencherNomeProduto(NomeProduto);
            pp.preencherValorProduto("700001");
            pp.preencherCoresProduto(corProduto);
        }else if(valorProduto == null){
            pp.preencherNomeProduto(NomeProduto);
            pp.preencherValorProduto(null);
            pp.preencherCoresProduto(corProduto);
        }
    }

    @Entao("o produto não sera cadastrado e o usuario será direcionado a pagina Lista de produtos")
    public void oProdutoNãoSeraCadastradoEOUsuarioSeráDirecionadoAPaginaListaDeProdutos() {
        Assert.assertEquals("Lista de Produtos", pp.paginaListaProduto());
    }

    @Entao("exibira a mensagem {string}")
    public void exibiraAMensagem(String string) {
        Assert.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", pp.mensagemInsucesso());
    }

    @After
    public void after(){
        driver.close();
    }
}