package com.spotico.DTO;

import com.spotico.pojos.SportType;

public class SportDTO {
    private String name; 
    private SportType type; 

    public SportDTO() {
    }

    public String getName() { 
        return name;
    }

    public void setName(String name) { 
        this.name = name;
    }

    public SportType getType() {
        return type;
    }

    public void setType(SportType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SportDTO [name=" + name + ", type=" + type + "]";
    }
}
