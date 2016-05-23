package com.techmorphosis.qube.utils;

// Created by kamlesh on 10/2/16, 3:06 PM

// Base class for creating models.
public class DataModel {
    protected String name;
    protected int id;
    protected boolean isSelected = false;

    public DataModel(String name, int id) {
        this.name = name;
        this.id = id;
        this.isSelected = isSelected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
