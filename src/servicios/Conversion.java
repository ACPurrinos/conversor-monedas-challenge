package servicios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import modelos.Exchange;
import modelos.Moneda;
import vista.Menu;

import java.util.Scanner;

public class Conversion {

    public double ConsultaAPI(String codigo, String codigoFinal) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        String clave = "TU-API-KEY-AQUI"; // Reemplaza con tu clave de API
        String direccion2 = "https://v6.exchangerate-api.com/v6/" + clave + "/latest/" + codigo;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion2))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        //System.out.println("Lo que recibo en el body:" + json);

        double tasaDeConversion = 0.0;

        try {
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

            // Verificar si la propiedad "conversion_rates" está presente en el JSON
            if (jsonObject.has("conversion_rates")) {
                JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

                // Obtener la tasa de conversión para el código específico
                if (conversionRates.has(codigoFinal)) {
                    tasaDeConversion = conversionRates.get(codigoFinal).getAsDouble();
                    Exchange exchange = new Exchange(codigo, codigoFinal, tasaDeConversion);//ojo
                    return exchange.getTasaDeConversion(); //ojo
                } else {
                    System.out.println("No se encontró el código de moneda en la respuesta JSON.");
                }
            } else {
                System.out.println("No se encontró la propiedad 'conversion_rates' en la respuesta JSON.");
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la respuesta JSON: " + e.getMessage());
            e.printStackTrace();
        }


       return tasaDeConversion;
    }
}
