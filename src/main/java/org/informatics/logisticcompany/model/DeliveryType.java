package org.informatics.logisticcompany.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "delivery_types")
public class DeliveryType {

    @Id
    @Column(name = "delivery_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "delivery_type_name", length = 30, nullable = false)
    private String name;

    @Column(name = "delivery_type_description", length = 255, nullable = false)
    private String description;

    @OneToMany(mappedBy = "deliveryType")
    private Set<PricingTier> pricingTiers;

    @OneToMany(mappedBy = "deliveryType")
    private Set<Shipment> shipments;

    public DeliveryType() {
    }

    public DeliveryType(String name, String description) {
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
        return "DeliveryType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
