package com.restaurante.ui;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RestauranteClientConfirm extends PageObject {

    @FindBy(xpath = "//main[.//h1[text()='Pedido confirmado']]")
    private WebElement mensajeConfirmacion;

    @FindBy(xpath = "//div[.//p[text()='ID completo del pedido']]/p[2]")
    private WebElement idPedido;

    public void verificarPedidoGenerado() {
        mensajeConfirmacion.isDisplayed();
    }

    public void visualizarMensajeConfirmacion() {
        mensajeConfirmacion.isDisplayed();
        idPedido.isDisplayed();
    }
}
