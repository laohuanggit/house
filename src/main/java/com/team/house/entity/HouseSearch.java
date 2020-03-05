package com.team.house.entity;

public class HouseSearch extends PagePrameter{
    private String housename;
    private String houseprice;
    private Integer housestreet;
    private Integer housetype;
    private String housearea;
    private Integer minprice;
    private Integer maxprice;
    private Integer minarea;
    private Integer maxarea;

    public void setmpricearea(){
        String price=this.houseprice;
        if (price !=null&& !price.equals("")){
            String [] prices=price.split("-");
            this.minprice = Integer.valueOf(prices[0]);
            this.maxprice = Integer.valueOf(prices[1]);
        }
        String area=this.housearea;
        if (area !=null && !area.equals("")){
            String [] areas=area.split("-");
            this.maxarea = Integer.valueOf(areas[0]);
            this.maxarea = Integer.valueOf(areas[1]);
        }
    }

    public String getHousearea() {
        return housearea;
    }

    public void setHousearea(String housearea) {
        this.housearea = housearea;
    }

    public Integer getMinprice() {
        return minprice;
    }

    public void setMinprice(Integer minprice) {
        this.minprice = minprice;
    }

    public Integer getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(Integer maxprice) {
        this.maxprice = maxprice;
    }

    public Integer getMinarea() {
        return minarea;
    }

    public void setMinarea(Integer minarea) {
        this.minarea = minarea;
    }

    public Integer getMaxarea() {
        return maxarea;
    }

    public void setMaxarea(Integer maxarea) {
        this.maxarea = maxarea;
    }

    public String getHousename() {
        return housename;
    }

    public void setHousename(String housename) {
        this.housename = housename;
    }

    public String getHouseprice() {
        return houseprice;
    }

    public void setHouseprice(String houseprice) {
        this.houseprice = houseprice;
    }

    public Integer getHousestreet() {
        return housestreet;
    }

    public void setHousestreet(Integer housestreet) {
        this.housestreet = housestreet;
    }

    public Integer getHousetype() {
        return housetype;
    }

    public void setHousetype(Integer housetype) {
        this.housetype = housetype;
    }

}
