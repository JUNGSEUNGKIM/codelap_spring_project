package org.codelap_spring_project.domain;

public class Festival {



    private Long festivalid;
    private String festivalname;
    private String location;
    private String startdate;
    private String enddate;
    private String description;
    private String website;
    private String radaddress;
    private String jibunaddress;
    private Long latitude;
    private Long longitude;

    public Festival() {
    }

    public Festival(Long festivalid, String festivalname, String location, String startdate, String enddate, String description, String website, String radaddress, String jibunaddress, Long latitude, Long longitude) {
        this.festivalid = festivalid;
        this.festivalname = festivalname;
        this.location = location;
        this.startdate = startdate;
        this.enddate = enddate;
        this.description = description;
        this.website = website;
        this.radaddress = radaddress;
        this.jibunaddress = jibunaddress;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public void setFestivalid(Long festivalid) {
        this.festivalid = festivalid;
    }

    public void setFestivalname(String festivalname) {
        this.festivalname = festivalname;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setRadaddress(String radaddress) {
        this.radaddress = radaddress;
    }

    public void setJibunaddress(String jibunaddress) {
        this.jibunaddress = jibunaddress;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }



    public Long getFestivalid() {
        return festivalid;
    }

    public String getFestivalname() {
        return festivalname;
    }

    public String getLocation() {
        return location;
    }

    public String getStartdate() {
        return startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public String getDescription() {
        return description;
    }

    public String getWebsite() {
        return website;
    }

    public String getRadaddress() {
        return radaddress;
    }

    public String getJibunaddress() {
        return jibunaddress;
    }

    public Long getLatitude() {
        return latitude;
    }

    public Long getLongitude() {
        return longitude;
    }







}
