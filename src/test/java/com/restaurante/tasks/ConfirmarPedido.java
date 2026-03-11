package com.restaurante.tasks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmarPedido {

    @FindBy(xpath = "//button[contains(text(), 'Confirmar pedido')]")
    private WebElement botonConfirmarPedido;

    @FindBy(xpath = "//div[textarea[@placeholder='Notas para este plato...']]")
    private WebElement productosCarrito;

    @FindBy(xpath = "//svg[contains(@class, 'lucide-trash2')]")
    private WebElement botonRemoverProducto;

    @FindBy(xpath = "//div[span[text()='Total']]/span[contains(text(), '$')]")
    private WebElement totalCarrito;

    private final String nombreProducto;
    private final String descripcion;
    private final String precio;
    private final String cantidadElegida;
    private final String notas;

    public ConfirmarPedido(String nombreProducto, String descripcion, String precio, String cantidadElegida, String notas) {
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadElegida = cantidadElegida;
        this.notas = notas;
    }

    public void confirmar() {
        productosCarrito.click();

        botonRemoverProducto.click();

        totalCarrito.click();

        botonConfirmarPedido.click();

        if (notas != null && !notas.isEmpty()) {
            System.out.println("Notas adicionales: " + notas);
        }
    }
}
