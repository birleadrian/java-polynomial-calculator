import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    @Test
    void getPolynomial() {
        Monomial m = new Monomial(2,2);
        Monomial m1 = new Monomial(3,4);
        Polynomial p = new Polynomial();
        p.addMonomial(m);
        p.addMonomial(m1);
        assertEquals(2,p.getPolynomial().get(0).getCoefficient());
        assertEquals(2,p.getPolynomial().get(0).getExponent());
        assertEquals(3,p.getPolynomial().get(1).getCoefficient());
        assertEquals(4,p.getPolynomial().get(1).getExponent());
    }

    @Test
    void addMonomial() {
        Monomial m = new Monomial(1,5);
        Polynomial p = new Polynomial();
        p.addMonomial(m);
        assertEquals(1,p.getPolynomial().get(0).getCoefficient());
        assertEquals(5,p.getPolynomial().get(0).getExponent());
    }

    @Test
    void setMonomialList() {
        Monomial m = new Monomial(1,5);
        Monomial m1 = new Monomial(3,1);
        Polynomial p = new Polynomial();
        List<Monomial> mList = new ArrayList<>();
        mList.add(m);
        mList.add(m1);
        p.setMonomialList(mList);
        assertEquals(1,p.getPolynomial().get(0).getCoefficient());
        assertEquals(5,p.getPolynomial().get(0).getExponent());
        assertEquals(3,p.getPolynomial().get(1).getCoefficient());
        assertEquals(1,p.getPolynomial().get(1).getExponent());
    }
}