package com.company;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class OnpCalcTest {

    @ParameterizedTest()
    @CsvSource({
            "0+0, _0__0_+",
            "1.1+7, _1.1__7_+",
            "2+3-1, _2__3_+_1_-",
            "2+3-4, _2__3_+_4_-",
            "2*3*4, _2__3_*_4_*",
            "2/3*4, _2__3_/_4_*",
            "2^4^6, _2__4_^_6_^"
    })
    void test_whenMakeTranslateInfixToOnp_givenInfixFormulasWithSameOperatorPriority_thenShouldReturnExpectedValue(String expression, String expected) throws Exception {
        //given
        //given from CsvSource

        //when
        String result = OnpCalc.infixToOnp(expression);

        //then
        assertEquals(expected, result);
    }

    @ParameterizedTest()
    @CsvSource({
            "0+0*2, _0__0__2_*+",
            "1.1+7/4, _1.1__7__4_/+",
            "2+3^1, _2__3__1_^+",
            "2^3+4, _2__3_^_4_+",
            "2*3-4, _2__3_*_4_-",
            "2/3^4, _2__3__4_^/",
    })
    void test_whenMakeTranslateInfixToOnp_givenInfixFormulasWithDifferentOperatorPriority_thenShouldReturnExpectedValue(String expression, String expected) throws Exception {
        //given
        //given from CsvSource

        //when
        String result = OnpCalc.infixToOnp(expression);

        //then
        assertEquals(expected, result);
    }

    @ParameterizedTest()
    @CsvSource({
            "2+2/0.000",
            "2/0.000+1",
            "2*3/0.0",
            "3+3+3+3+-4^2/0.0*6",
            "2^0/0.00",
    })
    void test_whenMakeTranslateInfixToOnp_givenInfixFormulasWithDivideByZero_thenShouldThrowException(String expression) throws Exception {
        //given
        //given from CsvSource

        //when
        //no result

        //then
        assertThrows(Exception.class, () -> OnpCalc.infixToOnp(expression));
    }

    @ParameterizedTest()
    @CsvSource({
            "2+2/0.0001",
            "2/0.0010+1",
            "2*3/0.02",
            "3+3+3+3+-4^2/3*6",
            "2^0/1",
    })
    void test_whenMakeTranslateInfixToOnp_givenInfixFormulasWithDivideByAnythingExceptZero_thenShouldNotThrowException(String expression) throws Exception {
        //given
        //given from CsvSource

        //when
        //no result

        //then
        assertDoesNotThrow(() -> OnpCalc.infixToOnp(expression));
    }

    @ParameterizedTest()
    @CsvSource({
            "(2+2), _2__2_+",
            "(2+2)*3, _2__2_+_3_*",
            "3*(2+2), _3__2__2_+*",
            "6^(2+2)*(9+9), _6__2__2_+^_9__9_+*",
            "(2+2)/((4*4)-3), _2__2_+_4__4_*_3_-/",
    })

    void test_whenMakeTranslateInfixToOnp_givenInfixFormulasWithBracket_thenShouldGiveExpectedValue(String expression, String expected) throws Exception {
        //given
        //given from CsvSource

        //when
        String result = OnpCalc.infixToOnp(expression);

        //then
        assertEquals(expected, result);
    }

    @ParameterizedTest()
    @CsvSource({
            "_2__2_+, 4.0",
            "_2__2_+_3_*, 12.0",
            "_3__2__2_+*, 12.0",
            "_6__2__2_+^_9__9_+*, 23328.0",
            "_3__3_*_9_/_4_^, 1.0",
    })
    void test_whenCalculateOnp_givenOnpFormula_thenShouldGiveExpectedValueNaturalNumber(String expression, String expected) throws Exception {
        //given
        //given from CsvSource

        //when
        String result = OnpCalc.calculateOnp(expression);

        //then
        assertEquals(expected, result);
    }

    @ParameterizedTest()
    @CsvSource({
            "_2__2_+_8_/, 0.5",
            "_2__2_+_3_*_5_/, 2.4",
            "_3__10_/, 0.3",
            "_0.2__2_*, 0.4",
    })
    void test_whenCalculateOnp_givenOnpFormula_thenShouldGiveExpectedValueNotNaturalNumber(String expression, String expected) throws Exception {
        //given
        //given from CsvSource

        //when
        String result = OnpCalc.calculateOnp(expression);

        //then
        assertEquals(expected, result);
    }

    @ParameterizedTest()
    @CsvSource({
            "_2__2_-",
            "_2__2_/_1_-",
            "_3__9_*_27_-",
            "_8__4_*_2_/_16_-",
            "_6__6_*_4_/_9_/_1_-"
    })
    void test_whenCalculateOnp_givenOnpFormula_thenShouldGiveExpectedValueEqualZero(String expression) throws Exception {
        //given
        //given from CsvSource

        //when
        String result = OnpCalc.calculateOnp(expression);

        //then
        assertEquals("0.0", result);
    }

}