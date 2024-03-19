package com.example.application.services;

import com.example.application.data.entity.Company;
import com.example.application.data.entity.Contact;
import com.example.application.data.repositary.CompanyRepository;
import com.example.application.data.repositary.ContactRepository;
import com.example.application.data.repositary.StatusRepository;
import com.helger.commons.locale.country.ECountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.application.data.entity.Status;

import java.util.List;

@Service     // Service class responsible for managing user data,
// takes all repository dependencies in the constructor through autowiring.
public class CrmService {

    private final ContactRepository contactRepository;
    private final CompanyRepository companyRepository;
    private final StatusRepository statusRepository;

    //@Autowired
    public CrmService(ContactRepository contactRepository, CompanyRepository companyRepository,
                      StatusRepository statusRepository){

        this.contactRepository = contactRepository;
        this.companyRepository = companyRepository;
        this.statusRepository = statusRepository;
    }

    public List<Contact> findAllContacts(String filterText){
        if(filterText == null || filterText.isEmpty()) {
            return contactRepository.findAll();
        }else {
            return contactRepository.search(filterText);
        }
    }
    public long countContacts(){

        return contactRepository.count();
    }
    public void deleteContact(Contact contact){
        contactRepository.delete(contact);
    }
    public void saveContact(Contact contact){
        if(contact == null){
            System.err.println("Contact is null");
        }

        contactRepository.save(contact);
    }

    public List<Company> findAllCompanies(){
        return companyRepository.findAll();
    }

    public List<Status> findAllStatuses() {
        return statusRepository.findAll();
    }
}
