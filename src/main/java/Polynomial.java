import java.util.ArrayList;
import java.util.List;

public class Polynomial {
    private List<Monomial> monomialList;

    public Polynomial(){
        monomialList = new ArrayList<>();
    }
    public Polynomial(List<Monomial> monomial){
        monomialList = monomial;
    }
    public List<Monomial> getPolynomial() {
        return monomialList;
    }

    public void addMonomial(Monomial m) {
        this.monomialList.add(m);
    }

    public void setMonomialList(List<Monomial> monomialList) {
        this.monomialList = monomialList;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Monomial el : this.monomialList){
            if(el.getCoefficient()>=0)
                sb.append("+");
            sb.append(el.toString());
        }
        if(sb.charAt(0)=='+')
        {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

}
