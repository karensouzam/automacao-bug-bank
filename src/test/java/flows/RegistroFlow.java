package flows;

import pages.RegistroPage;

public class RegistroFlow {
    RegistroPage registroPage;

    public void registrarUsuario(String email, String nome, String senha) {

        registroPage = new RegistroPage();
        registroPage.acessarTelaInicial();
        registroPage.registrar();
        registroPage.setEmail(email);
        registroPage.setNome(nome);
        registroPage.setSenha(senha);
        registroPage.setConfirmarSenha(senha);
        registroPage.colocarSaldo();
        registroPage.cadastrar();
        registroPage.fechar();
    }
}
