package com.restaurante.ui;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class RestauranteClientMenu extends PageObject {

    @FindBy(xpath = "//div[.//button[contains(text(),'Agregar')]]")
    private List<WebElement> productos;

    @FindBy(xpath = "//button[.//span[contains(text(),'Comprar')]]")
    private WebElement btnVerCarrito;

    public void agregarProductoAlCarrito(int indiceProducto, int cantidad) {
        WebElement producto = productos.get(indiceProducto);
        WebElement campoCantidad = producto.findElement(By.cssSelector(".input-cantidad"));
        WebElement botonAgregar = producto.findElement(By.cssSelector(".btn-agregar-producto"));

        campoCantidad.clear();
        campoCantidad.sendKeys(String.valueOf(cantidad));
        botonAgregar.click();
    }

    public void agregarVariosProductosAlCarrito(List<Integer> indices, List<Integer> cantidades) {
        for (int i = 0; i < indices.size(); i++) {
            agregarProductoAlCarrito(indices.get(i), cantidades.get(i));
        }
    }

    public void verCarritoDeCompras() {
        btnVerCarrito.click();
    }
}
