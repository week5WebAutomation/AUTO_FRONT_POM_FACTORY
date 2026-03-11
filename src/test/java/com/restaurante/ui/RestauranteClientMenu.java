package com.restaurante.ui;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import net.serenitybdd.screenplay.targets.Target;

public class RestauranteClientMenu extends PageObject {

    public static final Target MENU_PAGE = Target.the("Menu page")
        .locatedBy("//div[@id='menu-page']");

    public static final Target PRODUCT_NAME_FIELD = Target.the("Product name field")
        .locatedBy("//input[@id='product-name']");

    public static final Target PRODUCT_DESCRIPTION_FIELD = Target.the("Product description field")
        .locatedBy("//textarea[@id='product-description']");

    public static final Target PRODUCT_PRICE_FIELD = Target.the("Product price field")
        .locatedBy("//input[@id='product-price']");

    public static final Target PRODUCT_QUANTITY_FIELD = Target.the("Product quantity field")
        .locatedBy("//input[@id='product-quantity']");

    public static final Target QUANTITY_FIELD = Target.the("Quantity field")
        .locatedBy("//input[@id='quantity-field']");

    public static final Target ADD_TO_CART_BUTTON = Target.the("Add to cart button")
        .locatedBy("//button[@id='add-to-cart']");

    public static final Target BOTON_CARRITO_COMPRAS = Target.the("Boton Carrito Compras")
        .locatedBy("//button[.//span[text()='Comprar']]");

    public static final Target SEARCH_FIELD = Target.the("Search field")
        .locatedBy("//input[@id='search-field']");

    public static final Target SEARCH_BUTTON = Target.the("Search button")
        .locatedBy("//button[@id='search-button']");

    public static final Target CART_BUTTON = Target.the("Cart button")
        .locatedBy("//button[@id='cart-button']");

    @FindBy(xpath = "//div[.//button[contains(text(),'Agregar')]]")
    private List<WebElement> productos;

    @FindBy(xpath = "//button[.//span[contains(text(),'Comprar')]]")
    private WebElement btnVerCarrito;

    public void agregarProductoAlCarrito(int indiceProducto, int cantidad) {
        WebElement producto = productos.get(indiceProducto);
        WebElement campoCantidad = producto.findElement(By.cssSelector(".input-cantidad"));
        WebElement botonAgregar = producto.findElement(By.cssSelector(".btn-agregar-producto"));

        campoCantidad.clear();
        campoCantidad.sendKeys(String.valueOf(cantidad));
        botonAgregar.click();
    }

    public void agregarVariosProductosAlCarrito(List<Integer> indices, List<Integer> cantidades) {
        for (int i = 0; i < indices.size(); i++) {
            agregarProductoAlCarrito(indices.get(i), cantidades.get(i));
        }
    }

    public void verCarritoDeCompras() {
        btnVerCarrito.click();
    }
}
