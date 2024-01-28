package org.informatics.logisticcompany.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "pricing_tiers")
public class PricingTier {

    @Id
    @Column(name = "pricing_tier_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pricing_tier_min_weight", precision = 8, scale = 2, nullable = false)
    private BigDecimal minWeight;

    @Column(name = "pricing_tier_max_weight", precision = 8, scale = 2, nullable = false)
    private BigDecimal maxWeight;

    @Column(name = "pricing_tier_base_cost", precision = 8, scale = 2, nullable = false)
    private BigDecimal baseCost;

    @Column(name = "pricing_tier_cost_per_unit_weight", precision = 8, scale = 2, nullable = false)
    private BigDecimal costPerUnitWeight;

    @ManyToOne
    @JoinColumn(name = "delivery_types_delivery_type_id", nullable = false)
    private DeliveryType deliveryType;

    @OneToMany(mappedBy = "pricingTier")
    private Set<Shipment> shipments;

    public PricingTier() {
    }

    public PricingTier(BigDecimal minWeight, BigDecimal maxWeight, BigDecimal baseCost, BigDecimal costPerUnitWeight, DeliveryType deliveryType) {
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.baseCost = baseCost;
        this.costPerUnitWeight = costPerUnitWeight;
        this.deliveryType = deliveryType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(BigDecimal minWeight) {
        this.minWeight = minWeight;
    }

    public BigDecimal getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(BigDecimal maxWeight) {
        this.maxWeight = maxWeight;
    }

    public BigDecimal getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(BigDecimal baseCost) {
        this.baseCost = baseCost;
    }

    public BigDecimal getCostPerUnitWeight() {
        return costPerUnitWeight;
    }

    public void setCostPerUnitWeight(BigDecimal costPerUnitWeight) {
        this.costPerUnitWeight = costPerUnitWeight;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    @Override
    public String toString() {
        return "PricingTier{" +
                "id=" + id +
                ", minWeight=" + minWeight +
                ", maxWeight=" + maxWeight +
                ", baseCost=" + baseCost +
                ", costPerUnitWeight=" + costPerUnitWeight +
                ", deliveryType=" + deliveryType +
                '}';
    }
}
