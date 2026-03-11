package com.restaurante.ui;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RestauranteClientTable extends PageObject {

    @FindBy(css = ".table-card[data-status='disponible']")
    private WebElement mesaDisponible;

    @FindBy(css = ".table-card")
    private WebElement mesaSeleccionada;

    public void abrirPaginaMesas() {
        openUrl(getDriver().getCurrentUrl());
    }

    public void seleccionarMesaConEstado(String estado) {
        mesaDisponible.click();
    }
}
