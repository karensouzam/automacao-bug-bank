package pages;

import core.PageBase;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {

    //Mapping
    By campoLogin = By.name("email");
    By campoPassword = By.name("password");
    By botaoAcessar = By.xpath("//*[@id=\"__next\"]//div[2]//div[1]/form/div[3]/button[1]");

    //Actions
    public void setEmail(String texto){ sendKeys(campoLogin, texto); }

    public void setSenha (String password){
        sendKeys(campoPassword, password);
    }

    public void entrar() { click(botaoAcessar); }

}
