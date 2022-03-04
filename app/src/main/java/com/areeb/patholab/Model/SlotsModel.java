package com.areeb.patholab.Model;

public class SlotsModel {
    String LabName;
    String LabEmail;

    public String getLabName() {
        return LabName;
    }

    public void setLabName(String labName) {
        LabName = labName;
    }

    public String getLabEmail() {
        return LabEmail;
    }

    public void setLabEmail(String labEmail) {
        LabEmail = labEmail;
    }

    public SlotsModel(String labName, String labEmail) {
        LabName = labName;
        LabEmail = labEmail;
    }
    public SlotsModel(){}
}
