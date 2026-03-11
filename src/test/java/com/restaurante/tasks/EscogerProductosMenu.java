package com.restaurante.tasks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EscogerProductosMenu {

    private final String nombreProducto;
    private final int cantidad;

    @FindBy(xpath = "//div[contains(@class, 'menu-productos')]")
    private WebElement menuProductos;

    @FindBy(xpath = "//button[contains(@class, 'agregar-producto')]")
    private WebElement botonAgregarAlCarrito;

    @FindBy(xpath = "//div[contains(text(), 'productos')]")
    private WebElement totalCarrito;

    @FindBy(xpath = "//input[@id='search-field']")
    private WebElement campoBusqueda;

    @FindBy(xpath = "//button[@id='search-button']")
    private WebElement botonBuscar;

    @FindBy(xpath = "//input[@id='quantity-field']")
    private WebElement campoCantidad;

    public EscogerProductosMenu(String nombreProducto, int cantidad) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
    }

    public void agregarProducto() {
        menuProductos.click();
        campoBusqueda.sendKeys(nombreProducto);
        botonBuscar.click();
        campoCantidad.sendKeys(String.valueOf(cantidad));
        botonAgregarAlCarrito.click();
        totalCarrito.click();
    }
}