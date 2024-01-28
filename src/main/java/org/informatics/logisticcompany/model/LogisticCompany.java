package org.informatics.logisticcompany.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "logistic_companies")
public class LogisticCompany {

    @Id
    @Column(name = "logistic_company_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "logistic_company_name", length = 30, nullable = false)
    private String name;

    @Column(name = "logistic_company_address", length = 100, nullable = false)
    private String address;

    @Column(name = "logistic_company_foundation_date", nullable = false)
    private LocalDate foundationDate;

    @Column(name = "logistic_company_created_at", nullable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "logisticCompany")
    private Set<OfficeBranch> officeBranches;

    @OneToMany(mappedBy = "logisticCompany")
    private Set<Employee> employees;

    @OneToMany(mappedBy = "logisticCompany")
    private Set<Client> clients;

    @OneToMany(mappedBy = "logisticCompany")
    private Set<Shipment> shipments;

    public LogisticCompany() {
    }

    public LogisticCompany(String name, String address, LocalDate foundationDate, LocalDateTime createdAt) {
        this.name = name;
        this.address = address;
        this.foundationDate = foundationDate;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "LogisticCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", foundationDate=" + foundationDate +
                ", createdAt=" + createdAt +
                '}';
    }
}
