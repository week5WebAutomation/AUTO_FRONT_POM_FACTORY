package com.restaurante.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.time.Duration;
import net.serenitybdd.core.pages.PageObject;

public class RestauranteClientMenu extends PageObject {

    @FindBy(xpath = "//button[contains(.,'Comprar')]")
    private WebElement botonCarritoCompras;

    @FindBy(xpath = "//button[contains(.,'Agregar')]")
    private List<WebElement> botonesAgregar;

    public void agregarProductoAlCarrito(int indiceProducto, int cantidad) {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        List<WebElement> botones = driver.findElements(By.xpath("//button[contains(.,'Agregar')]"));
        if (indiceProducto < botones.size()) {
            WebElement botonAgregar = botones.get(indiceProducto);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", botonAgregar);
            wait.until(ExpectedConditions.elementToBeClickable(botonAgregar));
            botonAgregar.click();
        }
        
        try { Thread.sleep(1000); } catch (InterruptedException e) { }
        
        if (cantidad > 1) {
            List<WebElement> botonesMas = driver.findElements(By.xpath("//button[contains(@aria-label,'Agregar una unidad')]"));
            for (int i = 1; i < cantidad; i++) {
                if (!botonesMas.isEmpty()) {
                    WebElement botonMas = botonesMas.get(botonesMas.size() - 1);
                    wait.until(ExpectedConditions.elementToBeClickable(botonMas));
                    botonMas.click();
                    try { Thread.sleep(300); } catch (InterruptedException e) { }
                }
            }
        }
    }

    public void agregarVariosProductosAlCarrito(List<Integer> indices, List<Integer> cantidades) {
        for (int i = 0; i < indices.size(); i++) {
            agregarProductoAlCarrito(indices.get(i), cantidades.get(i));
        }
    }

    public void agregarProductosAlCarrito(List<Integer> indices, List<Integer> cantidades) {
        agregarVariosProductosAlCarrito(indices, cantidades);
    }

    public void verCarritoDeCompras() {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", botonCarritoCompras);
        wait.until(ExpectedConditions.elementToBeClickable(botonCarritoCompras));
        botonCarritoCompras.click();
    }

    public void waitForPresenceOf(String cssSelector) {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
    }
}
