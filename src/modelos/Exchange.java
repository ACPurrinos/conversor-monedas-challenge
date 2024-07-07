package modelos;

public class Exchange {

    private String monedaOrigen;
    private String monedaFinal;
    private double tasaDeConversion;

    public Exchange(String monedaOrigen, String monedaFinal, double tasaDeConversion) {
        this.monedaOrigen = monedaOrigen;
        this.monedaFinal = monedaFinal;
        this.tasaDeConversion = tasaDeConversion;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public String getMonedaFinal() {
        return monedaFinal;
    }

    public void setMonedaFinal(String monedaFinal) {
        this.monedaFinal = monedaFinal;
    }

    public double getTasaDeConversion() {
        return tasaDeConversion;
    }


    @Override
    public String toString() {
        return String.format("De %s a %s con tasa %.4f", monedaOrigen, monedaFinal, tasaDeConversion);
    }
}
