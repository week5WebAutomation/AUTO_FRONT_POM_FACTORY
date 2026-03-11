import io.cucumber.java.Before;

public class Hook {

    @Before
    public void iniciarEscenario() {
        System.out.println("Setting up the scenario using POM pattern");
    }
}

