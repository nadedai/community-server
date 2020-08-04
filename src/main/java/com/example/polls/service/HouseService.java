package com.example.polls.service;

import com.example.polls.model.Const;
import com.example.polls.model.House;
import com.example.polls.payload.HouseRequest;
import com.example.polls.repository.ConstRepository;
import com.example.polls.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
;



/**
 * @author hhtt
 * @date 2020/8/3 18:34
 * description:
 */

@Service
public class HouseService {

    @Autowired
    ConstRepository constRepository;
    @Autowired
    HouseRepository houseRepository;
    public ResponseEntity<?> createHouse(HouseRequest houseRequest){
        House house = new House();
        house.setStreet(getConst(houseRequest.getCommunity()));
        house.setCommunity(getConst(houseRequest.getCommunity()));
        house.setCourt(getConst(houseRequest.getCommunity()));
        house.setHousehold(getConst(houseRequest.getCommunity()));
        houseRepository.save(house);
        return null;
    }

    private Const getConst(String text){
        return constRepository.findConstByText("").orElse(constRepository.save(new Const("")));
    }


}




