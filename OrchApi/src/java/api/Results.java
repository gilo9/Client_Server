/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

/**
 *
 * @author grape
 */

public class Results {
    private Components components;
    private long confidence;
    private String formatted;
    private Geometry geometry;

    public Components getComponents() { return components; }
    public void setComponents(Components value) { this.components = value; }

    public long getConfidence() { return confidence; }
    public void setConfidence(long value) { this.confidence = value; }

    public String getFormatted() { return formatted; }
    public void setFormatted(String value) { this.formatted = value; }

    public Geometry getGeometry() { return geometry; }
    public void setGeometry(Geometry value) { this.geometry = value; }
}