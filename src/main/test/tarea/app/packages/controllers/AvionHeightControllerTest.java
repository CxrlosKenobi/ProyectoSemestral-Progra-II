import org.junit.Test;
import static org.junit.Assert.*;

public class AvionHeightControllerTest {
  @Test
  public void testGetAltitude() {
    AvionHeightController controller = new AvionHeightController();
    controller.slider.setValue(300);
    assertEquals(300, controller.getAltitude());
  }

  @Test
  public void testGetMaxAltitude() {
    AvionHeightController controller = new AvionHeightController();
    assertEquals(410, controller.getMaxAltitude());
  }

  @Test
  public void testStateChanged() {
    AvionHeightController controller = new AvionHeightController();
    controller.slider.setValue(250);
    controller.stateChanged(null);
    assertEquals("Altura de vuelo: 250 m.s.n.m", controller.label.getText());
  }
}
