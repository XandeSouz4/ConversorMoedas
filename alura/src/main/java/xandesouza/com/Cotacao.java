package xandesouza.com;
import java.util.Map;

public class Cotacao {
    private String base_code;
    private Map<String, Float> conversion_rates;
    public Cotacao(String base_code) {
        this.base_code = base_code;
    }
    public String pegaBaseCode() {
        return base_code; 
    }
    public void setaBaseCode(String base_code) {
        this.base_code = base_code;
    }
    public Map<String, Float> pegaConversionRates() {
        return conversion_rates;
    }
    public void setaConversionRates(Map<String, Float> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }
}
