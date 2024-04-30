import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;



public class TipoDeCambio {

    @SerializedName("base_code")
    private String monedaBase;

    @SerializedName("conversion_rates")
    private String monedaDestino;

    private double totalConvertir;
    private double totalConvertido;
    private Apiconector apiconector;


    public TipoDeCambio() {
        this.apiconector = new Apiconector();
    }

    public TipoDeCambio(String codigoDe, String codigoA, double monto, double resultado) {
        this.monedaBase = codigoDe;
        this.monedaDestino = codigoA;
        this.totalConvertir = monto;
        this.totalConvertido = resultado;
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public double getTotalConvertido() {
        return totalConvertido;
    }

    public double getTotalConvertir() {
        return totalConvertir;
    }

    public void setTotalConvertir(double totalConvertir) {
        this.totalConvertir = totalConvertir;
    }

    public double convertidor(String monedaBase, String monedaDestino, double totalConvertir) throws Exception {
        String key = "7a1c0de4f6d45cd06a72977c";
        String url = "https://v6.exchangerate-api.com/v6/" + key + "/pair/" + monedaBase + "/" + monedaDestino + "/" + totalConvertir;

        String responseJson = apiconector.takeResponse(url);
        if (responseJson == null || responseJson.isEmpty()) {
            throw new Exception("Error: No se pudo obtener respuesta de la API");
        }

        Gson gson = new Gson();
        ExchangeRateApiResponse response = gson.fromJson(responseJson, ExchangeRateApiResponse.class);
        double conversionRate = response.getConversionRate();

        if (checkResponse(monedaBase, monedaDestino)) {
            this.monedaBase = monedaBase;
            this.monedaDestino = monedaDestino;
            this.totalConvertir = totalConvertir;
            this.totalConvertido = totalConvertir * conversionRate;
        } else {
            throw new Exception("La moneda de cambio seleccionada no hace parte de la lista");
        }
        return this.totalConvertido;
    }

    private boolean checkResponse(String monedaBase, String monedaDestino) {
        // Aquí puedes implementar la lógica para verificar si las monedas están en la lista de conversión
        // Por ahora, simplemente devolveré true para indicar que la verificación es exitosa
        return true;
    }

    @Override
    public String toString() {
        return "TipoDeCambio{" +
                "monedaBase='" + monedaBase + '\'' +
                ", monedaDestino='" + monedaDestino + '\'' +
                ", totalConvertir=" + totalConvertir +
                ", totalConvertido=" + totalConvertido +
                '}';
    }
}

