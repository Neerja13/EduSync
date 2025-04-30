package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class ClassRoom {

    @Id
    @JsonProperty("class_no")
    private String classNo;
    @JsonProperty("seat_row")
    private String seatRow;
    private int singleCapacity;
    private int doubleCapacity;
    private Boolean isOccupied = Boolean.FALSE;



    public ClassRoom(String classNo, String row) {
        this.classNo = classNo;
        this.seatRow = row;

    }

    public ClassRoom() {
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(String row) {
        this.seatRow = row;
    }

    public int getSingleCapacity() {
        return singleCapacity;
    }

    public void setSingleCapacity(int singleCapacity) {
        this.singleCapacity = singleCapacity;
    }

    public int getDoubleCapacity() {
        return doubleCapacity;
    }

    public void setDoubleCapacity(int doubleCapacity) {
        this.doubleCapacity = doubleCapacity;
    }
    public Boolean getIsOccupied(){
        return isOccupied;
    }
    public void setIsOccupied(Boolean val){
        this.isOccupied = val;
    }
}
