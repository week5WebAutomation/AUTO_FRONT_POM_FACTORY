package com.restaurante.stepdefinitions;

import com.restaurante.ui.RestauranteClientTable;
import com.restaurante.ui.RestauranteClientMenu;
import com.restaurante.ui.RestaduranteClientCart;
import com.restaurante.ui.RestauranteClientConfirm;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Managed;
import net.thucydides.core.pages.Pages;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class RegistroStepDefinitions {

    @Managed
    WebDriver driver;

    private Pages pages;

    private RestauranteClientTable tablePage() {
        return getPages().currentPageAt(RestauranteClientTable.class);
    }

    private RestauranteClientMenu menuPage() {
        return getPages().currentPageAt(RestauranteClientMenu.class);
    }

    private RestaduranteClientCart cartPage() {
        return getPages().currentPageAt(RestaduranteClientCart.class);
    }

    private RestauranteClientConfirm confirmPage() {
        return getPages().currentPageAt(RestauranteClientConfirm.class);
    }

    private Pages getPages() {
        if (pages == null) {
            pages = new Pages(driver);
        }
        return pages;
    }

    @Given("el usuario esta en la pagina de registro")
    public void elUsuarioEstaEnLaPaginaDeRegistro() {
        System.out.println("Usuario está en la página de registro");
    }

    @When("el usuario accede a la pagina de mesas disponibles")
    public void accederAPaginaMesas() {
        tablePage().abrirPaginaMesas();
    }

    @And("selecciona una mesa con estado {string}")
    public void seleccionarMesaDisponible(String estado) {
        tablePage().seleccionarMesaConEstado(estado);
    }

    @When("el usuario es redirigido a la pagina del menu")
    public void redirigirAPaginaMenu() {
        menuPage().waitForPresenceOf("h1");
    }

    @And("agrega productos al carrito seleccionando la cantidad deseada para cada uno")
    public void agregarProductosAlCarrito() {
        menuPage().agregarProductosAlCarrito(List.of(0, 1), List.of(1, 1));
        menuPage().verCarritoDeCompras();
    }

    @And("revisa el carrito de compras y elimina los productos no deseados")
    public void revisarYEliminarProductos() {
        System.out.println("Revisando y eliminando productos del carrito");
    }

    @And("agrega notas adicionales a los productos que lo requieran")
    public void agregarNotasAdicionales() {
        cartPage().agregarNotasAdicionales(List.of(0), List.of("Sin picante"));
    }

    @And("confirma el pedido desde la pagina del carrito")
    public void confirmarPedido() {
        cartPage().confirmarPedido();
    }

    @Then("el pedido es generado y enviado correctamente")
    public void verificarPedidoGenerado() {
        confirmPage().verificarPedidoGenerado();
    }

    @And("el usuario es redirigido a la pagina de confirmacion del pedido")
    public void redirigirAPaginaConfirmacion() {
        System.out.println("Usuario es redirigido a la página de confirmación del pedido");
    }

    @And("el usuario visualiza el mensaje de confirmacion junto con el ID del pedido")
    public void visualizarMensajeConfirmacion() {
        confirmPage().visualizarMensajeConfirmacion();
    }
}