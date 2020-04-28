package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Radio {
    private int currentStation;
    private int currentVolume;


    private int maxStation = 10;
    private int minStation = 0;
    private int maxVolume = 100;
    private int minVolume = 0;

    public Radio(int maxStation) {
        this.maxStation = maxStation;
    }

    public void setCurrentStation(int currentStation) {
        if(currentStation>maxStation){
            return;
        }
        if(currentStation<minStation){
            return;
        }
        this.currentStation = currentStation;
    }

    public void pressNextStation() {
        if (currentStation >= maxStation) {
            setCurrentStation(minStation);
        } else {
            setCurrentStation(currentStation + 1);
        }
    }

    public void pressPrevStation() {
        if (currentStation <= minStation) {
            setCurrentStation(maxStation);
        } else {
            setCurrentStation(currentStation - 1);
        }
    }

    public void pressPlusVolume() {
        if (currentVolume >= maxVolume) {
            return;
        }
        setCurrentVolume(currentVolume + 1);
    }

    public void pressMinusVolume() {
        if (currentVolume <= minVolume) {
            return;
        }
        setCurrentVolume(currentVolume - 1);
    }
}
