package com.restaurante.stepdefinitions;

import com.restaurante.ui.RestauranteClientTable;
import com.restaurante.ui.RestauranteClientMenu;
import com.restaurante.ui.RestaduranteClientCart;
import com.restaurante.ui.RestauranteClientConfirm;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import java.util.List;

public class RegistroStepDefinitions {

    RestauranteClientTable tablePage;
    RestauranteClientMenu menuPage;
    RestaduranteClientCart cartPage;
    RestauranteClientConfirm confirmPage;

    @Given("el usuario accede a la pagina de mesas disponibles")
    public void accederAPaginaMesas() {
        tablePage.abrirPaginaMesas();
    }

    @And("selecciona una mesa con estado {string}")
    public void seleccionarMesaDisponible(String estado) {
        tablePage.seleccionarMesaConEstado(estado);
    }

    @When("el usuario es redirigido a la pagina del menu")
    public void redirigirAPaginaMenu() {
        menuPage.waitForPresenceOf(".menu-container");
    }

    @And("agrega productos al carrito seleccionando la cantidad deseada para cada uno")
    public void agregarProductosAlCarrito() {
        menuPage.agregarProductosAlCarrito(List.of(0, 1), List.of(2, 3)); // Example indices and quantities
    }

    @And("revisa el carrito de compras y elimina los productos no deseados")
    public void revisarYEliminarProductos() {
        cartPage.eliminarProductosNoDeseados(List.of(0, 1)); // Example indices of unwanted products
    }

    @And("añade notas adicionales a los productos que lo requieran")
    public void agregarNotasAdicionales() {
        cartPage.agregarNotasAdicionales(List.of(0, 1), List.of("Nota 1", "Nota 2")); // Example indices and notes
    }

    @And("confirma el pedido desde la pagina del carrito")
    public void confirmarPedido() {
        cartPage.confirmarPedido();
    }

    @Then("el pedido es generado y enviado correctamente")
    public void verificarPedidoGenerado() {
        confirmPage.verificarPedidoGenerado();
    }

    @And("el usuario es redirigido a la pagina de confirmacion del pedido")
    public void redirigirAPaginaConfirmacion() {
        confirmPage.waitForPresenceOf(".confirmation-container");
    }

    @And("el usuario visualiza el mensaje de confirmacion junto con el ID del pedido")
    public void visualizarMensajeConfirmacion() {
        confirmPage.visualizarMensajeConfirmacion();
    }
}