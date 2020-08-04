package com.example.polls.controller;

import com.example.polls.model.House;
import com.example.polls.payload.HouseRequest;
import com.example.polls.payload.PollRequest;
import com.example.polls.security.CurrentUser;
import com.example.polls.security.UserPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hhtt
 * @date 2020/8/3 17:40
 * description:
 */
@RestController
@RequestMapping("/api/houses")
public class HouseController {

    @PostMapping
    public ResponseEntity<?> CreateHouse(@Valid @RequestBody HouseRequest houseRequest){
        CreateHouse(houseRequest);
        return null;
    }

}
