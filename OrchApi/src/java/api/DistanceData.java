/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

/**
 *
 * @author grape
 */
public class DistanceData {
    
    private String code;
    private Route[] routes;
    private Waypoint[] waypoints;

    public String getCode() { return code; }
    public void setCode(String value) { this.code = value; }

    public Route[] getRoutes() { return routes; }
    public void setRoutes(Route[] value) { this.routes = value; }

    public Waypoint[] getWaypoints() { return waypoints; }
    public void setWaypoints(Waypoint[] value) { this.waypoints = value; }

}
