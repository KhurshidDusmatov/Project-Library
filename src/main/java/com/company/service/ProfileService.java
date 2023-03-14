package com.company.service;

import com.company.dto.Book;
import com.company.dto.Profile;
import com.company.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public void getProfileList() {
        List<Profile> profileList = profileRepository.getProfileList();
        if (profileList == null) {
            System.out.println("Books not found");
            return;
        }
        for (Profile profile : profileList) {
            if (profile.getVisible()) {
                System.out.println(profile);
            }
        }
    }


    public void addProfile(Profile profile) {
        int n = profileRepository.countByPhone(profile.getPhone());
        if (n > 0) {
            System.out.println("This number already exist !");
            return;
        }
        n = profileRepository.addProfile(profile);
        if (n == 1) {
            System.out.println("Successfully added");
        } else {
            System.out.println("Profile not added");
        }

    }

    public void deleteProfile(String id) {
        if (!id.matches("\\d+")) {
            System.out.println("Id is invalid");
            return;
        }
        int n = profileRepository.deleteProfile(id);
        if (n == 1) {
            System.out.println("Student successfully deleted");
        } else {
            System.out.println("Student not deleted");
        }
    }

}
