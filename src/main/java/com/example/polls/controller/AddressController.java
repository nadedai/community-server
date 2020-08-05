package com.example.polls.controller;

import com.example.polls.model.Address;
import com.example.polls.payload.AddressRequest;
import com.example.polls.payload.AddressResponse;
import com.example.polls.payload.ApiResponse;
import com.example.polls.repository.AddressRepository;
import com.example.polls.service.AddressService;
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

    @Autowired
    AddressService addressService;

    @PostMapping
    public ResponseEntity<?> CreateAddress(@Valid @RequestBody AddressRequest addressRequest){
        if(addressRepository.existsByNameAndParentId(addressRequest.getName(),addressRequest.getParentId())){
            return new ResponseEntity(new ApiResponse(false, "address is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }
        //添加
        Address address = new Address();
        address.setName(addressRequest.getName());
        address.setParentId(address.getParentId());
        addressRepository.save(address);
        return ResponseEntity.ok()
                .body(new ApiResponse(true, "Address Created Successfully"));
    }

//    @GetMapping
//    public List<AddressResponse> getAddress(){
//        return addressService.getAddressResponse();
//    }

    @GetMapping
    public List<Address> getAddress(){
        return addressRepository.findAll();
    }

}
