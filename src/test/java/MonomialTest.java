import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MonomialTest {

    @Test
    void getExponent() {
        Monomial m = new Monomial(2,2);
        assertEquals(2,m.getExponent());
    }

    @Test
    void getCoefficient() {
        Monomial m = new Monomial(4,2);
        assertEquals(4,m.getCoefficient());
    }

    @Test
    void setCoefficient() {
        Monomial m = new Monomial(1,4);
        m.setCoefficient(3);
        assertEquals(3,m.getCoefficient());
    }
}