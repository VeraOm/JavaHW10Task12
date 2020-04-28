package ru.netology.domain;

public class Radio {
    private int currentStation;
    private int currentVolume;

    private final int maxStation=9;
    private final int minStation=0;
    private final int maxVolume=10;
    private final int minVolume=0;

    public int getCurrentStation() {
        return currentStation;
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

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        if(currentVolume>maxVolume){
            return;
        }
        if(currentVolume<minVolume){
            return;
        }
        this.currentVolume = currentVolume;
    }

    public void pressNextStation(){
        if(currentStation>=maxStation){
            setCurrentStation(minStation);
        }else{
            setCurrentStation(currentStation+1);
        }
    }

    public void pressPrevStation(){
        if(currentStation<=minStation){
            setCurrentStation(maxStation);
        }else{
            setCurrentStation(currentStation-1);
        }
    }

    public void pressPlusVolume(){
        setCurrentVolume(currentVolume+1);
    }

    public void pressMinusVolume(){
        setCurrentVolume(currentVolume-1);
    }
}
