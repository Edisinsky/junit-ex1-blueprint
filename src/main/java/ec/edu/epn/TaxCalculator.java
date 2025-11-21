package ec.edu.epn;

public class TaxCalculator {
    public double calculateTax(double valor, double impuesto) {
        if (valor < 0 || impuesto < 0) {
            throw new IllegalArgumentException("Amount and tax rate must be non-negative");
        }
        return valor * impuesto;
    }
}
