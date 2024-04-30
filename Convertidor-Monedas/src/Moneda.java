public class Moneda {

    private String monedaBase;

    public String getMonedaBase(){
        return monedaBase;
    }

    public void setMonedaBase(String codigoBase) {
        this.monedaBase = codigoBase;
    }

    public Moneda() {
    }

    public Moneda(String codigoBase) {
        this.monedaBase = codigoBase;
    }
}