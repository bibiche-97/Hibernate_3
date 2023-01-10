package org.example.airport2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Entity
@Table(name = "PASSENGERS")
@SecondaryTables({
        @SecondaryTable(name = "ADDRESSES",
            pkJoinColumns = @PrimaryKeyJoinColumn(name = "PASSENGER_ID",referencedColumnName = "PASSENGER_ID")),
        @SecondaryTable(name = "PHONES",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "PASSENGER_ID", referencedColumnName = "PASSENGER_ID"))
})
public class Passenger {

    @Id
    @Column(name = "PASSENGER_ID")
    private int id;
    @Column(name = "PASSENGER_NAME", table = "PASSENGERS")
    private  String name ;
   /* @Column(name = "PASSENGER_ADDRESS", table = "ADDRESSES", columnDefinition = "varchar(35) not null")
    private String address;
*/
    @Column(name = "STREET", table = "ADDRESSES", columnDefinition = "varchar(25) not null ")
    private String street;
    @Column(name = "NUMBER", table = "ADDRESSES", columnDefinition = "varchar(15) not null ")
    private  String number;
    @Column(name = "ZIP_CODE", table = "ADDRESSES", columnDefinition = "varchar(10) not null ")
    private String zipCode;
    @Column(name = "CITY", table = "ADDRESSES", columnDefinition = "varchar(35) not null ")
    private String city;

    @Column(name = "AREA_CODE", table = "PHONES", columnDefinition = "varchar(5) not null ")
    private String areaCode;
    @Column(name = "PREFIX", table = "PHONES", columnDefinition = "varchar(5) not null ")
    private String prefix;
    @Column(name = "LINE_NUMBER", table = "PHONES", columnDefinition = "varchar(10) not null ")
    private String lineNumber;

    @ManyToOne
    @JoinColumn(name = "AIRPORT_ID")
    private Airport airport;

    @OneToMany(mappedBy = "passenger")
    private List<Ticket> tickets = new ArrayList<>();

    public Passenger(int id,String name) {
        this.id=id;
        this.name = name;

        this.tickets = tickets;
    }

    public Passenger(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public List<Ticket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }
    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTickets(Ticket ticket) {
        tickets.add(ticket);
    }
}
