public class Main {
    public static void main(String[] args) {
        //Clasa unde am testat operatiile in consola
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        Polynomial res = new Polynomial();
        Polynomial rest = new Polynomial();
        Monomial m1 = new Monomial(6, 4); //6x^4
        Monomial m2 = new Monomial(3, 3); //3x^3
        Monomial m3 = new Monomial(2, 2); //2x^2
        Monomial m4 = new Monomial(2, 1); //x
        Monomial m5 = new Monomial(2, 3); //2x^3
        Monomial m6 = new Monomial(5, 2); //5x^2
        Monomial m7 = new Monomial(3, 1); //3x
        p1.addMonomial(m1);
        p1.addMonomial(m2);
        p1.addMonomial(m3);
        p1.addMonomial(m4);
        p2.addMonomial(m5);
        p2.addMonomial(m6);
        p2.addMonomial(m7);
        System.out.println("Polinomul 1: " + p1);
        System.out.println("Polinomul 2: " + p2);
        System.out.println("-------Suma polinoamelor-----");
        res = Operation.add(p1, p2);
        System.out.println(res);

        System.out.println("-------Diferenta polinoamelor------");
        res = Operation.sub(p1,p2);
        System.out.println(res);


        System.out.println("-------Inmultirea polinoamelor------");
        res = Operation.multiply(p1,p2);
        System.out.println(res);

        System.out.println("-------Impartirea polinoamelor------");
        res = Operation.divide(p1,p2);
        rest = Operation.getRest();
        System.out.println("Catul este: " + res);
        System.out.println("Restul este: " + rest);

        System.out.println("-------Derivata unui polinom------");
        res = Operation.derivative(p1);
        System.out.println(res);

        System.out.println("-------Integrala unui polinom------");
        res = Operation.integrative(p1);
        System.out.println(res);
    }
}
