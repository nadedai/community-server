package com.example.polls.service;

import com.example.polls.exception.ResourceNotFoundException;
import com.example.polls.model.Address;
import com.example.polls.payload.AddressResponse;
import com.example.polls.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hhtt
 * @date 2020/8/5 9:46
 * description:
 */
@Slf4j
@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public Address getAddress(Long id){
        Address address = recursiveTree(id);
        log.info(address.toString());
        return recursiveTree(id);
    }

    public List<AddressResponse> getAddressResponse(){
        List<AddressResponse> addressResponses = new ArrayList<>();
        List<Address> addressesRoot = addressRepository.findByParentId((long) 0);
        int index = 0;
        int level = 1;
        for(Address address : addressesRoot){
            AddressResponse addressResponse = recursiveTree1(address.getId(), level+1,createKey(level)+index);
            addressResponses.add(addressResponse);
            index++;
        }
        return addressResponses;
    }

    private Address recursiveTree(Long id){
        Address node = addressRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Address", "id", "Address id"));
        List<Address> childTreeNodes = addressRepository.findByParentId(id);
        for(Address child : childTreeNodes){
            Address n = recursiveTree(child.getId()); //递归
            node.getChildren().add(n);
        }
        return node;
    }

    private AddressResponse recursiveTree1(Long id,int level,String key){
        Address node = addressRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Address", "id", "Address id"));
        AddressResponse responseNode = new AddressResponse(node.getId(),node.getName(),key);
        List<Address> childTreeNodes = addressRepository.findByParentId(id);
        List<AddressResponse> childNodes = new ArrayList<>();
        int index = 0;
        for(Address address : childTreeNodes){
            AddressResponse addressResponse = new AddressResponse();
            addressResponse.setId(address.getId());
            addressResponse.setKey(key+'-'+index);
            childNodes.add(addressResponse);
            index++;
        }
        for(AddressResponse child : childNodes){
            AddressResponse n = recursiveTree1(child.getId(),++level,child.getKey()); //递归
            responseNode.getChildren().add(n);
        }
        return responseNode;
    }
    //0-0
    private String createKey(int level){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < level;i++){
            sb.append("0-");
        }
        return sb.toString();
    }

}
