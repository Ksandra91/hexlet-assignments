package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import exercise.model.Contact;
import exercise.repository.ContactRepository;
import exercise.dto.ContactDTO;
import exercise.dto.ContactCreateDTO;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactRepository contactRepository;

    // BEGIN
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDTO create(@RequestBody ContactCreateDTO data) {
        var entity = toEntity(data);
        contactRepository.save(entity);
        var contactDTO = toDto(entity);
        return contactDTO;

    }

    private Contact toEntity(ContactCreateDTO data) {
        Contact contact = new Contact();
        contact.setFirstName(data.getFirstName());
        contact.setLastName(data.getLastName());
        contact.setPhone(data.getPhone());
        return contact;
    }

    public ContactDTO toDto(Contact data) {
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(data.getId());
        contactDTO.setFirstName(data.getFirstName());
        contactDTO.setLastName(data.getLastName());
        contactDTO.setPhone(data.getPhone());
        contactDTO.setCreatedAt(data.getCreatedAt());
        contactDTO.setUpdatedAt(data.getUpdatedAt());

        return contactDTO;
    }
    // END
}
