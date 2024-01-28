package org.informatics.logisticcompany.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "employees")
@PrimaryKeyJoinColumn(name = "users_user_id")
public class Employee extends User {

    @Column(name = "employee_salary", precision = 8, scale = 2, nullable = false)
    private BigDecimal salary;

    @ManyToOne
    @JoinColumn(name = "office_branches_office_branch_id", nullable = false)
    private OfficeBranch officeBranch;

    @ManyToOne
    @JoinColumn(name = "logistic_companies_logistic_company_id", nullable = false)
    private LogisticCompany logisticCompany;

    @ManyToOne
    @JoinColumn(name = "positions_position_id", nullable = false)
    private Position position;

    @OneToMany(mappedBy = "registeredBy")
    private Set<Shipment> registeredShipments;

    public Employee() {
    }

    public Employee(String firstName, String lastName, LocalDate birthDate, String address, String phoneNumber, String username, String password, String email, LocalDateTime createdAt, Boolean enabled, BigDecimal salary, OfficeBranch officeBranch, LogisticCompany logisticCompany, Position position) {
        super(firstName, lastName, birthDate, address, phoneNumber, username, password, email, createdAt, enabled);
        this.salary = salary;
        this.officeBranch = officeBranch;
        this.logisticCompany = logisticCompany;
        this.position = position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public OfficeBranch getOfficeBranch() {
        return officeBranch;
    }

    public void setOfficeBranch(OfficeBranch officeBranch) {
        this.officeBranch = officeBranch;
    }

    public LogisticCompany getLogisticCompany() {
        return logisticCompany;
    }

    public void setLogisticCompany(LogisticCompany logisticCompany) {
        this.logisticCompany = logisticCompany;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", officeBranch=" + officeBranch +
                ", logisticCompany=" + logisticCompany +
                ", position=" + position +
                '}';
    }
}
