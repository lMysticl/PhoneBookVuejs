package com.mystic.model.dto;

import com.mystic.model.entity.Contact;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Pavel Putrenkov
 * @version 1.0
 * @since
 */
@Getter
@Setter
@Service
@ToString
@EqualsAndHashCode
public class ContactsDescriptionDto {

    List<Contact>  contacts;

    Integer count;

}
