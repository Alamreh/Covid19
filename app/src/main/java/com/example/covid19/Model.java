package com.example.covid19;

public class Model {
    private String cityname,total,death,cured,active,inActive,inDEc,inRec;

    public Model(String cityname, String total, String death, String cured, String active,String inActive,String inDEc,String inRec) {
        this.cityname = cityname;
        this.total = total;
        this.death = death;
        this.cured = cured;
        this.active = active;
       this.inActive = inActive;
        this.inDEc = inDEc;
        this.inRec = inRec;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public String getCured() {
        return cured;
    }

    public void setCured(String cured) {
        this.cured = cured;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getInActive() {
        return inActive;
    }

    public void setInActive(String inActive) {
        this.inActive = inActive;
    }

    public String getInDEc() {
        return inDEc;
    }

    public void setInDEc(String inDEc) {
        this.inDEc = inDEc;
    }

    public String getInRec() {
        return inRec;
    }

    public void setInRec(String inRec) {
        this.inRec = inRec;
    }
}
