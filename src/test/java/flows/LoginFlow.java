package flows;

import pages.HomePage;
import pages.LoginPage;

public class LoginFlow {

    LoginPage loginPage;
    HomePage homePage;

    public String logarSite (String email,String senha) {
        loginPage = new LoginPage();
        homePage = new HomePage();

        loginPage.setEmail(email);
        loginPage.setSenha(senha);
        loginPage.entrar();
        String numeroConta = homePage.consultaNumeroContaTelaInicial();

        return numeroConta;
    }
}
