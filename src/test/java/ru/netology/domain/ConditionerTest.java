package ru.netology.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ConditionerTest {
    @ParameterizedTest
    @CsvSource(
            value = {
                    "'Zero temperature'; 5; -5; 0; 1",
                    "'Last temperature'; 5; -5; 4; 5",
                    "'Max temperature'; 5; -5; 5; 5",
                    "'More maximum temperature'; 5; -5; 6; 1"
            }
            , delimiter = ';'
    )
    public void increaseCurrentTemperatureTest(String name, int max, int min, int start, int expected) {
        Conditioner conditioner = new Conditioner();
        conditioner.setCurrentTemperature(0);
        conditioner.setName(name);
        conditioner.setMaxTemperature(max);
        conditioner.setMinTemperature(min);
        conditioner.setCurrentTemperature(start);

        conditioner.increaseCurrentTemperature();
        assertEquals(expected, conditioner.getCurrentTemperature());

    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'Zero temperature'; 5; -5; 0; -1",
                    "'Last temperature'; 5; -5; -4; -5",
                    "'Min temperature'; 5; -5; -5; -5",
                    "'Less minimum temperature'; 5; -5; -100; -1"
            }
            , delimiter = ';'
    )
    public void decreaseCurrentTemperatureTest(String name, int max, int min, int start, int expected) {
        Conditioner conditioner = new Conditioner();
        conditioner.setCurrentTemperature(0);
        conditioner.setName(name);
        conditioner.setMaxTemperature(max);
        conditioner.setMinTemperature(min);
        conditioner.setCurrentTemperature(start);

        conditioner.decreaseCurrentTemperature();
        assertEquals(expected, conditioner.getCurrentTemperature());

    }
}