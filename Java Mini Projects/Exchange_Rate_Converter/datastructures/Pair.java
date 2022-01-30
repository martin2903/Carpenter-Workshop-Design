package Exchange_Rate_Converter.datastructures;


public class Pair {
    private String base;
    private String quote;
    private double rate;

    public Pair(String base, String quote, double rate){
        this.base = base;
        this.quote = quote;
        this.rate = rate;
    }
    public Pair(){}

    public void setBase(String base){
        this.base=base;
    }

    public String getBase(){
        return this.base;
    }

    public void setQuote(String quote){
        this.quote=quote;
    }

    public String getQuote(){
        return this.quote;
    }
    public void setRate(double rate){
        this.rate = rate;
    }

    public double getRate(){
        return this.rate;
    }
}
