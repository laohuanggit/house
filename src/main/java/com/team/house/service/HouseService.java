package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.entity.HouseSearch;
import com.team.house.entity.PagePrameter;

import java.util.List;

public interface HouseService {
    public int addHouse(House house);
    public int delHouse(String id);
    public PageInfo getHouseByUser(Integer userid, PagePrameter pagePrameter);
    public PageInfo getHouseBySearch(HouseSearch houseSearch);
}
