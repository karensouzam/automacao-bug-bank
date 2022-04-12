package pages;

import core.DriverFactory;
import core.PageBase;
import org.openqa.selenium.By;

public class RegistroPage extends PageBase {

    //Mapping
    String baseUrl = "https://bugbank.netlify.app/";
    By botaoRegistrar = By.xpath("//*[@id=\"__next\"]//div[2]//div[1]/form/div[3]/button[2]");
    By campoEmail = By.id("inputEmail");
    By campoNome = By.id("inputName");
    By campoSenha = By.id("inputPassword");
    By campoConfirmarSenha = By.id("inputPasswordConfirmation");
    By botaoCadastrar = By.id("btnRegister");
    By frame = By.xpath("//*[@id=\"__next\"]/div/div[3]/div");
    By botaoFechar = By.id("btnCloseModal");
    By botaoSaldo = By.id("toggleAddBalance");

    //Actions
    public void acessarTelaInicial() {
        DriverFactory.getDriver().navigate().to(baseUrl);
    }

    public void setEmail(String texto){
        sendKeys(campoEmail, texto);
    }

    public void setNome(String texto){
        sendKeys(campoNome, texto);
    }

    public void setSenha(String texto){
        sendKeys(campoSenha, texto);
    }

    public void setConfirmarSenha(String texto){
        sendKeys(campoConfirmarSenha, texto);
    }

    public void registrar() {
        click(botaoRegistrar);
    }

    public void colocarSaldo(){clickCheckBox(botaoSaldo);}

    public void cadastrar() {
        click(botaoCadastrar);
    }

    public void fechar() { click(botaoFechar); }
}
