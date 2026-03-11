package com.restaurante.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.restaurante.utils.Constants.*;

public class ConfirmarPedido implements Task {

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

    @Override
    public <T extends Actor> void performAs(T actor) {
        productosCarrito.click();

        botonRemoverProducto.click();

        totalCarrito.click();

        botonConfirmarPedido.click();

        if (notas != null && !notas.isEmpty()) {
            System.out.println("Notas adicionales: " + notas);
            // Aquí puedes agregar la lógica para interactuar con el campo de notas si es necesario
        }
    }

    public static ConfirmarPedido confirmarPedido(String nombreProducto, String descripcion, String precio, String cantidadElegida, String notas) {
        return new ConfirmarPedido(nombreProducto, descripcion, precio, cantidadElegida, notas);
    }
}
