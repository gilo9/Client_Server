/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

/**
 *
 * @author grape
 */
import java.util.List;

// Main class
public class WeatherData {
    private String product;
    private String init;
    private List<DataSeries> dataseries;

    // Getters and setters
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getInit() {
        return init;
    }

    public void setInit(String init) {
        this.init = init;
    }

    public List<DataSeries> getDataseries() {
        return dataseries;
    }

    public void setDataseries(List<DataSeries> dataseries) {
        this.dataseries = dataseries;
    }
}





