package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.entity.HouseSearch;
import com.team.house.entity.PagePrameter;
import com.team.house.entity.Users;
import com.team.house.service.HouseService;
import com.team.house.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;

@RestController
@CrossOrigin(value = "*",allowCredentials = "true")
public class HouseController {
    @Autowired
    HouseService houseService;

    @RequestMapping("addHouse")
    public String addHouse(House house, HttpSession session,
                           @RequestParam( value = "pfile",required = false) MultipartFile multipartFile){
        try {
            String path="D:\\U4workspace\\image";
            String filename= FileUploadUtil.upload(multipartFile,path);
            house.setId(System.currentTimeMillis()+"");
            Users users=(Users) session.getAttribute("user");
            house.setUserId(users.getId());
            house.setPath(filename);
            int temp=houseService.addHouse(house);
            return "{\"result\":1}";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "{\"result\":0}";
    }

    @RequestMapping("getHouseBysearch")
    public PageInfo<House> getHouseBysearch(HouseSearch houseSearch){
        houseSearch.setmpricearea();
        PageInfo<House> pageInfo=houseService.getHouseBySearch(houseSearch);
        return pageInfo;
    }

    @RequestMapping("getHouseByUser")
    public PageInfo<House> getHouseByUser(HttpSession session,PagePrameter pagePrameter){
        Users user=(Users) session.getAttribute("user");
        Integer userid=user.getId();
        PageInfo<House>pageInfo=houseService.getHouseByUser(userid, pagePrameter);
        return pageInfo;
    }

    @RequestMapping("delHouseById")
    public String delHouseById(String id,String filename){
        int temp=houseService.delHouse(id);
        if (temp>0){
            File file=new File("D:\\U4workspace\\image\\"+filename);
            if(file.exists()){
                file.delete();  //删除
            }
            return "{\"result\":1}";
        }else{
            return "{\"result\":0}";
        }
    }
}
