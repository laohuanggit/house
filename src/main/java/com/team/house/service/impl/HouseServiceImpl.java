package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.entity.HouseExample;
import com.team.house.entity.HouseSearch;
import com.team.house.entity.PagePrameter;
import com.team.house.mapper.HouseMapper;
import com.team.house.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired(required = false)
    private HouseMapper houseMapper;

    @Override
    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    @Override
    public int delHouse(String id) {
        return houseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo getHouseByUser(Integer userid, PagePrameter pagePrameter) {
       PageHelper.startPage(pagePrameter.getPage(),pagePrameter.getPageSize());
       List<House>list=houseMapper.selectByUser(userid);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public PageInfo getHouseBySearch(HouseSearch houseSearch) {
        PageHelper.startPage(houseSearch.getPage(),houseSearch.getPageSize());
        List<House> list=houseMapper.selectBySearch(houseSearch);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

}
