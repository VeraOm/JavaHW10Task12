package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void setMaxStationTest(){
        int expected=14;
        Radio radio=new Radio(expected);

        assertEquals(expected, radio.getMaxStation());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'From first station'; 5; 0; 0",
                    "'Last station'; 14; 14; 14",
                    "'More maximum station'; 5; 7; 0",
                    "'Less minimum station'; 5; -1; 0"
            }
            , delimiter = ';'
    )
    void setStationNumberTest(String name, int max, int start, int expected) {
        Radio radio=new Radio(max);
        radio.setCurrentStation(start);

        assertEquals(expected, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'From first station'; 5; 0; 1",
                    "'Go last station'; 5; 4; 5",
                    "'More maximum station'; 5; 5; 0"
            }
            , delimiter = ';'
    )
    void pressNextStationTest(String name, int max, int start, int expected) {
        Radio radio=new Radio(max);
        radio.setCurrentStation(start);

        radio.pressNextStation();
        assertEquals(expected, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'From last station'; 5; 5; 4",
                    "'Go first station'; 5; 1; 0",
                    "'Less minimum station'; 5; 0; 5"
            }
            , delimiter = ';'
    )
    void pressPrevStationTest(String name, int max, int start, int expected) {
        Radio radio=new Radio(max);
        radio.setCurrentStation(start);

        radio.pressPrevStation();
        assertEquals(expected, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'Zero volume'; 0; 1",
                    "'Go max volume'; 99; 100",
                    "'More maximum volume'; 100; 100"
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
                    "'Max volume'; 100; 99",
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