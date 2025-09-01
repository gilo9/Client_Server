/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

/**
 *
 * @author grape
 */
public class Rate {
    private long limit;
    private long remaining;
    private long reset;

    public long getLimit() { return limit; }
    public void setLimit(long value) { this.limit = value; }

    public long getRemaining() { return remaining; }
    public void setRemaining(long value) { this.remaining = value; }

    public long getReset() { return reset; }
    public void setReset(long value) { this.reset = value; }
}