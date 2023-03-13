package com.company.service;

import com.company.controller.AdminController;
import com.company.controller.ProfileController;
import com.company.dto.Profile;
import com.company.enums.Role;
import com.company.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private AdminController adminController;
    @Autowired
    private ProfileController profileController;

    public void login(String phoneNumber){
        Profile profile = profileRepository.getProfileByPhone(phoneNumber);
        if (profile == null) {
            System.out.println("Phone or Password incorrect");
            return;
        }
        Boolean visible = profile.getVisible();
        if (!visible) {
            System.out.println("You not allowed.MF");
            return;
        }

//        ComponentContainer.currentProfile = profile;
        if (profile.getRole().equals("ADMIN")) {
            adminController.start();
        } else if (profile.getRole().equals("USER")) {
            profileController.start();
        } else {
            System.out.println("You don't have any role.");
        }
    }

}
