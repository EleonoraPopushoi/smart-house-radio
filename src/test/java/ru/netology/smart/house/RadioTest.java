package ru.netology.smart.house;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {

    Radio radio = new Radio();

    @Test
    void increaseVolume() {

        radio.setCurrentVolume(56);
        radio.increaseVolume();
        assertEquals(57, radio.getCurrentVolume());
    }

    @Test
    void decreaseVolume() {

        radio.setCurrentVolume(55);
        radio.decreaseVolume();
        assertEquals(54, radio.getCurrentVolume());
    }

    @Test
    public void decreaseVolumeFromAboveMin() {

        radio.setCurrentVolume(-10);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void increaseVolumeFromOverMin() {

        radio.setCurrentVolume(-10);
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    public void increaseVolumeStartingFromMaxVolume() {

        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void decreaseVolumeStartingFromMinVolume() {

        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void nextRadioStation() {

        radio.setCurrentRadioStation(6);
        radio.increaseRadioStation();
        assertEquals(7, radio.getCurrentRadioStation());
    }

    @Test
    void previousRadioStation() {

        radio.setCurrentRadioStation(6);
        radio.decreaseRadioStation();
        assertEquals(5, radio.getCurrentRadioStation());
    }


    @Test
    public void setStatRadioStation() {

        radio.setCurrentRadioStation(6);
        assertEquals(6, radio.getCurrentRadioStation());
    }

    @Test
    public void previousRadioStationStartingFromMin() {

        radio.setCurrentRadioStation(0);
        radio.decreaseRadioStation();
        assertEquals(10, radio.getCurrentRadioStation());
    }

    @Test
    public void nextRadioStationStartingFromMax() {

        radio.setCurrentRadioStation(10);
        radio.increaseRadioStation();
        assertEquals(0, radio.getCurrentRadioStation());
    }


    @Test
    //допустим что с пульта можно вводить многозначные номера каналов
    public void nextRadioStationFromOverMax() {

        radio.setCurrentRadioStation(11);
        radio.increaseRadioStation();
        assertEquals(0, radio.getCurrentRadioStation());
    }

    @Test
    //допустим что с пульта можно вводить многозначные номера каналов
    public void previousRadioStationFromOverMax() {

        radio.setCurrentRadioStation(13);
        radio.decreaseRadioStation();
        assertEquals(9, radio.getCurrentRadioStation());
    }


    @Test
    //допустим что с пульта можно вводить многозначные номера каналов, в том числе и отрицательные
    public void setDesiredRadioStationFromAnyMinus() {

        radio.setCurrentRadioStation(-15);
        assertEquals(0, radio.getCurrentRadioStation());
    }

}
