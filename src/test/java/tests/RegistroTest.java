package tests;

import flows.LoginFlow;
import flows.RegistroFlow;
import org.testng.annotations.Test;

public class RegistroTest {
    RegistroFlow registroFlow;
    LoginFlow loginFlow;

    @Test
    public void realizarRegistroNovoUsuario() throws InterruptedException {
        String email = "testeKaren@bugbank.com.br";
        String nome = "Teste Bug Bank";
        String senha = "123456";
        registroFlow = new RegistroFlow();
        loginFlow = new LoginFlow();

        registroFlow.registrarUsuario(email, nome, senha);
        loginFlow.logarSite(email, senha);
    }

}
