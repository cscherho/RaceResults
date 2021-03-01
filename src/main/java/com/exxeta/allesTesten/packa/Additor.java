package com.exxeta.allesTesten.packa;

import java.math.BigDecimal;

public class Additor {


    public BigDecimal add(BigDecimal firstSummand, BigDecimal secondSummand) {
        return firstSummand.add(secondSummand);
    }

    public BigDecimal divide(BigDecimal dividor, BigDecimal divisor) throws ArithmeticException{
        return dividor.divide(divisor);
//        try {
//            return dividor.divide(divisor);
//        } catch (ArithmeticException arithmeticException) {
//            return BigDecimal.ZERO;
//        }
    }
}
