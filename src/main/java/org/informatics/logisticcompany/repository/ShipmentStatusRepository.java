package org.informatics.logisticcompany.repository;

import org.informatics.logisticcompany.model.ShipmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentStatusRepository extends JpaRepository<ShipmentStatus, Long> {
}
