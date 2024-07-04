import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    String monedaDesde;
    double valorAConvertir;
    String monedaHacia;
    public Conversor(String monedaDesde, double valorAConvertir, String monedaHacia) {
        this.monedaDesde = monedaDesde;
        this.valorAConvertir = valorAConvertir;
        this.monedaHacia = monedaHacia;
    }

    public double resultado(){
        String url = "https://v6.exchangerate-api.com/v6/988843d30b22734be2ddaea8/latest/USD";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
            double usd = conversionRates.get("USD").getAsDouble();
            double ars = conversionRates.get("ARS").getAsDouble();
            double cop = conversionRates.get("COP").getAsDouble();
            double clp = conversionRates.get("CLP").getAsDouble();
            double brl = conversionRates.get("BRL").getAsDouble();
            Monedas monedas = new Monedas(usd, ars, cop, clp, brl);
            double monedaDivisa=0;
            if (monedaHacia.equals("USD")){
                if (monedaDesde.equals("ARS")){
                    monedaDivisa= monedas.ARS();
                }
                if (monedaDesde.equals("CLP")){
                    monedaDivisa= monedas.CLP();
                }
                if (monedaDesde.equals("COP")){
                    monedaDivisa= monedas.COP();
                }
                if (monedaDesde.equals("BRL")){
                    monedaDivisa= monedas.BRL();
                }
            }
            if (monedaHacia.equals("ARS")){
                monedaDivisa= monedas.ARS();
            }
            if (monedaHacia.equals("CLP")){
                monedaDivisa= monedas.CLP();
            }
            if (monedaHacia.equals("COP")){
                monedaDivisa= monedas.COP();
            }
            if (monedaHacia.equals("BRL")){
                monedaDivisa= monedas.BRL();
            }

            double result;
            if (monedaDesde.equals("USD")){
                result = valorAConvertir*monedaDivisa;
                System.out.println(monedas);
            }
            else{
                result = valorAConvertir/monedaDivisa;
            }
            String text = "Valor de la moneda local: "+ monedaDivisa;
            Utilidades.imprimirConPausa(text,2);
            text = valorAConvertir +" " + monedaDesde + " equivalen a : "+ result + " "+ monedaHacia;
            Utilidades.imprimirConPausa(text,2);
            return result;

        } catch ( Exception e) {
            System.out.println("Error: "+ e);
        }

        return 0;

    }
}
