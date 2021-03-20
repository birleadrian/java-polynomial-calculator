import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    @Test
    void add() {
        Monomial m = new Monomial(1, 3);
        Monomial m1 = new Monomial(2, 3);
        Monomial res = new Monomial();
        res = Operation.add(m, m1);
        assertEquals(3, res.getCoefficient());
        assertEquals(3, res.getExponent());
    }

    @Test
    void sub() {
        Monomial m = new Monomial(5, 2);
        Monomial m1 = new Monomial(1, 2);
        Monomial res = new Monomial();
        res = Operation.sub(m, m1);
        assertEquals(4, res.getCoefficient());
        assertEquals(2, res.getExponent());
    }

    @Test
    void multiply() {
        Monomial m = new Monomial(2, 1);
        Monomial m1 = new Monomial(1, 6);
        Monomial res = new Monomial();
        res = Operation.multiply(m, m1);
        assertEquals(2, res.getCoefficient());
        assertEquals(7, res.getExponent());
    }

    @Test
    void divide() {
        Monomial m = new Monomial(2, 1);
        Monomial m1 = new Monomial(2, 1);
        Monomial res = new Monomial();
        res = Operation.divide(m,m1);
        assertEquals("1",res.toString());
    }

    @Test
    void derivative() {
        Monomial m = new Monomial(3, 5);
        Monomial res = new Monomial();
        res = Operation.derivative(m);
        assertEquals("15x^4",res.toString());
    }

    @Test
    void integral() {

    }

    @Test
    void testAdd() {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        Polynomial res = new Polynomial();
        Monomial m1 = new Monomial(1, 2);
        Monomial m2 = new Monomial(3, 3);
        Monomial m3 = new Monomial(2, 1);
        Monomial m4 = new Monomial(3, 3);
        p1.addMonomial(m1);
        p1.addMonomial(m2);
        p2.addMonomial(m3);
        p2.addMonomial(m4);
        res = Operation.add(p1, p2);
    }

    @Test
    void testSub() {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        Polynomial res = new Polynomial();
        Monomial m1 = new Monomial(1, 2);
        Monomial m2 = new Monomial(3, 3);
        Monomial m3 = new Monomial(2, 1);
        Monomial m4 = new Monomial(3, 3);
        p1.addMonomial(m1);
        p1.addMonomial(m2);
        p2.addMonomial(m3);
        p2.addMonomial(m4);
        res = Operation.sub(p1, p2);
        assertEquals("x^2-2x",res.toString());
    }

    @Test
    void testMultiply() {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        Polynomial res = new Polynomial();
        Monomial m1 = new Monomial(1, 2);
        Monomial m2 = new Monomial(1, 0);
        Monomial m3 = new Monomial(1, 1);
        Monomial m4 = new Monomial(3, 2);
        p1.addMonomial(m1);
        p1.addMonomial(m2);
        p2.addMonomial(m3);
        p2.addMonomial(m4);
        res = Operation.multiply(p1, p2);
        assertEquals("3x^4+x^3+3x^2+x",res.toString());
    }

    @Test
    void testDivide() {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        Polynomial res = new Polynomial();
        Monomial m1 = new Monomial(2, 2);
        Monomial m2 = new Monomial(1, 1);
        Monomial m3 = new Monomial(2, 2);
        Monomial m4 = new Monomial(1, 1);
        p1.addMonomial(m1);
        p1.addMonomial(m2);
        p2.addMonomial(m3);
        p2.addMonomial(m4);
        res = Operation.divide(p1, p2);
        assertEquals("1",res.toString());
    }

    @Test
    void testDerivative() {
        Polynomial p = new Polynomial();
        Polynomial res = new Polynomial();
        Monomial m1 = new Monomial(2, 2);
        Monomial m2 = new Monomial(1, 1);
        p.addMonomial(m1);
        p.addMonomial(m2);
        res = Operation.derivative(p);
        assertEquals("4x+1",res.toString());
    }

    @Test
    void integrative() {
        Polynomial p = new Polynomial();
        Polynomial res = new Polynomial();
        Monomial m1 = new Monomial(2,1);
        p.addMonomial(m1);
        res = Operation.integrative(p);
        assertEquals("x^2",res.toString());
    }
}