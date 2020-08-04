package com.example.polls.service;

import com.example.polls.exception.BadRequestException;
import com.example.polls.model.Poll;
import com.example.polls.model.User;
import com.example.polls.payload.PagedResponse;
import com.example.polls.payload.PollResponse;
import com.example.polls.payload.UserResponse;
import com.example.polls.repository.UserRepository;
import com.example.polls.security.UserPrincipal;
import com.example.polls.util.AppConstants;
import com.example.polls.util.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author hhtt
 * @date 2020/7/30 16:52
 * description:
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public PagedResponse<UserResponse> getAllUsers(UserPrincipal currentUser, int page, int size) {
        validatePageNumberAndSize(page, size);
        // Retrieve Polls
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        Page<User> users = userRepository.findAll(pageable);

        if(users.getNumberOfElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), users.getNumber(),
                    users.getSize(), users.getTotalElements(), users.getTotalPages(), users.isLast());
        }

        List<UserResponse> userResponses = users.map(ModelMapper::mapUserToUserResponse).getContent();

        return new PagedResponse<>( userResponses, users.getNumber(),
                users.getSize(), users.getTotalElements(), users.getTotalPages(), users.isLast());
    }

    private void validatePageNumberAndSize(int page, int size) {
        if(page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if(size > AppConstants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
        }
    }
}
