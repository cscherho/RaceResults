package com.exxeta.allesTesten.packa;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AdditorTest {

    @ParameterizedTest
    @ValueSource(doubles = {3.4, 4.2, 6.8})
    public void additionTest(double firstSummand) {
        Additor additor = new Additor();
//        BigDecimal firstSummand = BigDecimal.valueOf(5.6);
        BigDecimal secondSummand = BigDecimal.valueOf(8.4);
        assertEquals(additor.add(BigDecimal.valueOf(firstSummand), secondSummand),
                    BigDecimal.valueOf(firstSummand).add(secondSummand), "The objects are not equal");
//        assertThat(additor.add(firstSummand, secondSummand).equals(BigDecimal.valueOf(14.00))).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
        "3.4, 2.2, 5.6",
        "3.1, 11.4, 14.5",
        "6.7, 4.8, 11.5"
    })
    public void multiTest(double firstSummand, double secondSummand, double result) {
        Additor additor = new Additor();
        BigDecimal firstSummandBigDecimal = BigDecimal.valueOf(firstSummand);
        BigDecimal secondSummandBigDecimal = BigDecimal.valueOf(secondSummand);

        assertEquals(BigDecimal.valueOf(result),
            additor.add(firstSummandBigDecimal, secondSummandBigDecimal),
            "The result seems to be wrong!");
    }

    @Test
    public void throwError() {
        Additor additor = new Additor();

//        BigDecimal divideByZero = additor.divide(BigDecimal.valueOf(8), BigDecimal.ZERO);
//        assertEquals(BigDecimal.ZERO, divideByZero);
        assertThatExceptionOfType(ArithmeticException.class).
            isThrownBy(() -> additor.divide(BigDecimal.valueOf(5.8), BigDecimal.valueOf(0.0)));
    }
}
