package com.example.polls.util;

import com.example.polls.model.Poll;
import com.example.polls.model.User;
import com.example.polls.payload.ChoiceResponse;
import com.example.polls.payload.PollResponse;
import com.example.polls.payload.UserResponse;
import com.example.polls.payload.UserSummary;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ModelMapper {

    public static PollResponse mapPollToPollResponse(Poll poll, Map<Long, Long> choiceVotesMap, User creator, Long userVote) {
        PollResponse pollResponse = new PollResponse();
        pollResponse.setId(poll.getId());
        pollResponse.setTitle(poll.getTitle());
        pollResponse.setDescription(poll.getDescription());
        pollResponse.setCreationDateTime(poll.getCreatedAt());
        pollResponse.setExpirationDateTime(poll.getExpirationDateTime());
        Instant now = Instant.now();
        pollResponse.setExpired(poll.getExpirationDateTime().isBefore(now));

        List<ChoiceResponse> choiceResponses = poll.getChoices().stream().map(choice -> {
            ChoiceResponse choiceResponse = new ChoiceResponse();
            choiceResponse.setId(choice.getId());
            choiceResponse.setUsername(choice.getText());

            if(choiceVotesMap.containsKey(choice.getId())) {
                choiceResponse.setVoteCount(choiceVotesMap.get(choice.getId()));
            } else {
                choiceResponse.setVoteCount(0);
            }
            return choiceResponse;
        }).collect(Collectors.toList());

        pollResponse.setChoices(choiceResponses);
        UserSummary creatorSummary = new UserSummary(creator.getId(), creator.getUsername());
        pollResponse.setCreatedBy(creatorSummary);

        if(userVote != null) {
            pollResponse.setSelectedChoice(userVote);
        }

        long totalVotes = pollResponse.getChoices().stream().mapToLong(ChoiceResponse::getVoteCount).sum();
        pollResponse.setTotalVotes(totalVotes);

        return pollResponse;
    }

    public static UserResponse mapUserToUserResponse(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setUpdatedAt(user.getUpdatedAt());
        return  userResponse;

    }

}
