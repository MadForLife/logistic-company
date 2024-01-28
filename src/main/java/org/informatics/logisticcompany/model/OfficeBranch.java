package org.informatics.logisticcompany.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "office_branches")
public class OfficeBranch {

    @Id
    @Column(name = "office_branch_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "office_branch_name", length = 30, nullable = false)
    private String name;

    @Column(name = "office_branch_address", length = 100, nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "logistic_companies_logistic_company_id", nullable = false)
    private LogisticCompany logisticCompany;

    @OneToMany(mappedBy = "officeBranch")
    private Set<Employee> employees;

    public OfficeBranch() {
    }

    public OfficeBranch(String name, String address, LogisticCompany logisticCompany) {
        this.name = name;
        this.address = address;
        this.logisticCompany = logisticCompany;
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

    public LogisticCompany getLogisticCompany() {
        return logisticCompany;
    }

    public void setLogisticCompany(LogisticCompany logisticCompany) {
        this.logisticCompany = logisticCompany;
    }

    @Override
    public String toString() {
        return "OfficeBranch{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", logisticCompany=" + logisticCompany +
                '}';
    }
}
