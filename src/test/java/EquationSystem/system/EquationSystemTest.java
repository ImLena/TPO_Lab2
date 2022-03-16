package EquationSystem.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
class EquationSystemTest {
    private TrigFunction trigFunction;
    private LogFunction logFunction;
    private EquationSystem equationSystem;

    @BeforeEach
    void setUp() {
        trigFunction = Mockito.mock(TrigFunction.class);
        when(trigFunction.calculate(Double.POSITIVE_INFINITY)).thenReturn(NaN);
        when(trigFunction.calculate(Double.NEGATIVE_INFINITY)).thenReturn(NaN);
        when(trigFunction.calculate(-Math.PI / 6)).thenReturn(2 * Math.sqrt(3) / 3);
        when(trigFunction.calculate(-Math.PI / 4)).thenReturn(Math.sqrt(2));
        when(trigFunction.calculate(-Math.PI / 3)).thenReturn(2.0);
        when(trigFunction.calculate(-2 * Math.PI / 3)).thenReturn(-2.05);
        when(trigFunction.calculate(-3 * Math.PI / 4)).thenReturn(-Math.sqrt(2));
        when(trigFunction.calculate(-5 * Math.PI / 6)).thenReturn(-2 * Math.sqrt(3) / 3);
        when(trigFunction.calculate(0.0)).thenReturn(Double.POSITIVE_INFINITY);
        logFunction = Mockito.mock(LogFunction.class);
        when(logFunction.calculate(0.125)).thenReturn(3.064);
        when(logFunction.calculate(0.5)).thenReturn(0.053);
        when(logFunction.calculate(2.0)).thenReturn(0.915);
        when(logFunction.calculate(10.0)).thenReturn(6.778);
        equationSystem = new EquationSystem(logFunction, trigFunction);
    }

    private Stream<Arguments> calculatePositive() {
        return Stream.of(
                Arguments.of(0.125, 3.064),
                Arguments.of(0.5, 0.053),
                Arguments.of(2.0, 0.915),
                Arguments.of(10.0, 6.778)
        );
    }

    @ParameterizedTest(name = "{0}: {1}")
    @MethodSource
    @DisplayName("x > 0")
    public void calculatePositive(double x, double expected) {
        assertEquals(Math.ceil(expected * Math.pow(10, 3)) / Math.pow(10, 3),
                Math.ceil(equationSystem.calculate(x) * Math.pow(10, 3)) / Math.pow(10, 3));
    }

    private Stream<Arguments> calculateNegative() {
        return Stream.of(
                Arguments.of(0, Double.POSITIVE_INFINITY),
                Arguments.of(Double.NEGATIVE_INFINITY, NaN),
                Arguments.of(-Math.PI / 6, 2 * Math.sqrt(3) / 3),
                Arguments.of(-Math.PI / 4, Math.sqrt(2)),
                Arguments.of(-Math.PI / 3, 2.0),
                Arguments.of(-2 * Math.PI / 3, -2.05),
                Arguments.of(-3 * Math.PI / 4, -Math.sqrt(2)),
                Arguments.of(-5 * Math.PI / 6, -2 * Math.sqrt(3) / 3)
        );
    }

    @ParameterizedTest(name = "{0}: {1}")
    @MethodSource
    @DisplayName("x <= 0")
    public void calculateNegative(double x, double expected) {
        assertEquals(Math.ceil(expected * Math.pow(10, 3)) / Math.pow(10, 3),
                Math.ceil(equationSystem.calculate(x) * Math.pow(10, 3)) / Math.pow(10, 3));
    }
}