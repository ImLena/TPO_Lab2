package EquationSystem.system;

import EquationSystem.logFunctions.Ln;
import EquationSystem.logFunctions.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LogFunctionTest {
    private Ln ln;
    private Log log2;
    private Log log3;
    private Log log5;
    private Log log10;
    private LogFunction logFunction;

    @BeforeEach
    void setUp() {
        ln = Mockito.mock(Ln.class);
        when(ln.calculate(0.0)).thenReturn(Double.NEGATIVE_INFINITY);
        when(ln.calculate(0.125)).thenReturn(-2.07944);
        when(ln.calculate(0.5)).thenReturn( -0.693147);
        when(ln.calculate(2.0)).thenReturn(0.693);
        when(ln.calculate(4.0)).thenReturn(1.386);
        when(ln.calculate(10.0)).thenReturn(2.303);
        log2 = Mockito.mock(Log.class);
        log3 = Mockito.mock(Log.class);
        log5 = Mockito.mock(Log.class);
        log10 = Mockito.mock(Log.class);
        when(log2.calculate(0.0)).thenReturn(Double.NEGATIVE_INFINITY);
        when(log3.calculate(0.0)).thenReturn(Double.NEGATIVE_INFINITY);
        when(log5.calculate(0.0)).thenReturn(Double.NEGATIVE_INFINITY);
        when(log10.calculate(0.0)).thenReturn(Double.NEGATIVE_INFINITY);
        when(log2.calculate(0.125)).thenReturn(-3.0);
        when(log2.calculate(0.5)).thenReturn( -1.0);
        when(log2.calculate(1.0)).thenReturn(0.0);
        when(log2.calculate(2.0)).thenReturn(1.0);
        when(log2.calculate( 10.0)).thenReturn(3.322);
        when(log3.calculate( 0.125)).thenReturn(-1.89279);
        when(log3.calculate(0.5)).thenReturn(-0.63093);
        when(log3.calculate(1.0)).thenReturn(0.0);
        when(log3.calculate(2.0)).thenReturn(0.631);
        when(log3.calculate(10.0)).thenReturn(2.096);
        when(log5.calculate(0.125)).thenReturn(-1.29203);
        when(log5.calculate(0.5)).thenReturn(-0.430677);
        when(log5.calculate(1.0)).thenReturn(0.0);
        when(log5.calculate(2.0)).thenReturn(0.431);
        when(log5.calculate(10.0)).thenReturn(1.431);
        when(log10.calculate(0.125)).thenReturn(-0.902);
        when(log10.calculate(0.5)).thenReturn(-0.3);
        when(log10.calculate(1.0)).thenReturn(0.0);
        when(log10.calculate(2.0)).thenReturn(0.301);
        when(log10.calculate(10.0)).thenReturn(1.0);
        when(log10.calculate(100.0)).thenReturn(2.0);
        logFunction = new LogFunction(ln, log2, log3, log5, log10);

    }
    private Stream<Arguments> calculate() {
        return Stream.of(
                Arguments.of(0.0, Double.NaN),
                Arguments.of(0.125, 3.064),
                Arguments.of(0.5, 0.053),
                Arguments.of(2.0, 0.915),
                Arguments.of(10.0, 6.778)
        );
    }

    @ParameterizedTest(name = "{0}: {1}")
    @MethodSource
    @DisplayName("(((((ln(x) * log_2(x)) / log_5(x)) * log_10(x)) / (log_3(x) / log_3(x))) + log_5(x))")
    public void calculate(double x, double expected){
        assertEquals(Math.ceil(expected* Math.pow(10, 3)) / Math.pow(10, 3),
                Math.ceil(logFunction.calculate(x)* Math.pow(10, 3)) / Math.pow(10, 3));
    }

    @ParameterizedTest
    @ValueSource(doubles = {1})
    public void calculateZeroDiv(double x){
        assertThrows(IllegalArgumentException.class, () -> logFunction.calculate(x));
    }
}