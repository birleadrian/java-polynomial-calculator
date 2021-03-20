import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void getPolynomial() {
        String polynomial = "2x^2+1";
        Polynomial p = new Polynomial();
        p = Controller.getPolynomial(polynomial);
        assertEquals("2x^2+1",p.toString());
    }

    @Test
    void onlyLetters() {
        String text = "Adrian";
        boolean ol = Controller.onlyLetters(text);
        assertEquals(true,ol);
    }
}