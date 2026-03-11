package com.restaurante.ui;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import java.time.temporal.ChronoUnit;

@DefaultUrl("http://localhost:5173/client/table")
public class RestauranteClientTable extends PageObject {

    @FindBy(xpath = "//button[contains(.,'Vacia')]")
    private WebElementFacade mesaDisponible;

    @FindBy(xpath = "//button[contains(.,'Ocupada')]")
    private WebElementFacade mesaOcupada;

    public void abrirPaginaMesas() {
        open();
        setImplicitTimeout(10, ChronoUnit.SECONDS);
    }

    public void seleccionarMesaConEstado(String estado) {
        boolean esDisponible = estado.equalsIgnoreCase("Vacia") || estado.equalsIgnoreCase("disponible");
        WebElementFacade mesa = esDisponible ? mesaDisponible : mesaOcupada;
        mesa.waitUntilVisible().waitUntilClickable().click();
    }
}
