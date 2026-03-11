package com.restaurante.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class RestaduranteClientCart extends PageObject {

    @FindBy(xpath = "//div[.//h3]//h3/ancestor::div[contains(@class,'flex')]")
    private List<WebElementFacade> productosEnCarrito;

    @FindBy(xpath = "//button[contains(@aria-label,'Eliminar')]")
    private List<WebElementFacade> botonesEliminar;

    @FindBy(xpath = "//input[@placeholder='Notas para este plato...']")
    private List<WebElementFacade> camposNotas;

    @FindBy(xpath = "//button[contains(.,'Confirmar pedido')]")
    private WebElementFacade btnConfirmarPedido;

    public void eliminarProductoDelCarrito(int indiceProducto) {
        if (indiceProducto < botonesEliminar.size()) {
            botonesEliminar.get(indiceProducto).waitUntilClickable().click();
        }
    }

    public void eliminarProductosNoDeseados(List<Integer> indicesProductos) {
        for (int i = indicesProductos.size() - 1; i >= 0; i--) {
            eliminarProductoDelCarrito(indicesProductos.get(i));
        }
    }

    public void agregarNotaAProducto(int indiceProducto, String nota) {
        if (indiceProducto < camposNotas.size()) {
            camposNotas.get(indiceProducto).type(nota);
        }
    }

    public void agregarNotasAdicionales(List<Integer> indices, List<String> notas) {
        for (int i = 0; i < indices.size() && i < notas.size(); i++) {
            int indice = indices.get(i);
            if (indice < camposNotas.size()) {
                camposNotas.get(indice).type(notas.get(i));
            }
        }
    }

    public void confirmarPedido() {
        btnConfirmarPedido.waitUntilClickable().click();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains("confirm"));
    }
}
