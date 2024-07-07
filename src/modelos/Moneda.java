package modelos;

public enum Moneda {
    ARS("ARS", "Pesos Argentinos"),
    USD("USD", "Dólares"),
    BRL("BRL", "Reales Brasileños"),
    COP("COP", "Pesos Colombianos");

    private final String codigo;
    private final String nombre;

    Moneda(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
}


