package model;

import java.io.Serializable;

/**
 * Created by S on 2017-10-21.
 */

public class Cultural implements Serializable {
    private int cul_id;
    private String cul_name;
    private double lat;
    private double lng;
    private String cul_url;
    private String add;
    private String time;
    private String fee;
    private String homepage;
    private String station;
    private String tell;

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public int getCul_id() {
        return cul_id;
    }

    public void setCul_id(int cul_id) {
        this.cul_id = cul_id;
    }

    public String getCul_name() {
        return cul_name;
    }

    public void setCul_name(String cul_name) {
        this.cul_name = cul_name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getCul_url() {
        return cul_url;
    }

    public void setCul_url(String cul_url) {
        this.cul_url = cul_url;
    }
}
