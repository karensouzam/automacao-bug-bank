package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {

    LoginPage loginPage;

    @Test
    public void realizarLogin() {

        loginPage = new LoginPage();
        loginPage.setEmail("testeKaren@bugbank.com.br");
        loginPage.setSenha("123456");
        loginPage.entrar();
    }

}
