package steps;

import org.openqa.selenium.WebDriver;
import pages.AdicionarProdutoPage;
import pages.EditarProdutoPage;
import pages.ListaProdutosPage;
import pages.LoginPage;

public class BaseClass {
    public WebDriver driver;
    public LoginPage lp;
    public ListaProdutosPage lpp;
    public ListaProdutosPage pp;
    public AdicionarProdutoPage app;
    public EditarProdutoPage epp;
}
