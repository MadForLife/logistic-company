package org.informatics.logisticcompany.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "current_shipment_status")
public class CurrentShipmentStatus {

    @Id
    @Column(name = "current_shipment_status_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "current_shipment_status_notes", length = 255, nullable = false)
    private String notes;

    @Column(name = "current_shipment_status_last_updated", nullable = false, columnDefinition = "DATETIME default CURRENT_TIMESTAMP")
    private LocalDateTime lastUpdated;

    @ManyToOne
    @JoinColumn(name = "shipment_statuses_shipment_status_id", nullable = false)
    private ShipmentStatus shipmentStatus;

    @OneToOne(mappedBy = "currentShipmentStatus")
    private Shipment shipment;

    public CurrentShipmentStatus() {
    }

    public CurrentShipmentStatus(String notes, LocalDateTime lastUpdated, ShipmentStatus shipmentStatus) {
        this.notes = notes;
        this.lastUpdated = lastUpdated;
        this.shipmentStatus = shipmentStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public ShipmentStatus getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(ShipmentStatus shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    @Override
    public String toString() {
        return "CurrentShipmentStatus{" +
                "id=" + id +
                ", notes='" + notes + '\'' +
                ", lastUpdated=" + lastUpdated +
                ", shipmentStatus=" + shipmentStatus +
                '}';
    }
}
