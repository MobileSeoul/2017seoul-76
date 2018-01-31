package com.seoullo_one;

/**
 * Created by S on 2017-10-03.
 */

public class List {
    private String costitle;
    private int cosImage;

    public List(String costitle, int cosImage){
        this.costitle = costitle;
        this.cosImage = cosImage;
    }

    public String getCostitle(){
        return costitle;
    }

    public void setCostitle(String costitle){
        this.costitle = costitle;
    }

    public int getCosImage(){
        return cosImage;
    }

    public void setCosImage(int cosImage){
        this.cosImage = cosImage;
    }
}
