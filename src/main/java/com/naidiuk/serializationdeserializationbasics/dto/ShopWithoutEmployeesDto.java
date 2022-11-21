package com.naidiuk.serializationdeserializationbasics.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ShopWithoutEmployeesDto {
    private Long shopId;
    private String address;
    private String name;
    private boolean hasSite;
}
