package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    //Variaveis globais
    protected WebDriverWait wait;
    protected WebDriver driver;

    public PageBase() {}

    //Custom Actions
    protected void acessarPaginaInicial(String baseUrl){
        DriverFactory.getDriver().navigate().to(baseUrl);
    }
    protected void sendKeys(By locator, String text) {
        waitForElementVisible(locator);
        DriverFactory.getDriver().findElement(locator).clear();
        DriverFactory.getDriver().findElement(locator).sendKeys(text);
    }

    protected void click(By locator) {
        waitForElement(locator);
        DriverFactory.getDriver().findElement(locator).click();
    }

    protected void clickCheckBox(By locator) {
        waitForElementCheck(locator);
        DriverFactory.getDriver().findElement(locator).click();
    }

    public String obterValorCampo(By locator) {
        waitForElementVisible(locator);
        return DriverFactory.getDriver().findElement(locator).getText();
    }

    protected WebElement waitForElement(By locator) {
        wait = new WebDriverWait(DriverFactory.getDriver(), 1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = DriverFactory.getDriver().findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    protected WebElement waitForElementVisible(By locator) {
        wait = new WebDriverWait(DriverFactory.getDriver(), 1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = DriverFactory.getDriver().findElement(locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    protected WebElement waitForElementCheck(By locator) {
        wait = new WebDriverWait(DriverFactory.getDriver(), 1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = DriverFactory.getDriver().findElement(locator);
        wait.until(ExpectedConditions.elementSelectionStateToBe(element, false));
        return element;
    }

    public void fecharPagina(){
        this.driver.quit();
    }

//    protected void frameIn(By locator){
//        driver.switchTo().frame(driver.findElement(locator));
//    }

}