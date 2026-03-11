package com.restaurante.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class RestauranteClientMenu {

    @FindBy(id = "menu-page")
    private WebElement menuPage;

    @FindBy(id = "product-name")
    private WebElement productNameField;

    @FindBy(id = "product-description")
    private WebElement productDescriptionField;

    @FindBy(id = "product-price")
    private WebElement productPriceField;

    @FindBy(id = "product-quantity")
    private WebElement productQuantityField;

    @FindBy(id = "quantity-field")
    private WebElement quantityField;

    @FindBy(id = "add-to-cart")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[.//span[text()='Comprar']]")
    private WebElement botonCarritoCompras;

    @FindBy(id = "search-field")
    private WebElement searchField;

    @FindBy(id = "search-button")
    private WebElement searchButton;

    @FindBy(id = "cart-button")
    private WebElement cartButton;

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

    public void agregarProductosAlCarrito(List<Integer> indices, List<Integer> cantidades) {
        agregarVariosProductosAlCarrito(indices, cantidades);
    }

    public void verCarritoDeCompras() {
        btnVerCarrito.click();
    }
}
