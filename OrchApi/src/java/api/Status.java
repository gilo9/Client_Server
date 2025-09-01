/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

/**
 *
 * @author grape
 */
public class Status {
    private long code;
    private String message;

    public long getCode() { return code; }
    public void setCode(long value) { this.code = value; }

    public String getMessage() { return message; }
    public void setMessage(String value) { this.message = value; }
}