package auditoriska1;
import java.math.BigDecimal;

public class BigComplex {
    private BigDecimal real;
    private BigDecimal imag;

    public BigComplex(BigDecimal real, BigDecimal imag) {
        this.real = real;
        this.imag = imag;
    }
    public BigComplex add(BigComplex complex){ //complex e objekt
        BigDecimal real = this.real.add(complex.real);
        BigDecimal imag = this.imag.add(complex.imag);

        return new BigComplex(real,imag);
    }
    public BigComplex substract(BigComplex complex){
        BigDecimal real = this.real.subtract(complex.real);
        BigDecimal imag = this.imag.subtract(complex.imag);

        return new BigComplex(real,imag);
    }
    public BigComplex multiply(BigComplex complex){
        BigDecimal real = this.real.multiply(complex.real);
        BigDecimal imag = this.imag.multiply(complex.imag);

        return new BigComplex(real,imag);
    }
    public BigComplex divide(BigComplex complex){
        BigDecimal real = this.real.divide(complex.real);
        BigDecimal imag = this.imag.divide(complex.imag);

        return new BigComplex(real,imag);
    }

}
