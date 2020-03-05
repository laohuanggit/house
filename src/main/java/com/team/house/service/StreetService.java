package com.team.house.service;

import com.team.house.entity.Street;

import java.util.List;

public interface StreetService {
    public List<Street> getAllStreet();
    public List<Street> getStreetByDistrict(Integer districtId);
}
