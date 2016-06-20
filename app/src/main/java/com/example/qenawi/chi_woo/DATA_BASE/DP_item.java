package com.example.qenawi.chi_woo.DATA_BASE;

import java.io.Serializable;

/**
 * Created by QEnawi on 6/7/2016.
 */
public class DP_item implements Serializable {
    public String Type,color,descreption;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
