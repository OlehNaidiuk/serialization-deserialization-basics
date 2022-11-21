package com.naidiuk.serializationdeserializationbasics.service;

import com.naidiuk.serializationdeserializationbasics.dto.ShopDto;
import com.naidiuk.serializationdeserializationbasics.dto.ShopWithoutEmployeesDto;

import java.util.List;

public interface ShopService {
    ShopWithoutEmployeesDto save(ShopDto shopDto);
    List<ShopWithoutEmployeesDto> findAll();
}
