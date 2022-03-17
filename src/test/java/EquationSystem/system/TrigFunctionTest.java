package EquationSystem.system;

import EquationSystem.trigFunctions.Sec;
import org.junit.jupiter.api.BeforeEach;
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
class TrigFunctionTest {
    private Sec sec;
    private TrigFunction trigFunction;

    @BeforeEach
    void setUp() {
        sec = Mockito.mock(Sec.class);
        when(sec.calculate(Double.POSITIVE_INFINITY)).thenReturn(NaN);
        when(sec.calculate(Double.NEGATIVE_INFINITY)).thenReturn(NaN);
        when(sec.calculate(Math.PI / 6)).thenReturn(2 * Math.sqrt(3) / 3);
        when(sec.calculate(Math.PI / 4)).thenReturn(Math.sqrt(2));
        when(sec.calculate(Math.PI / 3)).thenReturn(2.0);
        when(sec.calculate(Math.PI)).thenReturn(-1.0);
        when(sec.calculate(0)).thenReturn(Double.POSITIVE_INFINITY);
        when(sec.calculate(2 * Math.PI / 3)).thenReturn(-2.05);
        when(sec.calculate(3 * Math.PI / 4)).thenReturn(-Math.sqrt(2));
        when(sec.calculate(5 * Math.PI / 6)).thenReturn(- 2 * Math.sqrt(3) / 3);
        when(sec.calculate(-Math.PI / 6)).thenReturn(2 * Math.sqrt(3) / 3);
        when(sec.calculate(-Math.PI / 4)).thenReturn(Math.sqrt(2));
        when(sec.calculate(-Math.PI / 3)).thenReturn(2.0);
        when(sec.calculate(-2 * Math.PI / 3)).thenReturn(-2.05);
        when(sec.calculate(-3 * Math.PI / 4)).thenReturn(-Math.sqrt(2));
        when(sec.calculate(-5 * Math.PI / 6)).thenReturn(- 2 * Math.sqrt(3) / 3);
        trigFunction = new TrigFunction(sec);
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
            Math.floor(trigFunction.calculate(actual) * Math.pow(10, 2)) / Math.pow(10, 2));
    }
}