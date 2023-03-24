package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.AdicionarProdutoPage;
import pages.EditarProdutoPage;
import pages.ListaProdutosPage;
import pages.LoginPage;

import java.time.Duration;

public class Steps extends BaseClass{
    public String URl = "http://165.227.93.41/lojinha-web/v2/";
    // Abaixo é o metodo que cria o driver
    @Before
    public void iniciarDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        lp = new LoginPage(driver);
        lpp = new ListaProdutosPage(driver);
        app = new AdicionarProdutoPage(driver);
        epp = new EditarProdutoPage(driver);
    }
 // Todos os Steps de Login deve ser construidos abaixo ate chegar ao step de produtos.
    @Dado("que estou na tela de login do sistema")
    public void queEstouNaTelaDeLoginDoSistema() {
        driver.get(URl);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals("http://165.227.93.41/lojinha-web/v2/", URL);
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
        Assert.assertEquals("Boas vindas, admin!",lpp.mensagemLoginValido());
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

    // Todos os Steps de produto deve ser construidos abaixo

    @Dado("que o usuario logado no sistema")
    public void queOUsuarioLogadoNoSistema() {
        driver.get(URl);
        lp.escreverUsuario("admin");
        lp.escreverSenha("admin");
        lp.cliqueSubmitLogin();
    }
    @Dado("clique no botão Adicionar Produto")
    public void cliqueNoBotãoAdicionarProduto() {
        lpp.botaoAddProduto();
    }
    @Quando("preenche Nome do produto, valor do produto e cores do produto")
    public void preencheNomeDoProdutoValorDoProdutoECoresDoProduto() {
        app.preencherNomeProduto("Iphone");
        app.preencherValorProduto("500000");
        app.preencherCoresProduto("Azul");
    }
    @Quando("clique no botão Salvar")
    public void cliqueNoBotãoSalvar() {
        app.botaoSalvarProduto();
    }
    @Entao("O produto sera cadastrado e o usuario sera direcionado a pagina de editar produto")
    public void oProdutoSeraCadastradoEOUsuarioSeraDirecionadoAPaginaDeEditarProduto() {
        Assert.assertEquals("Editar produto", epp.paginaEditarProdutotarProduto());
    }
    @Entao("aparecera  mensagem {string}")
    public void apareceraMensagem(String string) {
        Assert.assertEquals("Produto adicionado com sucesso", epp.mensagemSucesso());
    }

    @Quando("preenche {string}, {int} e {string}")
    public void preencheE(String NomeProduto, Integer valorProduto, String corProduto) {
        if(valorProduto <= 0){
            app.preencherNomeProduto(NomeProduto);
            app.preencherValorProduto("0");
            app.preencherCoresProduto(corProduto);
        }else if(valorProduto >= 700001){
            app.preencherNomeProduto(NomeProduto);
            app.preencherValorProduto("700001");
            app.preencherCoresProduto(corProduto);
        }else if(valorProduto == null){
            app.preencherNomeProduto(NomeProduto);
            app.preencherValorProduto(null);
            app.preencherCoresProduto(corProduto);
        }
    }

    @Entao("o produto não sera cadastrado e o usuario será direcionado a pagina Lista de produtos")
    public void oProdutoNãoSeraCadastradoEOUsuarioSeráDirecionadoAPaginaListaDeProdutos() {
        Assert.assertEquals("Lista de Produtos", lpp.paginaListaProduto());
    }

    @Entao("exibira a mensagem {string}")
    public void exibiraAMensagem(String string) {
        Assert.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", lpp.mensagemInsucesso());
    }

    @After
    public void fecharDriver(){
        driver.quit();
    }
}