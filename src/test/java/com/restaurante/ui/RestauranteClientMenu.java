package com.restaurante.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.time.Duration;
import net.serenitybdd.core.pages.PageObject;

public class RestauranteClientMenu extends PageObject {

    @FindBy(xpath = "//div[contains(@class, 'flex') and contains(@class, 'gap-1')]//span")
    private WebElement campoCantidad;

    @FindBy(xpath = "//button[.//span[text()='Comprar']]")
    private WebElement botonCarritoCompras;

    @FindBy(xpath = "//div[.//button[contains(text(),'Agregar')]]")
    private List<WebElement> productos;

    public void agregarProductoAlCarrito(int indiceProducto, int cantidad) {
        WebElement producto = productos.get(indiceProducto);
        WebElement botonAgregar = producto.findElement(By.xpath(".//button[contains(text(),'Agregar')]"));

        campoCantidad.clear();
        campoCantidad.sendKeys(String.valueOf(cantidad));
        botonAgregar.click();
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
        botonCarritoCompras.click();
    }

    public void waitForPresenceOf(String cssSelector) {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
    }
}
