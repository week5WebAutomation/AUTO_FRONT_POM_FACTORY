import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VerConfirmacionPedido implements Task {

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

    @Override
    public <T extends Actor> void performAs(T actor) {
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

    public static VerConfirmacionPedido verConfirmacionPedido(String idPedido) {
        return new VerConfirmacionPedido(idPedido);
    }
}