package com.restaurante.ui;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class RestaduranteClientCart extends PageObject {

    @FindBy(css = ".btn-eliminar-producto")
    private List<WebElement> botonesEliminarProducto;

    @FindBy(css = ".input-nota-producto")
    private List<WebElement> camposNotaProducto;

    @FindBy(css = ".btn-confirmar-pedido")
    private WebElement btnConfirmarPedido;

    public void eliminarProductosNoDeseados() {
        if (!botonesEliminarProducto.isEmpty()) {
            botonesEliminarProducto.get(botonesEliminarProducto.size() - 1).click();
        }
    }

    public void agregarNotasAdicionales() {
        for (WebElement campoNota : camposNotaProducto) {
            campoNota.sendKeys("Sin sal");
        }
    }

    public void confirmarPedido() {
        btnConfirmarPedido.click();
    }
}
