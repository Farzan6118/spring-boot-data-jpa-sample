package com.example.demo.schedulingtasks;

import com.example.demo.model.Contact;
import com.example.demo.model.Department;
import com.example.demo.model.Person;
import com.example.demo.model.Role;
import com.example.demo.repository.ContactRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.RoleRepository;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    final ContactRepository contactRepository;
    final DepartmentRepository departmentRepository;
    final PersonRepository personRepository;
    final RoleRepository roleRepository;
    Faker faker = new Faker(new Locale("fa"));
    List<Contact> contacts;
    List<Role> roles;
    List<Person> people;
    List<Department> departments;

    public ScheduledTasks(ContactRepository contactRepository, DepartmentRepository departmentRepository, PersonRepository personRepository, RoleRepository roleRepository) {
        this.contactRepository = contactRepository;
        this.departmentRepository = departmentRepository;
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
    }

    @Scheduled(cron = "0 * * * * *")
    public void reportCurrenTime() {
        int recordLength = 10;

        long contactCount = contactRepository.count();
        long departmentCount = departmentRepository.count();
        long peopleCount = personRepository.count();
        long roleCount = roleRepository.count();

        if (contactCount < recordLength) {
            contactGenerator(recordLength - contactCount);
        }
        if (departmentCount < recordLength) {
            departmentGenerator(recordLength - departmentCount);
        }
        if (peopleCount < recordLength) {
            peopleGenerator(recordLength - peopleCount);
        }
        if (roleCount < recordLength) {
            roleGenerator(recordLength - roleCount);
        }

        log.info("The time {} is {} now", new Date(), "TEST");
    }

    private void roleGenerator(Long recordSize) {
        roles = new ArrayList<>();
        for (int i = 0; i < recordSize; i++) {
            roles.add(new Role(faker.name().title(), faker.number().digits(2)));
        }
        roleRepository.saveAll(roles);
    }

    private void peopleGenerator(Long recordSize) {
        people = new ArrayList<>();
        for (int i = 0; i < recordSize; i++) {
            people.add(new Person(faker.name().firstName(), faker.name().lastName(), faker.date().birthday(18, 80), faker.idNumber().valid(), ""));
        }
        personRepository.saveAll(people);
    }

    private void departmentGenerator(Long recordSize) {
        departments = new ArrayList<>();
        for (int i = 0; i < recordSize; i++) {
            departments.add(new Department(faker.commerce().department(), faker.number().digits(2)));
        }
        departmentRepository.saveAll(departments);

    }

    private void contactGenerator(Long recordSize) {
        contacts = new ArrayList<>();
        for (int i = 0; i < recordSize; i++) {
            contacts.add(new Contact(faker.address().streetAddress(), faker.phoneNumber().phoneNumber()));
        }
        contactRepository.saveAll(contacts);

    }

}
