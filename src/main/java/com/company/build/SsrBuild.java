package com.company.build;

import com.company.entity.Profile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDateTime;

public class SsrBuild {
    public static void build(){
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();

//        Session session = factory.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        Profile profile = new Profile(1, "Xurshid", "Dusmatov", "000", LocalDateTime.now(), true, "ADMIN");
//        session.save(profile);
//        transaction.commit();
//
//        factory.close();
//        session.close();
    }
}
