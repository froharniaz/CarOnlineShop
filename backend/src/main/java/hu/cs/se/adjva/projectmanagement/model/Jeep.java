package hu.cs.se.adjva.projectmanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "jeeps")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Jeep {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer _id;
    private String carname;
    private String engine;
    private Integer modelYear;
    private Integer kilometer;
    private Double price;

    public Jeep() {
    }

    public Jeep(Integer _id, String carname, String engine, Integer modelYear, Integer kilometer, Double price) {
        this._id = _id;
        this.carname = carname;
        this.engine = engine;
        this.modelYear = modelYear;
        this.kilometer = kilometer;
        this.price = price;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Integer getModelYear() {
        return modelYear;
    }

    public void setModelYear(Integer modelYear) {
        this.modelYear = modelYear;
    }

    public Integer getKilometer() {
        return kilometer;
    }

    public void setKilometer(Integer kilometer) {
        this.kilometer = kilometer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
