package EquationSystem.trigFunctions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SecTest {
    private Cos cos;
    private Sin sin;
    private Sec sec;

    @BeforeEach
    void setUp() {
        sin = Mockito.mock(Sin.class);
        when(sin.calculate(Math.PI)).thenReturn(0.0);
        when(sin.calculate(Math.PI / 12)).thenReturn((Math.sqrt(6) - Math.sqrt(2)) / 4);
        when(sin.calculate(Math.PI / 8)).thenReturn(Math.sqrt(2 - Math.sqrt(2)) / 2);
        when(sin.calculate(Math.PI / 6)).thenReturn(0.5);
        when(sin.calculate(Math.PI / 4)).thenReturn(Math.sqrt(2) / 2);
        when(sin.calculate(Math.PI / 2)).thenReturn(1.0);
        when(sin.calculate(2 * Math.PI / 6)).thenReturn(Math.sqrt(3) / 2);
        when(sin.calculate(3 * Math.PI / 8)).thenReturn(Math.sqrt(2 + Math.sqrt(2)) / 2);
        when(sin.calculate(5 * Math.PI / 12)).thenReturn((Math.sqrt(6) + Math.sqrt(2)) / 4);
        when(sin.calculate(0.0)).thenReturn(0.0);
        when(sin.calculate(-Math.PI / 12)).thenReturn((Math.sqrt(2) - Math.sqrt(6)) / 4);
        when(sin.calculate(-Math.PI / 8)).thenReturn(-Math.sqrt(2 - Math.sqrt(2)) / 2);
        when(sin.calculate(-Math.PI / 6)).thenReturn(-0.5);
        when(sin.calculate(-Math.PI / 4)).thenReturn(-Math.sqrt(2) / 2);
        when(sin.calculate(-Math.PI / 2)).thenReturn(-1.0);
        when(sin.calculate(-2 * Math.PI / 6)).thenReturn(-Math.sqrt(3) / 2);
        when(sin.calculate(-3 * Math.PI / 8)).thenReturn(-Math.sqrt(2 + Math.sqrt(2)) / 2);
        when(sin.calculate(-5 * Math.PI / 12)).thenReturn(-(Math.sqrt(6) + Math.sqrt(2)) / 4);
        when(sin.calculate(Double.POSITIVE_INFINITY)).thenReturn(NaN);
        when(sin.calculate(Double.NEGATIVE_INFINITY)).thenReturn(NaN);
        cos = Mockito.mock(Cos.class);
        when(cos.calculate(Math.PI)).thenReturn(-1.0);
        when(cos.calculate(Double.POSITIVE_INFINITY)).thenReturn(NaN);
        when(cos.calculate(Double.NEGATIVE_INFINITY)).thenReturn(NaN);
        when(cos.calculate(Math.PI / 6)).thenReturn(Math.sqrt(3) / 2);
        when(cos.calculate(Math.PI / 4)).thenReturn(Math.sqrt(2) / 2);
        when(cos.calculate(Math.PI / 3)).thenReturn(0.5);
        when(cos.calculate(2 * Math.PI / 3)).thenReturn(-0.49);
        when(cos.calculate(3 * Math.PI / 4)).thenReturn(-Math.sqrt(2) / 2);
        when(cos.calculate(5 * Math.PI / 6)).thenReturn(-Math.sqrt(3) / 2);
        when(cos.calculate(-Math.PI / 6)).thenReturn(Math.sqrt(3) / 2);
        when(cos.calculate(-Math.PI / 4)).thenReturn(Math.sqrt(2) / 2);
        when(cos.calculate(-Math.PI / 3)).thenReturn(0.5);
        when(cos.calculate(-2 * Math.PI / 3)).thenReturn(-0.49);
        when(cos.calculate(-3 * Math.PI / 4)).thenReturn(-Math.sqrt(2) / 2);
        when(cos.calculate(-5 * Math.PI / 6)).thenReturn(-Math.sqrt(3) / 2);
        sec = new Sec(cos);
    }

    private Stream<Arguments> calculate() {
        return Stream.of(
                Arguments.of(0, Double.POSITIVE_INFINITY),
                Arguments.of(Math.PI, -1.0),
                Arguments.of(Double.POSITIVE_INFINITY, NaN),
                Arguments.of(Double.NEGATIVE_INFINITY, NaN),
                Arguments.of(Math.PI / 6, 2 * Math.sqrt(3) / 3),
                Arguments.of(Math.PI / 4, Math.sqrt(2)),
                Arguments.of(Math.PI / 3, 2.0),
                Arguments.of(2 * Math.PI / 3, -2.05),
                Arguments.of(3 * Math.PI / 4, -Math.sqrt(2)),
                Arguments.of(5 * Math.PI / 6, - 2 * Math.sqrt(3) / 3),
                Arguments.of(-Math.PI / 6, 2 * Math.sqrt(3) / 3),
                Arguments.of(-Math.PI / 4, Math.sqrt(2)),
                Arguments.of(-Math.PI / 3, 2.0),
                Arguments.of(-2 * Math.PI / 3, -2.05),
                Arguments.of(-3 * Math.PI / 4, -Math.sqrt(2)),
                Arguments.of(-5 * Math.PI / 6, - 2 * Math.sqrt(3) / 3)
        );
    }

    @ParameterizedTest(name = "{index}: sec({0}) = {1}")
    @MethodSource
    void calculate(double actual, double expected) {
        assertEquals(Math.floor(expected * Math.pow(10, 2)) / Math.pow(10, 2),
                Math.floor(sec.calculate(actual) * Math.pow(10, 2)) / Math.pow(10, 2));
    }
}