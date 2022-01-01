package com.rkmgithubacc.mba.userms.bootstrap;

import com.rkmgithubacc.mba.userms.dao.UserDAO;
import com.rkmgithubacc.mba.userms.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {
    private final UserDAO userDAO;
    
    public BootstrapData(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started through bootstrap");
        System.out.println("Starting user entity interaction using repository: " + userDAO);
        
        User user1 = new User();
        user1.setFirstName("Raj");
        user1.setLastName("Malhotra");
        user1.setUserName("Raj88");
        user1.setPassword("Welcome@1b");
        user1.setDateOfBirth(LocalDate.of(1988, 12, 28));
        Set<String> phoneNumbersSet1 = new HashSet<>();
        phoneNumbersSet1.add("+91-9999999999");
        phoneNumbersSet1.add("+91-9898989898");
        user1.setPhoneNumbersSet(phoneNumbersSet1);
        
        System.out.println("Before saving user: " + user1);
        User savedUser1 = userDAO.save(user1);
        System.out.println("After saving user: " + savedUser1);
        
        User user2 = new User();
        user2.setFirstName("Ricky");
        user2.setLastName("Ahuja");
        user2.setUserName("Ricky01");
        user2.setPassword("Sayonara@1b");
        user2.setDateOfBirth(LocalDate.of(2001, 1, 2));
        Set<String> phoneNumbersSet2 = new HashSet<>();
        phoneNumbersSet2.add("+91-9999999999");
        phoneNumbersSet2.add("+91-9898989898");
        user2.setPhoneNumbersSet(phoneNumbersSet2);
        
        System.out.println("Before saving user: " + user2);
        User savedUser2 = userDAO.save(user2);
        System.out.println("After saving user: " + savedUser2.toString());
    }
}
