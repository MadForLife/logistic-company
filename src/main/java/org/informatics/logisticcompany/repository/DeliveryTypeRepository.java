package org.informatics.logisticcompany.repository;

import org.informatics.logisticcompany.model.DeliveryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryTypeRepository extends JpaRepository<DeliveryType, Long> {
}
