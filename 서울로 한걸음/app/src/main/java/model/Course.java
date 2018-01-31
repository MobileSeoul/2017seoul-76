package model;

import java.io.Serializable;
import java.util.Vector;

/**
 * Created by dlekd on 2017-10-08.
 */

public class Course implements Serializable {
    private int c_id;
    private String c_name,c_path,png;
    private Vector<String> heritage = new Vector<String>();
    private String TDT;

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    private String add;
    private String c_detail_png;
    private String c_map_png;

    public void setC_map_png(String c_map_png) {
        this.c_map_png = c_map_png;
    }
    public String getC_map_png() {
        return c_map_png;
    }


    public Course() {
    }


    public String getTDT() {
        return TDT;
    }

    public void setTDT(String TDT) {
        this.TDT = TDT;
    }

    public String getC_detail_png() {
        return c_detail_png;
    }

    public void setC_detail_png(String c_detail_png) {
        this.c_detail_png = c_detail_png;
    }






    public String getHeritage(int index) {
        return heritage.get(index);
    }

    public void setHeritage(String heritage_name) {
        heritage.add(heritage_name);
    }

    public String getPng() {
        return png;
    }

    public void setPng(String png) {
        this.png = png;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_path() {
        return c_path;
    }

    public void setC_path(String c_path) {
        this.c_path = c_path;
    }
}
