package com.restaurante.ui;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class RestaduranteClientCart extends PageObject {

    @FindBy(xpath = "//div[contains(., 'Cantidad elegida en menú')]")
    private List<WebElement> productosEnCarrito;

    @FindBy(xpath = "//div[.//span[text()='Total']]/span[2]")
    private WebElement totalCarrito;

    @FindBy(xpath = "//button[text()='Confirmar pedido']")
    private WebElement btnConfirmarPedido;

    public void modificarProductoEnCarrito(int indiceProducto, int nuevaCantidad, String notaAdicional) {
        WebElement producto = productosEnCarrito.get(indiceProducto);
        WebElement campoCantidad = producto.findElement(By.cssSelector(".input-cantidad"));
        WebElement campoNotas = producto.findElement(By.cssSelector(".input-notas"));

        campoCantidad.clear();
        campoCantidad.sendKeys(String.valueOf(nuevaCantidad));

        campoNotas.clear();
        campoNotas.sendKeys(notaAdicional);
    }

    public void eliminarProductoDelCarrito(int indiceProducto) {
        WebElement producto = productosEnCarrito.get(indiceProducto);
        WebElement botonEliminar = producto.findElement(By.cssSelector(".btn-eliminar-producto"));
        botonEliminar.click();
    }

    public void eliminarProductosNoDeseados(List<Integer> indicesProductos) {
        for (int indice : indicesProductos) {
            eliminarProductoDelCarrito(indice);
        }
    }

    public String obtenerNombreProducto(int indiceProducto) {
        WebElement producto = productosEnCarrito.get(indiceProducto);
        return producto.findElement(By.cssSelector(".nombre-producto")).getText();
    }

    public String obtenerPrecioProducto(int indiceProducto) {
        WebElement producto = productosEnCarrito.get(indiceProducto);
        return producto.findElement(By.cssSelector(".precio-producto")).getText();
    }

    public String obtenerTotalCarrito() {
        return totalCarrito.getText();
    }

    public void confirmarPedido() {
        btnConfirmarPedido.click();
    }

    public void agregarNotasAdicionales(List<Integer> indicesProductos, List<String> notas) {
        for (int i = 0; i < indicesProductos.size(); i++) {
            WebElement producto = productosEnCarrito.get(indicesProductos.get(i));
            WebElement campoNotas = producto.findElement(By.cssSelector(".input-notas"));

            campoNotas.clear();
            campoNotas.sendKeys(notas.get(i));
        }
    }
}
