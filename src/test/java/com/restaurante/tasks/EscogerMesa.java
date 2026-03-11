package com.restaurante.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import org.openqa.selenium.support.FindBy; 

public class EscogerMesa implements Task {

    @FindBy(xpath="//div[contains(@class, 'grid')]/button")
    private static final Target BOTONES_MESA = Target.the("Botones de mesa disponibles")
        .locatedBy("//div[contains(@class, 'grid')]/button");

    private final String idMesa;
    private final String estadoDisponible;

    public EscogerMesa(String idMesa, String estadoDisponible) {
        this.idMesa = idMesa;
        this.estadoDisponible = estadoDisponible;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target botonSeleccionado = Target.the("Botón de mesa específico")
            .locatedBy("(//div[contains(@class, 'grid')]/button)[{0}]").of(idMesa);

        switch (estadoDisponible) {
            case "disponible" -> actor.attemptsTo(Click.on(botonSeleccionado));
            case "ocupado" -> throw new IllegalStateException("La mesa no está disponible");
            default -> throw new IllegalArgumentException("Estado desconocido: " + estadoDisponible);
        }
    }

    public static EscogerMesa escogerMesaDisponible(String idMesa, String estadoDisponible) {
        return instrumented(EscogerMesa.class, idMesa, estadoDisponible);
    }
}