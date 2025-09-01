/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

/**
 *
 * @author grape
 */
import java.time.LocalDate;

public class Room {
    private long id;
    private String name;
    private Location location;
    private Details details;
    private long pricePerMonthGbp;
    private String availabilityDate;
    private String[] spokenLanguages;

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public Location getLocation() { return location; }
    public void setLocation(Location value) { this.location = value; }

    public Details getDetails() { return details; }
    public void setDetails(Details value) { this.details = value; }

    public long getPricePerMonthGbp() { return pricePerMonthGbp; }
    public void setPricePerMonthGbp(long value) { this.pricePerMonthGbp = value; }

    public String getAvailabilityDate() { return availabilityDate; }
    public void setAvailabilityDate(String value) { this.availabilityDate = value; }

    public String[] getSpokenLanguages() { return spokenLanguages; }
    public void setSpokenLanguages(String[] value) { this.spokenLanguages = value; }
    
}
