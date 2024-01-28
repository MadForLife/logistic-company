package org.informatics.logisticcompany.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "shipment_statuses")
public class ShipmentStatus {

    @Id
    @Column(name = "shipment_status_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shipment_status_name", length = 30, nullable = false)
    private String name;

    @Column(name = "shipment_status_description", length = 255, nullable = false)
    private String description;

    @OneToMany(mappedBy = "shipmentStatus")
    private Set<CurrentShipmentStatus> currentShipmentStatuses;

    public ShipmentStatus() {
    }

    public ShipmentStatus(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ShipmentStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
