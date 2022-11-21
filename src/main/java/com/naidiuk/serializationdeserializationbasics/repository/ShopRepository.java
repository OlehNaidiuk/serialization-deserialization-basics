package com.naidiuk.serializationdeserializationbasics.repository;

import com.naidiuk.serializationdeserializationbasics.entity.Shop;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<Shop, Long> {
}
