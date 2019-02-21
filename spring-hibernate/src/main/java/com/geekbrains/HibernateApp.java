package com.geekbrains;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = null;

        try{
//             Products that client bought
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            Client client = session.get(Client.class, 1L);
//            System.out.println(client);
//            System.out.println(client.getProducts());
//            session.getTransaction().commit();

//            specific product
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            Product product = session.get(Product.class, 5L);
//            System.out.println(product);
//            System.out.println(product.getClient().getName());
//            session.getTransaction().commit();

//             delete Product
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            Product product = session.get(Product.class, 10L);
//            session.delete(product);
//            session.getTransaction().commit();

//             delete Client
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            Client client = session.get(Client.class, 5L);
//            session.delete(client);
//            session.getTransaction().commit();

        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
