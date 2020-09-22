package ru.netology.smart.house;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {

    @Test
    void increaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(5);
        radio.increaseVolume();
        assertEquals(6, radio.getCurrentVolume());
    }

    @Test
    void decreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(5);
        radio.decreaseVolume();
        assertEquals(4, radio.getCurrentVolume());
    }

    @Test
    public void decreaseVolumeFromAboveMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-10);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void increaseVolumeFromOverMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-10);
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    void nextRadioStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(6);
        radio.increaseRadioStation();
        assertEquals(7, radio.getCurrentRadioStation());
    }

    @Test
    void previousRadioStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(6);
        radio.decreaseRadioStation();
        assertEquals(5, radio.getCurrentRadioStation());
    }

    @Test
    public void increaseVolumeStartingFromMaxVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(10);
        radio.increaseVolume();
        assertEquals(10, radio.getCurrentVolume());
    }

    @Test
    public void decreaseVolumeStartingFromMinVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void setStatRadioStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(5);
        assertEquals(5, radio.getCurrentRadioStation());
    }

    @Test
    public void previousRadioStationStartingFromMin() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(0);
        radio.decreaseRadioStation();
        assertEquals(9, radio.getCurrentRadioStation());
    }

    @Test
    public void nextRadioStationStartingFromMax() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(9);
        radio.increaseRadioStation();
        assertEquals(0, radio.getCurrentRadioStation());
    }


    @Test
    //допустим что с пульта можно вводить многозначные номера каналов
    public void nextRadioStationFromOverMax() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(31);
        radio.increaseRadioStation();
        assertEquals(0, radio.getCurrentRadioStation());
    }

    @Test
    //допустим что с пульта можно вводить многозначные номера каналов
    public void previousRadioStationFromOverMax() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(32);
        radio.decreaseRadioStation();
        assertEquals(8, radio.getCurrentRadioStation());
    }


    @Test
    //допустим что с пульта можно вводить многозначные номера каналов, в том числе и отрицательные
    public void setDesiredRadioStationFromAnyMinus() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(-15);
        assertEquals(0, radio.getCurrentRadioStation());
    }

}
