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
        openUrl(getDriver().getCurrentUrl());
    }

    public void seleccionarMesaConEstado(String estado) {
        String xpathDinamico = String.format("//button[.//span[contains(text(),'%s')]]", estado);
        WebElement mesa = getDriver().findElementByXPath(xpathDinamico);
        mesa.click();
    }
}
