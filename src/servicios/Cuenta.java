package servicios;

import modelos.Exchange;

public class Cuenta {

    public double convierteMonto(double monto, double tasaDeConversion) {
        double totalConvertido;
        totalConvertido = monto * tasaDeConversion;
        return totalConvertido;
    }
}
