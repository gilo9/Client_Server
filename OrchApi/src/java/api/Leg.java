/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

/**
 *
 * @author grape
 */
public class Leg {
    private Object[] steps;
    private String summary;
    private double weight;
    private double duration;
    private double distance;

    public Object[] getSteps() { return steps; }
    public void setSteps(Object[] value) { this.steps = value; }

    public String getSummary() { return summary; }
    public void setSummary(String value) { this.summary = value; }

    public double getWeight() { return weight; }
    public void setWeight(double value) { this.weight = value; }

    public double getDuration() { return duration; }
    public void setDuration(double value) { this.duration = value; }

    public double getDistance() { return distance; }
    public void setDistance(double value) { this.distance = value; }
}