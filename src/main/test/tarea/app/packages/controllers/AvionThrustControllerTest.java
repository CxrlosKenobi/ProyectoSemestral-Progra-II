import org.junit.Test;
import static org.junit.Assert.*;

public class AvionThrustControllerTest {
  @Test
  public void testGetThrust() {
    AvionThrustController controller = new AvionThrustController();
    controller.slider.setValue(50);
    assertEquals(50, controller.getThrust());
  }

  @Test
  public void testStateChanged() {
    AvionThrustController controller = new AvionThrustController();
    controller.slider.setValue(75);
    controller.stateChanged(null);
    assertEquals("Fuerza de empuje de avión: 75%", controller.label.getText());
  }
}
