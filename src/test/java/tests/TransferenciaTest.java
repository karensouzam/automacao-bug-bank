package tests;

import flows.HomeFlow;
import flows.LoginFlow;
import flows.RegistroFlow;
import flows.TransferenciaFlow;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static core.DriverFactory.killDriver;

public class TransferenciaTest {
    RegistroFlow registroFlow;
    LoginFlow loginFlow;
    HomeFlow homeFlow;
    TransferenciaFlow transferenciaFlow;

    @Test
    public void realizarTransferencia() throws InterruptedException {
        String emailConta1 = "testeKaren@bugbank.com.br";
        String nomeConta1 = "Teste Bug Bank";
        String senhaConta1 = "123456";

        String emailConta2 = "testeKaren2@bugbank.com.br";
        String nomeConta2 = "Teste Bug Bank 2";
        String senhaConta2 = "123456";

        String descricaoTransferencia = "Transferência testes";
        Double valorTransferencia = 500.00;
        Double saldo;

        registroFlow = new RegistroFlow();
        loginFlow = new LoginFlow();
        homeFlow = new HomeFlow();
        transferenciaFlow = new TransferenciaFlow();

        registroFlow.registrarUsuario(emailConta1, nomeConta1, senhaConta1);
        String numeroConta1 = loginFlow.logarSite(emailConta1, senhaConta1);
        int tamanhoCampo = numeroConta1.indexOf("-");
        String conta = numeroConta1.substring(0, tamanhoCampo);
        String digitoConta = numeroConta1.substring(tamanhoCampo + 1);
        homeFlow.sair();

        registroFlow.registrarUsuario(emailConta2, nomeConta2, senhaConta2);
        loginFlow.logarSite(emailConta2, senhaConta2);

        transferenciaFlow.transferir(conta, digitoConta, valorTransferencia, descricaoTransferencia);

        saldo = transferenciaFlow.retornarValorSaldoAberturaConta() - transferenciaFlow.retornarvalorTransferencia();

        Assert.assertEquals(transferenciaFlow.retornarvalorTransferencia(), valorTransferencia);
        Assert.assertEquals(transferenciaFlow.retornarSaldoDisponivel(), saldo);
        System.out.println("SaldoDisponivel: "+ (transferenciaFlow.retornarSaldoDisponivel()) + ", valorTransferencia: "+ transferenciaFlow.retornarvalorTransferencia() + ", ValorSaldoAberturaConta: "+ transferenciaFlow.retornarValorSaldoAberturaConta());

    }

    @AfterMethod
    public void fecharSite() { killDriver(); }
}