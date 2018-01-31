package model;

import java.io.Serializable;

/**
 * Created by dlekd on 2017-10-09.
 */

public class SearchCourse implements Serializable {
    private String c_name;
    private String tag;

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
