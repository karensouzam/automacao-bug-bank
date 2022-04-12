package pages;

import core.PageBase;
import org.openqa.selenium.By;
public class TransferenciaPage extends PageBase {

    //Mapping
    By campoNumeroConta = By.id("inputAccountNumber");
    By campoDigitoConta = By.id("inputAccountDigit");
    By campoValorTransferencia = By.id("inputTransferValue");
    By campoDescricaoTransferencia = By.id("inputDescription");
    By labelSaldoDisponivel = By.id("textBalanceAvailable");
    By labelSaldoAberturaConta = By.xpath("//*[@id=\"textTransferValue\"][@type=\"Abertura de conta\"]");
    By labelValorTransferencia = By.xpath("//*[@id=\"textTransferValue\"][@type=\"withdrawal\"]");
    By botaoTransferirAgora = By.id("btnTransferNow");
    By botaoFechar = By.id("btnCloseModal");

    //Actions
    public void setCampoNumeroConta(String texto){ sendKeys(campoNumeroConta, texto); }

    public void setCampoDigitoConta(String texto){ sendKeys(campoDigitoConta, texto); }

    public void setCampoValorTransferencia(String texto){ sendKeys(campoValorTransferencia, texto); }

    public void setcampoDescricaoTransferencia(String texto){ sendKeys(campoDescricaoTransferencia, texto); }

    public Double retornarSaldoDisponivel(){

        String valorCampo = obterValorCampo(labelSaldoDisponivel);
        Double valor;
        int tamanhoCampo = obterValorCampo(labelSaldoDisponivel).length();
        int posicaoPonto = obterValorCampo(labelSaldoDisponivel).indexOf(".");
        if (posicaoPonto != 0){
            valorCampo = (obterValorCampo(labelSaldoDisponivel).substring(3, tamanhoCampo)).replace(".", "");
        }
        valor = Double.parseDouble(valorCampo.replace(",", "."));

        return valor;
    }

    public Double retornarSaldoAberturaConta(){

        String valorCampo = obterValorCampo(labelSaldoAberturaConta);
        Double valor;
        int tamanhoCampo = obterValorCampo(labelSaldoAberturaConta).length();
        int posicaoPonto = obterValorCampo(labelSaldoAberturaConta).indexOf(".");
        if (posicaoPonto != 0){
            valorCampo = (obterValorCampo(labelSaldoAberturaConta).substring(3, tamanhoCampo)).replace(".", "");
        }
        valor = Double.parseDouble(valorCampo.replace(",", "."));

        return valor;
    }

    public Double retornarValorTransferencia() {

        int tamanhoCampo = obterValorCampo(labelValorTransferencia).length();
        Double valorCampo = Double.parseDouble((obterValorCampo(labelValorTransferencia).substring(4, tamanhoCampo)).replace(",", "."));

        return valorCampo;
    }

    public void transferir() {
        click(botaoTransferirAgora);
    }

    public void fechar() { click(botaoFechar); }

}
