package EquationSystem.logFunctions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LnTest {

    private Ln ln;

    @BeforeEach
    void setUp() {
        ln = new Ln();
    }

    private Stream<Arguments> calculate() {
        return Stream.of(
                Arguments.of(0.0, Double.NEGATIVE_INFINITY),
                Arguments.of(0.135, -1.882),
                Arguments.of(0.367, -0.989),
                Arguments.of(1.0, 0.0),
                Arguments.of(1.5, 0.405),
                Arguments.of(2.0, 0.696),
                Arguments.of(3.0, 1.101),
                Arguments.of(15.0, 2.718)
        );
    }

    @ParameterizedTest(name = "{index}: ln({0}) = {1}")
    @MethodSource
    public void calculate(double actual, double expected) {
        assertEquals(Math.ceil(expected* Math.pow(10, 3)) / Math.pow(10, 3),
                Math.ceil(ln.calculate(actual)* Math.pow(10, 3)) / Math.pow(10, 3));
    }
}