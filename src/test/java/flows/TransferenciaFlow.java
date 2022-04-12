package flows;

import pages.HomePage;
import pages.TransferenciaPage;

public class TransferenciaFlow {
    HomePage homePage;
    TransferenciaPage transferenciaPage;

    public void transferir(String numeroConta, String digitoConta, Double valor, String descricaoTransferencia){
        homePage = new HomePage();
        transferenciaPage = new TransferenciaPage();

        homePage.transferir();
        transferenciaPage.setCampoNumeroConta(numeroConta);
        transferenciaPage.setCampoDigitoConta(digitoConta);
        transferenciaPage.setCampoValorTransferencia(valor.toString());
        transferenciaPage.setcampoDescricaoTransferencia(descricaoTransferencia);
        transferenciaPage.transferir();
        transferenciaPage.fechar();
    }

    public Double retornarValorSaldoAberturaConta (){ return transferenciaPage.retornarSaldoAberturaConta(); }

    public Double retornarvalorTransferencia (){ return transferenciaPage.retornarValorTransferencia(); }

    public Double retornarSaldoDisponivel (){ return transferenciaPage.retornarSaldoDisponivel(); }
}
