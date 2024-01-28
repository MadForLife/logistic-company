package org.informatics.logisticcompany.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "clients")
@PrimaryKeyJoinColumn(name = "users_user_id")
public class Client extends User {

    @Column(name = "client_shipping_address", length = 100, nullable = false)
    private String shippingAddress;

    @ManyToOne
    @JoinColumn(name = "logistic_companies_logistic_company_id", nullable = false)
    private LogisticCompany logisticCompany;

    @OneToMany(mappedBy = "sender")
    private Set<Shipment> sendShipments;

    @OneToMany(mappedBy = "recipient")
    private Set<Shipment> receivedShipments;

    public Client() {
    }

    public Client(String firstName, String lastName, LocalDate birthDate, String address, String phoneNumber, String username, String password, String email, LocalDateTime createdAt, Boolean enabled, String shippingAddress, LogisticCompany logisticCompany) {
        super(firstName, lastName, birthDate, address, phoneNumber, username, password, email, createdAt, enabled);
        this.shippingAddress = shippingAddress;
        this.logisticCompany = logisticCompany;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public LogisticCompany getLogisticCompany() {
        return logisticCompany;
    }

    public void setLogisticCompany(LogisticCompany logisticCompany) {
        this.logisticCompany = logisticCompany;
    }

    @Override
    public String toString() {
        return "Client{" +
                "shippingAddress='" + shippingAddress + '\'' +
                ", logisticCompany=" + logisticCompany +
                '}';
    }
}
