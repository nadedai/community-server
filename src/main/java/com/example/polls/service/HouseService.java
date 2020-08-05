package com.example.polls.service;

import com.example.polls.exception.AppException;
import com.example.polls.exception.ResourceNotFoundException;
import com.example.polls.model.*;
import com.example.polls.payload.ApiResponse;
import com.example.polls.payload.HouseRequest;
import com.example.polls.repository.AddressRepository;
import com.example.polls.repository.HouseRepository;
import com.example.polls.repository.RoleRepository;
import com.example.polls.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/**
 * @author hhtt
 * @date 2020/8/3 18:34
 * description:
 */
@Slf4j
@Service
public class HouseService {


    @Autowired
    HouseRepository houseRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    AddressRepository addressRepository;
    @Transactional
    public ResponseEntity<?> createHouse(HouseRequest houseRequest) {
        //查看地址是否存在
//        Address address = addressRepository.findAddressByStreetAndCommunityAndCourt(houseRequest.getStreet(),
//                houseRequest.getCommunity(), houseRequest.getCourt()).orElseThrow(() -> new AppException("address not exist,plz add!"));
//
//        String household = houseRequest.getHousehold();
//        //查看house存在 不存在则创建
//        House house = houseRepository.findByAddressIdAndHousehold(address.getId(), household).orElseGet(
//                () -> {
//                    House _house = new House();
//                    _house.setHousehold(household);
//                    _house.setAddress(address);
//                    return houseRepository.save(_house);
//                }
//        );
//
//        //查看用户是否已经手机注册 //用户的手机号码是否和录入的相同
//        Boolean existsByPhone = userRepository.existsByPhone(houseRequest.getPhone());
//        User user;
//        if (existsByPhone) {
//            //已经注册 将用户名 信息填入
//            log.info("已经注册");
//            user = userRepository.findByPhone(houseRequest.getPhone())
//                    .orElseThrow(() -> new ResourceNotFoundException("User", "phone", houseRequest.getPhone()));
//
//            user.getHouses().add(house);
//            user.setUsername(houseRequest.getUsername());
//        } else {
//            //未注册
//            user = new User();
//            Set<House> set = new HashSet<>();
//            set.add(house);
//            user.setHouses(set);
//            user.setUsername(houseRequest.getUsername());
//            user.setPhone(houseRequest.getPhone());
//            Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
//                    .orElseThrow(() -> new AppException("User Role not set."));
//            user.setRoles(Collections.singleton(userRole));
//            user.setRegister(true);
//        }
//        userRepository.save(user);
//        return ResponseEntity.ok()
//                .body(new ApiResponse(true, "House Created Successfully"));
        return null;
    }
}




