public class Monomial {

    private int exponent;
    private double coefficient;

    public Monomial(double coefficient, int exponent)
    {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public Monomial(){

    }
    public int getExponent() {
        return exponent;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    @Override
    public String toString(){
        if(this.coefficient==0){
            return "";
        } else if(this.exponent==0) {
            if(this.coefficient==Math.ceil(this.coefficient)) {return String.valueOf((int)this.coefficient);}
            else {return String.valueOf(this.coefficient);}
        } else if(this.coefficient==1) {
            if(this.exponent==1) { return "x"; }
            else { return "x^" + this.exponent; }
        } else if(this.coefficient==-1) {
            if(this.exponent==1) { return "-x"; }
            else { return "-x^" + this.exponent; }
        } else if(this.exponent==1) {
            if(this.coefficient==Math.ceil(this.coefficient)) { return (int)this.coefficient + "x";}
            else { return this.coefficient + "x";}
        } else if(this.coefficient==Math.ceil(this.coefficient)) { return (int)this.coefficient + "x^" + this.exponent;
        } else { return this.coefficient + "x^" + this.exponent;}
    }
}
