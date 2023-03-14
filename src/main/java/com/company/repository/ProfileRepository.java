package com.company.repository;

import com.company.db.DataBase;
import com.company.dto.Book;
import com.company.dto.Profile;
import com.company.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class ProfileRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Profile getProfileByPhone(String phone) {
        String sql = "select * from profile where phone = '" + phone+"'";
        List<Profile> profiles = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Profile.class));
        if (profiles.size()>0){
            return profiles.get(0);
        }
        return null;
    }
    public List<Profile> getProfileList(){
        String sql = "select * from profile";
        List<Profile> profiles  = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Profile.class));
        if (profiles.size()>0){
            return profiles;
        }
        return null;
    }

    public int countByPhone(String phone){
        return jdbcTemplate.queryForObject("select count(*) from profile where phone = '"+phone+"'", Integer.class);
    }

    public int addProfile(Profile profile){
        String sql = "insert into profile(name,surname,phone,created_date, role) values ('%s','%s','%s', now(), '%s')";
        sql = String.format(sql, profile.getName(), profile.getSurname(), profile.getPhone(), "USER");
        int n = jdbcTemplate.update(sql);
        return n;
    }

    public int deleteProfile(String id) {
            String sql = "update profile set visible = false where id = "+ id;
            int n = jdbcTemplate.update(sql);
            return n;
    }
}
