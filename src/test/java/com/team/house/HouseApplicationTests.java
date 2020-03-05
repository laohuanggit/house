package com.team.house;

import com.team.house.entity.District;
import com.team.house.entity.DistrictExample;
import com.team.house.mapper.DistrictMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseApplicationTests {
@Autowired(required = false)
private DistrictMapper districtMapper;
    @Test
    public void contextLoads() {
        List<District>list=districtMapper.selectByExample(new DistrictExample());
        System.out.println(list.size());
    }

}
