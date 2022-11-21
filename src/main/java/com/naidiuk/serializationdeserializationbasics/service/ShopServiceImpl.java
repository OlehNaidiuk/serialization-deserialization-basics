package com.naidiuk.serializationdeserializationbasics.service;

import com.naidiuk.serializationdeserializationbasics.dto.ShopDto;
import com.naidiuk.serializationdeserializationbasics.dto.ShopWithoutEmployeesDto;
import com.naidiuk.serializationdeserializationbasics.entity.Shop;
import com.naidiuk.serializationdeserializationbasics.mapper.ShopMapper;
import com.naidiuk.serializationdeserializationbasics.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;

    @Override
    public ShopWithoutEmployeesDto save(ShopDto shopDto) {
        Shop shop = ShopMapper.transformToDao(shopDto);
        Shop savedShop = shopRepository.save(shop);
        return ShopMapper.transformToDtoWithoutEmployees(savedShop);
    }

    @Override
    public List<ShopWithoutEmployeesDto> findAll() {
        Iterable<Shop> iterableShops = shopRepository.findAll();
        List<Shop> shops = new ArrayList<>();
        iterableShops.forEach(shops::add);
        return shops.stream()
                .map(ShopMapper::transformToDtoWithoutEmployees)
                .collect(Collectors.toList());
    }
}
