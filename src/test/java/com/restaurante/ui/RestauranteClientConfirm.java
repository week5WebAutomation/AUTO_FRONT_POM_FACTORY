package com.restaurante.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class RestauranteClientConfirm extends PageObject {

    @FindBy(xpath = "//h1[contains(.,'Pedido confirmado')]")
    private WebElementFacade mensajeConfirmacion;

    @FindBy(xpath = "//p[contains(text(),'ID completo del pedido')]/following-sibling::p")
    private WebElementFacade idPedido;

    public void verificarPedidoGenerado() {
        setImplicitTimeout(20, java.time.temporal.ChronoUnit.SECONDS);
        mensajeConfirmacion.withTimeoutOf(Duration.ofSeconds(20)).waitUntilVisible();
    }

    public void visualizarMensajeConfirmacion() {
        mensajeConfirmacion.waitUntilVisible();
        idPedido.waitUntilVisible();
    }

    public void waitForPresenceOf(String cssSelector) {
        waitFor(ExpectedConditions.presenceOfElementLocated(org.openqa.selenium.By.cssSelector(cssSelector)));
    }
}
