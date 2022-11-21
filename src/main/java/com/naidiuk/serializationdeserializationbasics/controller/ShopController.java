package com.naidiuk.serializationdeserializationbasics.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naidiuk.serializationdeserializationbasics.dto.ShopDto;
import com.naidiuk.serializationdeserializationbasics.dto.ShopWithoutEmployeesDto;
import com.naidiuk.serializationdeserializationbasics.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/shops")
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;
    private final ObjectMapper objectMapper;

    @PostMapping
    public void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String shopDto = request.getReader().lines().collect(Collectors.joining());
        ShopDto shop = objectMapper.readValue(shopDto, ShopDto.class);
        ShopWithoutEmployeesDto savedShop = shopService.save(shop);
        String savedShopString = objectMapper.writeValueAsString(savedShop);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(savedShopString);
        writer.flush();
        writer.close();
    }

    @GetMapping
    public void findAll(HttpServletResponse response) throws IOException {
        List<ShopWithoutEmployeesDto> shopsWithoutEmployees = shopService.findAll();
        String shopsWithoutEmployeesDto = objectMapper.writeValueAsString(shopsWithoutEmployees);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(shopsWithoutEmployeesDto);
        writer.flush();
        writer.close();
    }
}
