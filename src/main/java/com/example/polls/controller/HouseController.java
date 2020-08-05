package com.example.polls.controller;

import com.example.polls.payload.HouseRequest;

import com.example.polls.service.HouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * @author hhtt
 * @date 2020/8/3 17:40
 * description:
 */
@RestController
@Slf4j
@RequestMapping("/api/houses")
public class HouseController {
    @Autowired
    HouseService houseService;

    @PostMapping
    public ResponseEntity<?> CreateHouse(@Valid @RequestBody HouseRequest houseRequest){

        return  houseService.createHouse(houseRequest);
    }

    @PostMapping("test")
    public void test(@Valid @RequestBody HouseRequest houseRequest){
        log.info(houseRequest.toString());
    }

    @GetMapping("/address")
    public void getHousesAddress(){

    }

}
