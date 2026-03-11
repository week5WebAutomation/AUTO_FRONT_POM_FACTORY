package com.restaurante.tasks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EscogerMesa {

    @FindBy(xpath = "//div[contains(@class, 'grid')]/button")
    private WebElement botonesMesa;

    private final String idMesa;
    private final String estadoDisponible;

    public EscogerMesa(String idMesa, String estadoDisponible) {
        this.idMesa = idMesa;
        this.estadoDisponible = estadoDisponible;
    }

    public void seleccionarMesa() {
        if (estadoDisponible.equals("disponible")) {
            botonesMesa.click();
        } else if (estadoDisponible.equals("ocupado")) {
            throw new IllegalStateException("La mesa no está disponible");
        } else {
            throw new IllegalArgumentException("Estado desconocido: " + estadoDisponible);
        }
    }
}