package ru.netology.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'From zero station'; 0; 1",
                    "'Go last station'; 8; 9",
                    "'More maximum station'; 9; 0"
            }
            , delimiter = ';'
    )
    void pressNextStationTest(String name, int start, int expected) {
        Radio radio=new Radio();
        radio.setCurrentStation(start);

        radio.pressNextStation();
        assertEquals(expected, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'From middle station'; 5; 4",
                    "'Go first station'; 1; 0",
                    "'Less minimum station'; 0; 9"
            }
            , delimiter = ';'
    )
    void pressPrevStationTest(String name, int start, int expected) {
        Radio radio=new Radio();
        radio.setCurrentStation(start);

        radio.pressPrevStation();
        assertEquals(expected, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'Zero volume'; 0; 1",
                    "'Go max volume'; 9; 10",
                    "'More maximum volume'; 10; 10"
            }
            , delimiter = ';'
    )
    void pressPlusVolumeTest(String name, int start, int expected) {
        Radio radio=new Radio();
        radio.setCurrentVolume(start);

        radio.pressPlusVolume();
        assertEquals(expected, radio.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'Middle volume'; 5; 4",
                    "'Go min volume'; 1; 0",
                    "'Less minimum volume'; 0; 0"
            }
            , delimiter = ';'
    )
    void pressMinusVolumeTest(String name, int start, int expected) {
        Radio radio=new Radio();
        radio.setCurrentVolume(start);

        radio.pressMinusVolume();
        assertEquals(expected, radio.getCurrentVolume());
    }
}