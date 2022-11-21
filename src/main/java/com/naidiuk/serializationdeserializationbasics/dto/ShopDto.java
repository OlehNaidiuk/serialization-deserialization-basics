package com.naidiuk.serializationdeserializationbasics.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ShopDto {
    private Long shopId;
    private String address;
    private String name;
    private int numberOfEmployees;
    private boolean hasSite;
}
