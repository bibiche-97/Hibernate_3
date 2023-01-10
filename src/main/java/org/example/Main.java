package org.example;

import org.example.airport2.Airport;
import org.example.airport2.Passenger;
import org.example.airport2.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hibernate2");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Airport airport = new Airport(1,"AIBD");
        Passenger bibi = new Passenger(1,"Aby Diouf");
        bibi.setCity("Bambey");
        bibi.setStreet("Ngascop");
        bibi.setZipCode("22400");
        bibi.setNumber("Rue 34");
        bibi.setAreaCode("+221");
        bibi.setPrefix("75");
        bibi.setLineNumber("2698428");
        bibi.setAirport(airport);


        Passenger djibi = new Passenger(2,"Dibril Faye");

        djibi.setCity("Saint Louis");
        djibi.setStreet("Richard Toll");
        djibi.setZipCode("21650");
        djibi.setNumber("Rue 45");
        djibi.setAreaCode("+221");
        djibi.setPrefix("70");
        djibi.setLineNumber("1568975");
        djibi.setAirport(airport);

        airport.addPassengers(bibi);
        airport.addPassengers(djibi);

        Ticket ticket1 = new Ticket(1, "AA1237");
        Ticket ticket2 = new Ticket(2, "AB1289");

        bibi.addTickets(ticket1);
        bibi.addTickets(ticket2);

        Ticket ticket3 = new Ticket(3, "AA1238");
        Ticket ticket4 = new Ticket(4, "AB1290");
        djibi.addTickets(ticket3);
        djibi.addTickets(ticket3);

        em.persist(airport);

        em.persist(bibi);
        em.persist(djibi);

        em.persist(ticket1);
        em.persist(ticket2);
        em.persist(ticket3);
        em.persist(ticket4);


        em.getTransaction().commit();
        emf.close();
    }
}