package com.example.polls.controller;

import com.example.polls.model.Address;
import com.example.polls.payload.AddressRequest;
import com.example.polls.payload.ApiResponse;
import com.example.polls.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author hhtt
 * @date 2020/8/4 17:44
 * description:
 */
@RestController
@Slf4j
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    @PostMapping
    public ResponseEntity<?> CreateAddress(@Valid @RequestBody AddressRequest addressRequest){
        Boolean exist = addressRepository.existsAddressByStreetAndCommunityAndCourt(addressRequest.getStreet()
                                                                    ,addressRequest.getCommunity()
                                                                    ,addressRequest.getCourt());
        if(exist){
            return new ResponseEntity(new ApiResponse(false, "address is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }
        Address address = new Address();
        address.setStreet(addressRequest.getStreet());
        address.setCommunity(addressRequest.getCommunity());
        address.setCourt(addressRequest.getCourt());
        addressRepository.save(address);
        return ResponseEntity.ok().body(new ApiResponse(true, "address created successfully"));
    }

    @GetMapping
    public List<Address> findAllAddress(){
        return addressRepository.findAll();
    }
}
