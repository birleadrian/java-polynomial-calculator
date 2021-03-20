import java.util.Collections;
import java.util.Comparator;

public class Operation {
    private static Polynomial rest;
    //---------Operatii pe monom---------
    public static Monomial add(Monomial m1, Monomial m2) {
        double aux;
        aux = m1.getCoefficient() + m2.getCoefficient();
        Monomial m = new Monomial(aux,m1.getExponent());
        return m;
    }
    public static Monomial sub(Monomial m1, Monomial m2){
        double aux;
        aux = m1.getCoefficient() - m2.getCoefficient();
        Monomial m = new Monomial(aux, m1.getExponent());
        return m;
    }
    public static Monomial multiply(Monomial m1 , Monomial m2){
        int auxExp;
        double auxCoef;
        auxCoef = m1.getCoefficient() * m2.getCoefficient();
        auxExp = m1.getExponent() + m2.getExponent();
        Monomial m = new Monomial(auxCoef,auxExp);
        return m;
    }
    public static Monomial divide(Monomial m1, Monomial m2){
        int auxExp;
        double auxCoef;
        auxCoef = m1.getCoefficient() / m2.getCoefficient();
        auxExp = m1.getExponent() - m2.getExponent();
        Monomial m = new Monomial(auxCoef,auxExp);
        return m;
    }
    public static Monomial derivative(Monomial m1){
        int exp;
        double coef;
        coef = m1.getCoefficient() * m1.getExponent();
        exp = m1.getExponent() - 1;

        Monomial m = new Monomial(coef,exp);
        return m;
    }
    public static Monomial integral(Monomial m1){
        int exp;
        double coef;
        coef = m1.getCoefficient()/(m1.getExponent()+1);
        exp = m1.getExponent() + 1;

        Monomial m = new Monomial(coef,exp);
        return m;
    }
    //----------------------------------------------------------------------------------


    //---------Operatii pe polinom---------
    //---------------Adunarea a doua polinoame---------------
    public static Polynomial add(Polynomial p1 , Polynomial p2) {
        Polynomial result = new Polynomial();
        //Adaugam primul polinom in polinomul final
        for(Monomial m1 : p1.getPolynomial()){
            result.addMonomial(m1);
        }
        //Adaugam al doilea polinom in polinomul final
        for(Monomial m2 : p2.getPolynomial()){
            result.addMonomial(m2);
        }
        //Adunam polinoamele cu exponenti egali si ii punem doar o singura data polinomul final , pe celalalt il stergem
        for(Monomial m1: p1.getPolynomial())
        {
            for(Monomial m2 : p2.getPolynomial()){
                if(m1.getExponent()==m2.getExponent())
                {
                    Monomial m = add(m1,m2);
                    result.getPolynomial().remove(m1);
                    result.getPolynomial().remove(m2);
                    if(m.getCoefficient()!=0)
                    {result.addMonomial(m);}
                }
            }
        }
        //Sortam polinomul descrescator dupa exponent
        Collections.sort(result.getPolynomial(), new Sortbyexp());
        return result;
    }


    //---------------Scaderea a doua polinoame---------------
    public static Polynomial sub(Polynomial p1 , Polynomial p2){
        Polynomial result = new Polynomial();
        Polynomial paux = new Polynomial();
        for(Monomial m1 : p1.getPolynomial()){
            result.addMonomial(m1);
        }
        for(Monomial m2 : p2.getPolynomial()){
            Monomial aux = new Monomial();
            aux.setCoefficient(-m2.getCoefficient());
            aux.setExponent(m2.getExponent());
            result.addMonomial(aux);
            paux.addMonomial(aux);
        }
        for(Monomial m1: p1.getPolynomial())
        {
            for(Monomial m2 : paux.getPolynomial()){
                if(m1.getExponent()==m2.getExponent())
                {
                    Monomial m = add(m1,m2);
                    result.getPolynomial().remove(m1);
                    result.getPolynomial().remove(m2);
                    if(m.getCoefficient()!=0){
                    result.addMonomial(m);}
                }
            }
        }
        //
        Collections.sort(result.getPolynomial(), new Sortbyexp());
        return result;
    }


    //---------------Inmultirea a doua polinoame---------------
    public static Polynomial multiply(Polynomial p1, Polynomial p2){
        Polynomial result = new Polynomial();
        for(Monomial m1 : p1.getPolynomial())
            for(Monomial m2 : p2.getPolynomial()) {
                Monomial m = multiply(m1,m2);
                result.addMonomial(m);
            }
        for(int i=0 ; i< result.getPolynomial().size()-1; i++)
            for(int j=i+1 ; j < result.getPolynomial().size() ; j++) {
                Monomial m1 = result.getPolynomial().get(i);
                Monomial m2 = result.getPolynomial().get(j);
                if (m1.getExponent() == m2.getExponent()) {
                    Monomial m = add(m1, m2);
                    result.getPolynomial().remove(m1);
                    result.getPolynomial().remove(m2);
                    if(m.getCoefficient()!=0) {
                        result.addMonomial(m);
                    }
                    i=0; //E posibil ca in urma sumei dintre 2 polinoame sa ramana un alt polinom de acelasi grad si trebuie verificat iar.
                }
            }
        Collections.sort(result.getPolynomial(), new Sortbyexp());
        return result;
    }

    //---------------Impartirea a doua polinoame---------------
    public static Polynomial divide(Polynomial p1, Polynomial p2){

        Polynomial result = new Polynomial();
        Polynomial aux = new Polynomial();
        Polynomial copyP1 = new Polynomial(p1.getPolynomial());
        rest = new Polynomial();
        while((!copyP1.getPolynomial().isEmpty())&&copyP1.getPolynomial().get(0).getExponent()>=p2.getPolynomial().get(0).getExponent()) {
            Monomial m = divide(copyP1.getPolynomial().get(0), p2.getPolynomial().get(0));
            Monomial m_aux = new Monomial(m.getCoefficient(),m.getExponent());
            result.addMonomial(m);
            double coef = m_aux.getCoefficient();
            m_aux.setCoefficient(-coef);
            aux.addMonomial(m_aux);
            Polynomial aux2 = multiply(aux, p2);
            Polynomial deepCopy = add(copyP1,aux2);
            copyP1.setMonomialList(deepCopy.getPolynomial());
            aux.getPolynomial().remove(m_aux);
            rest.setMonomialList(copyP1.getPolynomial());
        }
        return result;
    }

    public static Polynomial derivative(Polynomial p1){
        Polynomial result = new Polynomial();
        for(Monomial m : p1.getPolynomial()){
            if(m.getExponent()!=0)
            {
                Monomial aux = derivative(m);
                if(aux.getCoefficient()!=0)
                result.addMonomial(aux);
            }
        }
        Collections.sort(result.getPolynomial(), new Sortbyexp());
        return result;
    }

    public static Polynomial integrative(Polynomial p1){
        Polynomial result = new Polynomial();
        for(Monomial m : p1.getPolynomial()){
            if(m.getExponent()==0){
                Monomial aux = new Monomial(m.getCoefficient(),1);
                result.addMonomial(aux);
            }else {
                Monomial aux = integral(m);
                result.addMonomial(aux);
            }
        }
        Collections.sort(result.getPolynomial(), new Sortbyexp());
        return result;
    }

    public static Polynomial getRest() {
        return rest;
    }

    //Sortari
    static class Sortbyexp implements Comparator<Monomial>
    {
        public int compare(Monomial a, Monomial b)
        {
            Integer exp1 = a.getExponent();
            Integer exp2 = b.getExponent();
            return exp2.compareTo(exp1);
        }
    }
}
