public class Model {
    static final String initial="";
    private String m_result;
    Model(){
        reset();
    }
    public void reset() {
        m_result = initial;
    }

    public void setValue(String value) {
        m_result = value;
    }

}
