package com.restaurante.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.restaurante.ui.RestauranteClientMenu;

public class EscogerProductosMenu implements Task {

    private final String nombreProducto;
    private final int cantidad;

    @FindBy(xpath = "//div[contains(@class, 'menu-productos')]")
    private WebElement menuProductos;

    @FindBy(xpath = "//button[contains(@class, 'agregar-producto')]")
    private WebElement botonAgregarAlCarrito;

    @FindBy(xpath = "//div[contains(text(), 'productos')]")
    private WebElement totalCarrito;

    public EscogerProductosMenu(String nombreProducto, int cantidad) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            // Navegar a la página del menú
            Click.on(RestauranteClientMenu.MENU_PAGE),

            // Seleccionar el producto por nombre
            Enter.theValue(nombreProducto).into(RestauranteClientMenu.SEARCH_FIELD),
            Click.on(RestauranteClientMenu.SEARCH_BUTTON),

            // Modificar la cantidad deseada
            SendKeys.of(String.valueOf(cantidad)).into(RestauranteClientMenu.QUANTITY_FIELD),

            // Agregar el producto al carrito
            Click.on(RestauranteClientMenu.ADD_TO_CART_BUTTON),

            // Verificar el carrito de compras
            Click.on(RestauranteClientMenu.CART_BUTTON)
        );
    }

    public static EscogerProductosMenu agregarProducto(String nombreProducto, int cantidad) {
        return new EscogerProductosMenu(nombreProducto, cantidad);
    }
}