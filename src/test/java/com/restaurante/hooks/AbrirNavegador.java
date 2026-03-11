package com.restaurante.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbrirNavegador {
    private String url;

    public AbrirNavegador(String url) {
        this.url = url;
    }

    public void abrir() {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        // Add any additional setup or teardown logic here if needed
    }
}
