package org.informatics.logisticcompany.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "shipments")
public class Shipment {

    @Id
    @Column(name = "shipment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shipment_uuid", nullable = false)
    private UUID uuid;

    @Column(name = "shipment_destination", length = 100, nullable = false)
    private String destination;

    @Column(name = "shipment_weight", precision = 8, scale = 2, nullable = false)
    private BigDecimal weight;

    @Column(name = "shipment_total_cost", precision = 8, scale = 2, nullable = false)
    private BigDecimal totalCost;

    @Column(name = "shipment_created_at", nullable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "clients_users_user_id_sender", nullable = false)
    private Client sender;

    @ManyToOne
    @JoinColumn(name = "clients_users_user_id_recipient", nullable = false)
    private Client recipient;

    @ManyToOne
    @JoinColumn(name = "employees_users_user_id", nullable = false)
    private Employee registeredBy;

    @ManyToOne
    @JoinColumn(name = "delivery_types_delivery_type_id", nullable = false)
    private DeliveryType deliveryType;

    @ManyToOne
    @JoinColumn(name = "pricing_tiers_pricing_tier_id", nullable = false)
    private PricingTier pricingTier;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "current_shipment_status_current_shipment_status_id",
            referencedColumnName = "current_shipment_status_id",
            nullable = false
    )
    private CurrentShipmentStatus currentShipmentStatus;

    @ManyToOne
    @JoinColumn(name = "logistic_companies_logistic_company_id", nullable = false)
    private LogisticCompany logisticCompany;

    public Shipment() {
    }

    public Shipment(String destination, BigDecimal weight, BigDecimal totalCost, LocalDateTime createdAt, Client sender, Client recipient, Employee registeredBy, DeliveryType deliveryType, PricingTier pricingTier, CurrentShipmentStatus currentShipmentStatus, LogisticCompany logisticCompany) {
        this.uuid = UUID.randomUUID();
        this.destination = destination;
        this.weight = weight;
        this.totalCost = totalCost;
        this.createdAt = createdAt;
        this.sender = sender;
        this.recipient = recipient;
        this.registeredBy = registeredBy;
        this.deliveryType = deliveryType;
        this.pricingTier = pricingTier;
        this.currentShipmentStatus = currentShipmentStatus;
        this.logisticCompany = logisticCompany;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Client getSender() {
        return sender;
    }

    public void setSender(Client sender) {
        this.sender = sender;
    }

    public Client getRecipient() {
        return recipient;
    }

    public void setRecipient(Client recipient) {
        this.recipient = recipient;
    }

    public Employee getRegisteredBy() {
        return registeredBy;
    }

    public void setRegisteredBy(Employee registeredBy) {
        this.registeredBy = registeredBy;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public PricingTier getPricingTier() {
        return pricingTier;
    }

    public void setPricingTier(PricingTier pricingTier) {
        this.pricingTier = pricingTier;
    }

    public CurrentShipmentStatus getCurrentShipmentStatus() {
        return currentShipmentStatus;
    }

    public void setCurrentShipmentStatus(CurrentShipmentStatus currentShipmentStatus) {
        this.currentShipmentStatus = currentShipmentStatus;
    }

    public LogisticCompany getLogisticCompany() {
        return logisticCompany;
    }

    public void setLogisticCompany(LogisticCompany logisticCompany) {
        this.logisticCompany = logisticCompany;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id=" + id +
                ", uuid=" + uuid +
                ", destination='" + destination + '\'' +
                ", weight=" + weight +
                ", totalCost=" + totalCost +
                ", createdAt=" + createdAt +
                ", sender=" + sender +
                ", recipient=" + recipient +
                ", registeredBy=" + registeredBy +
                ", deliveryType=" + deliveryType +
                ", pricingTier=" + pricingTier +
                ", currentShipmentStatus=" + currentShipmentStatus +
                ", logisticCompany=" + logisticCompany +
                '}';
    }
}
