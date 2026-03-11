import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VerConfirmacionPedido {

    @FindBy(id = "confirmacion-pedido")
    private WebElement confirmacionPedido;

    @FindBy(xpath = "//button[contains(text(), 'Confirmar pedido')]")
    private WebElement botonConfirmarPedido;

    @FindBy(xpath = "//main[.//h1[text()='Pedido confirmado']]")
    private WebElement mensajeConfirmacion;

    @FindBy(xpath = "//div[.//p[text()='ID completo del pedido']]/p[2]")
    private WebElement idPedidoElemento;

    private final String idPedido;

    public VerConfirmacionPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public void verificarConfirmacion() {
        if (!mensajeConfirmacion.isDisplayed()) {
            throw new AssertionError("El mensaje de confirmación no está visible.");
        }

        botonConfirmarPedido.click();

        String idPedido = idPedidoElemento.getText();
        System.out.println("El ID del pedido es: " + idPedido);

        enviarPedidoACocina(idPedido);
    }

    private void enviarPedidoACocina(String idPedido) {
        System.out.println("Pedido enviado a la cocina con ID: " + idPedido);
    }
}