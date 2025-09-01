/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

/**
 *
 * @author grape
 */
class DataSeries {
    private int date;
    private String weather;
    private Temp2m temp2m;
    
    private int wind10mMax;

    // Getters and setters
    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Temp2m getTemp2m() {
        return temp2m;
    }

    public void setTemp2m(Temp2m temp2m) {
        this.temp2m = temp2m;
    }

    public int getWind10mMax() {
        return wind10mMax;
    }

    public void setWind10mMax(int wind10mMax) {
        this.wind10mMax = wind10mMax;
    }
}