package com.naidiuk.serializationdeserializationbasics.mapper;

import com.naidiuk.serializationdeserializationbasics.dto.ShopDto;
import com.naidiuk.serializationdeserializationbasics.dto.ShopWithoutEmployeesDto;
import com.naidiuk.serializationdeserializationbasics.entity.Shop;

public class ShopMapper {

    private ShopMapper() {
    }

    public static Shop transformToDao(ShopDto shopDto) {
        return Shop.builder()
                .shopId(shopDto.getShopId())
                .address(shopDto.getAddress())
                .name(shopDto.getName())
                .numberOfEmployees(shopDto.getNumberOfEmployees())
                .hasSite(shopDto.isHasSite())
                .build();
    }

    public static ShopWithoutEmployeesDto transformToDtoWithoutEmployees(Shop shop) {
        return ShopWithoutEmployeesDto.builder()
                .shopId(shop.getShopId())
                .address(shop.getAddress())
                .name(shop.getName())
                .hasSite(shop.isHasSite())
                .build();
    }
}
