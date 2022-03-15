package EquationSystem.trigFunctions;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SinTest {

    private Sin sin;

    @BeforeEach
    void setUp() {
        sin = new Sin();
    }

    private Stream<Arguments> calculate() {
        return Stream.of(
                Arguments.of(0, 0.0),
                Arguments.of(Math.PI, 0.0),
                Arguments.of(Double.POSITIVE_INFINITY, NaN),
                Arguments.of(Double.NEGATIVE_INFINITY, NaN),
                Arguments.of(7 * Math.PI / 6, -0.5),
                Arguments.of(-7 * Math.PI / 6, 0.5),
                //right
                Arguments.of(Math.PI / 6, 0.5),
                Arguments.of(Math.PI / 4, Math.sqrt(2) / 2),
                Arguments.of(Math.PI / 3, Math.sqrt(3) / 2),
                Arguments.of(Math.PI / 2, 1.0),
                Arguments.of(2 * Math.PI / 3, Math.sqrt(3) / 2),
                Arguments.of(3 * Math.PI / 4, Math.sqrt(2) / 2),
                Arguments.of(5 * Math.PI / 6, 0.5),
                //left
                Arguments.of(-Math.PI / 6, -0.5),
                Arguments.of(-Math.PI / 4, -Math.sqrt(2) / 2),
                Arguments.of(-Math.PI / 3, -Math.sqrt(3) / 2),
                Arguments.of(-Math.PI / 2, -1.0),
                Arguments.of(-2 * Math.PI / 3, -Math.sqrt(3) / 2),
                Arguments.of(-3 * Math.PI / 4, -Math.sqrt(2) / 2),
                Arguments.of(-5 * Math.PI / 6, -0.5)
        );
    }

    @ParameterizedTest(name = "{index}: sin({0}) = {1}")
    @MethodSource
    public void calculate(double actual, double expected) {
        assertEquals(expected, sin.calculate(actual), sin.getAccuracy());
    }
}