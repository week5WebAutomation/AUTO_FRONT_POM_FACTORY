package com.restaurante.ui;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RestauranteClientConfirm extends PageObject {

    @FindBy(css = ".mensaje-confirmacion")
    private WebElement mensajeConfirmacion;

    @FindBy(css = ".order-id")
    private WebElement idPedido;

    public void verificarPedidoGenerado() {
        mensajeConfirmacion.isDisplayed();
    }

    public void visualizarMensajeConfirmacion() {
        mensajeConfirmacion.isDisplayed();
        idPedido.isDisplayed();
    }
}
