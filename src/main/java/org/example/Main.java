package org.example;

import org.example.entity.House;
import org.example.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static SessionFactory sessionFactory;
    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");
        Main.setUp();
        System.out.println("***");

        Session ses = sessionFactory.openSession();
        Transaction t = ses.beginTransaction();

        Person p = new Person();
        p.setFirstname(getRandomFirstname());
        p.setLastname(getRandomLastname());
        p.setSex(2);
        // Add apartment for person
        House h = new House("Kujakatu", 31);
        House h2 = new House("Hämeenkatu", 93);

        ses.persist(h);
        ses.persist(h2);

        p.getHouses().add(h);
        p.getHouses().add(h2);

        ses.persist(p);

        t.commit();

    }

    protected static void setUp() {
        // A SessionFactory is set up once
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml") // under resources/
                .build();
        try {
            sessionFactory =
                    new MetadataSources(registry)
                            .addAnnotatedClass(Person.class)
                            .buildMetadata()
                            .buildSessionFactory();
        }
        catch (Exception e) {

            System.out.println( e );

            // The registry would be destroyed by the SessionFactory, but we
            // had trouble building the SessionFactory so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    private static String getRandomFirstname() {
        String[] names = {"Seppo", "Matti", "Teppo", "Martti", "Sami", "Marko", "Antti"};
        return names[ new Random().nextInt(names.length) ];
    }

    private static String getRandomLastname() {
        String[] names = {"Virtanen", "Vuorinen", "Mäkinen", "Jokinen", "Korhonen", "Rantanen"};
        return names[ new Random().nextInt(names.length) ];
    }

}