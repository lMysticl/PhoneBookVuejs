package com.mystic.model.maping;

import com.mystic.model.dto.UserDTO;
import com.mystic.user.domain.User;
import org.modelmapper.AbstractConverter;

import java.util.Objects;

/**
 * @author Pavel Putrenkov
 * @version 1.0
 * @since
 */
public class FromTableToTableDtoConverterUser extends AbstractConverter<User, UserDTO> {

    @Override
    protected UserDTO convert(User user) {
        if (Objects.nonNull(user)) {
            UserDTO userDTO = new UserDTO();
            userDTO.setFirstname(user.getFirstname());
            userDTO.setLastname(user.getLastname());
            userDTO.setUserId(user.getUserId());
            userDTO.setAvatar(user.getAvatar());
//            userDTO.setPassword(user.getPassword());
            userDTO.setUsername(user.getUsername());
            return userDTO;
        }
        return new UserDTO();
    }
}
