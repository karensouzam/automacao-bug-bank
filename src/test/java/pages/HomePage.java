package pages;

import core.PageBase;
import org.openqa.selenium.By;

public class HomePage extends PageBase {

    //Mapping
    By labelConta = By.xpath("//*[@id=\"textAccountNumber\"]/span");
    By labelSaldo = By.xpath("//*[@id=\"textBalance\"]/span");
    By botaoTransferir = By.id("btn-TRANSFERÊNCIA");
    By botaoSair = By.id ("btnExit");

    //Actions
    public String consultaNumeroContaTelaInicial(){ return obterValorCampo(labelConta); }

    public String consultaSaldoTelaInicial(){ return obterValorCampo(labelSaldo); }

    public void transferir(){ click(botaoTransferir);}

    public void sair(){ click(botaoSair);}
}
