package com.restaurante.ui;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RestauranteClientTable extends PageObject {

    @FindBy(xpath = "//button[.//span[contains(text(),'Vacia')]]")
    private WebElement mesaDisponible;

    @FindBy(xpath = "//button[.//span[contains(text(),'Ocupada')]]")
    private WebElement mesaSeleccionada;

    public void abrirPaginaMesas() {
        open();
    }

    public void seleccionarMesaConEstado(String estado) {
        WebElement mesa = estado.equalsIgnoreCase("Vacia") ? mesaDisponible : mesaSeleccionada;
        mesa.click();
    }
}
