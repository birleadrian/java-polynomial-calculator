import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import java.awt.event.*;

public class Controller {

    private Model m_model;
    private View m_view;

    Controller(Model model, View view) {
        m_model = model;
        m_view = view;

        view.addSumListener(new AddListener());
        view.addSubtractListener(new SubListener());
        view.addMultiplyListener(new MultiplyListener());
        view.addDivideListener(new DivideListener());
        view.addDerivativeListener(new DerivativeListener());
        view.addIntegrativeListener(new IntegrativeListener());
    }

    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInputP1 = "";
            String userInputP2 = "";
            userInputP1 = m_view.getUserInputP1();
            userInputP2 = m_view.getUserInputP2();
            if(onlyLetters(userInputP1)==true || onlyLetters(userInputP2)==true)
            {
                JOptionPane.showMessageDialog(m_view, "Nu ai introdus un polinom corect");
                m_view.reset();
                return;
            }
            Polynomial p1 = new Polynomial();
            Polynomial p2 = new Polynomial();
            Polynomial result = new Polynomial();
            if (userInputP1.isEmpty() || userInputP2.isEmpty()) {
                JOptionPane.showMessageDialog(m_view, "Nu ai introdus unul dintre polinoame");
                m_view.reset();
                return;
            }
            p1 = getPolynomial(userInputP1);
            p2 = getPolynomial(userInputP2);
            result = Operation.add(p1, p2);
            m_view.setResult(result.toString());
        }
    }

    class SubListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInputP1 = "";
            String userInputP2 = "";
            userInputP1 = m_view.getUserInputP1();
            userInputP2 = m_view.getUserInputP2();
            if(onlyLetters(userInputP1)==true || onlyLetters(userInputP2)==true)
            {
                JOptionPane.showMessageDialog(m_view, "Nu ai introdus un polinom corect");
                m_view.reset();
                return;
            }
            Polynomial p1 = new Polynomial();
            Polynomial p2 = new Polynomial();
            Polynomial result = new Polynomial();
            if (userInputP1.isEmpty() || userInputP2.isEmpty()) {
                JOptionPane.showMessageDialog(m_view, "Nu ai introdus unul dintre polinoame");
                m_view.reset();
                return;
            }
            p1 = getPolynomial(userInputP1);
            p2 = getPolynomial(userInputP2);
            result = Operation.sub(p1, p2);
            try{
                m_view.setResult(result.toString());
            } catch(Exception ex){
                m_view.setResult("0");
            }
        }
    }

    class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInputP1 = "";
            String userInputP2 = "";
            userInputP1 = m_view.getUserInputP1();
            userInputP2 = m_view.getUserInputP2();
            if(onlyLetters(userInputP1)==true || onlyLetters(userInputP2)==true)
            {
                JOptionPane.showMessageDialog(m_view, "Nu ai introdus un polinom corect");
                m_view.reset();
                return;
            }
            Polynomial p1 = new Polynomial();
            Polynomial p2 = new Polynomial();
            Polynomial result = new Polynomial();
            if (userInputP1.isEmpty() || userInputP2.isEmpty()) {
                JOptionPane.showMessageDialog(m_view, "Nu ai introdus unul dintre polinoame");
                m_view.reset();
                return;
            }
            p1 = getPolynomial(userInputP1);
            p2 = getPolynomial(userInputP2);
            if((p1.getPolynomial().get(0).getCoefficient()==0 && p1.getPolynomial().get(0).getExponent()==0) || (p2.getPolynomial().get(0).getCoefficient()==0 && p2.getPolynomial().get(0).getExponent()==0))
            {
                m_view.setResult("0");
                return;
            }
            result = Operation.multiply(p1, p2);
            m_view.setResult(result.toString());
        }
    }

    class DivideListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInputP1 = "";
            String userInputP2 = "";
            userInputP1 = m_view.getUserInputP1();
            userInputP2 = m_view.getUserInputP2();
            if(onlyLetters(userInputP1)==true || onlyLetters(userInputP2)==true)
            {
                JOptionPane.showMessageDialog(m_view, "Nu ai introdus un polinom corect");
                m_view.reset();
                return;
            }
            Polynomial p1 = new Polynomial();
            Polynomial p2 = new Polynomial();
            Polynomial result = new Polynomial();
            if (userInputP1.isEmpty() || userInputP2.isEmpty()) {
                JOptionPane.showMessageDialog(m_view, "Nu ai introdus unul dintre polinoame");
                m_view.reset();
                return;
            }
            p1 = getPolynomial(userInputP1);
            p2 = getPolynomial(userInputP2);
            if(p1.getPolynomial().get(0).getExponent()<p2.getPolynomial().get(0).getExponent())
            {
                JOptionPane.showMessageDialog(m_view, "Nu se poate imparti. Verifica polinoamele introduse.");
                m_view.reset();
                return;
            }
            if(p2.getPolynomial().get(0).getCoefficient()==0&&p2.getPolynomial().get(0).getExponent()==0)
            {
                JOptionPane.showMessageDialog(m_view, "Nu se poate imparti cu 0.");
                m_view.reset();
                return;
            }
            result = Operation.divide(p1, p2);
            Polynomial rest = new Polynomial();
            rest = Operation.getRest();
            if(!(rest.getPolynomial().isEmpty()))
                m_view.setResult("Quotient: " + result.toString() + " | Reminder: " + rest);
            else
                m_view.setResult("Quotient: " + result.toString() + " | Reminder: 0");
        }
    }

    class DerivativeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInputP3 = "";
            userInputP3 = m_view.getUserInputP3();
            if(onlyLetters(userInputP3)==true)
            {
                    JOptionPane.showMessageDialog(m_view, "Nu ai introdus un polinom corect");
                    m_view.reset();
                    return;
            }
            Polynomial p3 = new Polynomial();
            Polynomial result = new Polynomial();
            if (userInputP3.isEmpty()) {
                JOptionPane.showMessageDialog(m_view, "Nu ai introdus polinomul");
                m_view.reset();
                return;
            }
            p3 = getPolynomial(userInputP3);
            if(p3.getPolynomial().get(0).getExponent()==0)
            {
                m_view.setResult("0");
                return;
            }
            result = Operation.derivative(p3);
            m_view.setResult(result.toString());
        }
    }

    class IntegrativeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInputP3 = "";
            userInputP3 = m_view.getUserInputP3();
            if(onlyLetters(userInputP3)==true)
            {
                JOptionPane.showMessageDialog(m_view, "Nu ai introdus un polinom corect");
                m_view.reset();
                return;
            }
            Polynomial p3 = new Polynomial();
            Polynomial result = new Polynomial();
            if (userInputP3.isEmpty()) {
                JOptionPane.showMessageDialog(m_view, "Nu ai introdus polinomul");
                m_view.reset();
                return;
            }
            p3 = getPolynomial(userInputP3);
            if(p3.getPolynomial().get(0).getExponent()==0 && p3.getPolynomial().get(0).getCoefficient()==0)
            {
                m_view.setResult("0");
                return;
            }
            result = Operation.integrative(p3);
            m_view.setResult(result.toString());
        }
    }

    public static Polynomial getPolynomial(String p1) {
        String monomialPattern = "([-+]?)(\\d*\\.?\\d*)?([xX](\\^-?\\d*\\.?\\d*)?)?";
        Pattern pattern = Pattern.compile(monomialPattern);
        String pol1 = p1;
        pol1 = pol1.replaceAll("\\s+", "");
        Matcher matcher = pattern.matcher(pol1);
        Monomial m;
        Polynomial p = new Polynomial();
        while (matcher.find()) {
            String g1 = matcher.group(1);
            String g2 = matcher.group(2);
            String g3 = matcher.group(3);
            String g4 = matcher.group(4);
            int coeff, exp;
            try {
                if (g1.isEmpty() && g2.isEmpty() && g3.equals(null) && g4.equals(null))
                    break;
                else {
                    if (g2.isEmpty()) {
                        if (g1.equals("-")) {
                            coeff = -1;
                        } else {
                            coeff = 1;
                        }
                    } else {
                        if (g1.equals("-"))
                            coeff = -Integer.parseInt(g2);
                        else
                            coeff = Integer.parseInt(g2);
                    }
                    String xp = "";
                    if (g4 == null) {
                        if (g3 == null)
                            exp = 0;
                        else
                            exp = 1;
                    } else {
                        for (int i = 1; i < g4.length(); i++) {
                            xp += g4.charAt(i);
                        }
                        exp = Integer.parseInt(xp);
                    }
                }
                m = new Monomial(coeff, exp);
                p.addMonomial(m);
            } catch (NullPointerException ex) {

            }
        }
        return p;
    }
    public static boolean onlyLetters(String text){
        int cnt = 0;
        if(text.isEmpty())
            return false;
        char[] chars = text.toCharArray();
        for(char c : chars){
            if(!Character.isLetter(c))
                return false;
            else
                cnt++;
        }
        if(text.equals("x") || text.equals("X"))
            return false;
        if(cnt==chars.length)
            return true;
        return false;
    }
}
