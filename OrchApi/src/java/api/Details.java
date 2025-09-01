/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

/**
 *
 * @author grape
 */
public class Details {
    
    private boolean furnished;
    private String[] amenities;
    private boolean liveInLandlord;
    private long sharedWith;
    private boolean billsIncluded;
    private boolean bathroomShared;

    public boolean getFurnished() { return furnished; }
    public void setFurnished(boolean value) { this.furnished = value; }

    public String[] getAmenities() { return amenities; }
    public void setAmenities(String[] value) { this.amenities = value; }

    public boolean getLiveInLandlord() { return liveInLandlord; }
    public void setLiveInLandlord(boolean value) { this.liveInLandlord = value; }

    public long getSharedWith() { return sharedWith; }
    public void setSharedWith(long value) { this.sharedWith = value; }

    public boolean getBillsIncluded() { return billsIncluded; }
    public void setBillsIncluded(boolean value) { this.billsIncluded = value; }

    public boolean getBathroomShared() { return bathroomShared; }
    public void setBathroomShared(boolean value) { this.bathroomShared = value; 
    }
    
    
}
