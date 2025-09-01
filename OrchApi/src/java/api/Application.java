/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

/**
 *
 * @author grape
 */
public class Application {
    
    
    private int appId; 

    public Application() {
        this.status = Status.PENDING;
    }
    
    private static enum Status{ACCEPTED,REJECTED,CANCELLED,PENDING} ;
    private Status status;
    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }
    private String userId;
    private int roomId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String value) {
        this.userId = value;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int value) {
        this.roomId = value;
    }
    
    
    
    
}
