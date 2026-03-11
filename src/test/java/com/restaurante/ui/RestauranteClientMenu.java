package com.restaurante.ui;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class RestauranteClientMenu extends PageObject {

    @FindBy(css = ".btn-agregar-producto")
    private List<WebElement> botonesAgregarProducto;

    @FindBy(css = ".input-cantidad")
    private List<WebElement> camposCantidad;

    @FindBy(css = ".btn-ver-carrito")
    private WebElement btnVerCarrito;

    public void agregarProductosAlCarrito() {
        for (int i = 0; i < botonesAgregarProducto.size(); i++) {
            camposCantidad.get(i).clear();
            camposCantidad.get(i).sendKeys("1");
            botonesAgregarProducto.get(i).click();
        }
    }
}
