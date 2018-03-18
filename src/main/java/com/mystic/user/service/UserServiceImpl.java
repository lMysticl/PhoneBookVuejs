package com.mystic.user.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.targetbrain.DispatchServiceApp;
import com.targetbrain.user.domain.User;
import com.targetbrain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User getCurrentUser() {
        Long id = getUserId();
        return repository.findOne(id);
    }

    private Long getUserId() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            Object s = SecurityContextHolder.getContext().getAuthentication();

            JSONObject jsonObject = new JSONObject(mapper.writeValueAsString(s));
            return jsonObject
                    .getJSONObject("userAuthentication")
                    .getJSONObject("details")
                    .getJSONObject("principal")
                    .getLong("id");
        } catch (Exception e) {
            //possible only in dev profile when security is disabled
            return DispatchServiceApp.DevConfig.DEV_USER_ID;
        }

    }

}