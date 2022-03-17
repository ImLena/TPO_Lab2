package EquationSystem.logFunctions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LogTest {
    private Ln ln;
    private Log log2;
    private Log log3;
    private Log log5;
    private Log log10;

    @BeforeEach
    void setUp() {
        ln = Mockito.mock(Ln.class);
        when(ln.calculate(0.0)).thenReturn(Double.NEGATIVE_INFINITY);
        when(ln.calculate(0.125)).thenReturn(-2.07944);
        when(ln.calculate(0.5)).thenReturn( -0.693147);
        when(ln.calculate(1.0)).thenReturn(0.0);
        when(ln.calculate(1.5)).thenReturn(0.405);
        when(ln.calculate(2.0)).thenReturn(0.693);
        when(ln.calculate(3.0)).thenReturn(1.09861);
        when(ln.calculate(4.0)).thenReturn(1.386);
        when(ln.calculate(5.0)).thenReturn(1.60944);
        when(ln.calculate(25.0)).thenReturn(3.21888);
        when(ln.calculate(9.0)).thenReturn(2.19722);
        when(ln.calculate(10.0)).thenReturn(2.303);
        when(ln.calculate(100.0)).thenReturn(4.60517);

        log2 = new Log(ln, 2);
        log3 = new Log(ln, 3);
        log5 = new Log(ln, 5);
        log10 = new Log(ln, 10);
    }

    private Stream<Arguments> calculateLog2() {
        return Stream.of(
                Arguments.of(0.0, Double.NEGATIVE_INFINITY),
                Arguments.of(0.125, -3.0),
                Arguments.of(0.5, -1),
                Arguments.of(1.0, 0.0),
                Arguments.of(2.0, 1.0),
                Arguments.of(4.0, 2.0)
        );
    }

    @ParameterizedTest(name = "{index}: log({0}) base(2) = {1}")
    @MethodSource
    public void calculateLog2(double x, double expected){
        assertEquals(Math.ceil(expected* Math.pow(10, 3)) / Math.pow(10, 3),
                Math.ceil(log2.calculate(x)* Math.pow(10, 3)) / Math.pow(10, 3));
    }
    private Stream<Arguments> calculateLog3() {
        return Stream.of(
                Arguments.of(0.0, Double.NEGATIVE_INFINITY),
                Arguments.of(0.125, -1.89279),
                Arguments.of(0.5, -0.63093),
                Arguments.of(1.0, 0.0),
                Arguments.of(3.0, 1.0),
                Arguments.of(9.0, 2.0)
        );
    }

    @ParameterizedTest(name = "{index}: log({0}) base(3) = {1}")
    @MethodSource
    public void calculateLog3(double x, double expected){
        assertEquals(Math.ceil(expected* Math.pow(10, 3)) / Math.pow(10, 3),
                Math.ceil(log3.calculate(x)* Math.pow(10, 3)) / Math.pow(10, 3));
    }

    private Stream<Arguments> calculateLog5() {
        return Stream.of(
                Arguments.of(0.0, Double.NEGATIVE_INFINITY),
                Arguments.of(0.125, -1.29203),
                Arguments.of(0.5, -0.430677),
                Arguments.of(1.0, 0.0),
                Arguments.of(5.0, 1.0),
                Arguments.of(25.0, 2.0)
        );
    }

    @ParameterizedTest(name = "{index}: log({0}) base(5) = {1}")
    @MethodSource
    public void calculateLog5(double x, double expected){
        assertEquals(Math.ceil(expected* Math.pow(10, 3)) / Math.pow(10, 3),
                Math.ceil(log5.calculate(x)* Math.pow(10, 3)) / Math.pow(10, 3));
    }

    private Stream<Arguments> calculateLog10() {
        return Stream.of(
                Arguments.of(0.0, Double.NEGATIVE_INFINITY),
                Arguments.of(0.125, -0.902),
                Arguments.of(0.5, -0.3),
                Arguments.of(1.0, 0.0),
                Arguments.of(10.0, 1.0),
                Arguments.of(100.0, 2.0)
        );
    }

    @ParameterizedTest(name = "{index}: lg({0}) = {1}")
    @MethodSource
    public void calculateLog10(double x, double expected){
        assertEquals(Math.ceil(expected* Math.pow(10, 3)) / Math.pow(10, 3),
                Math.ceil(log10.calculate(x)* Math.pow(10, 3)) / Math.pow(10, 3));
    }
}