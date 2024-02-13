package org.informatics.logisticcompany.repository;

import org.informatics.logisticcompany.model.CurrentShipmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentShipmentStatusRepository extends JpaRepository<CurrentShipmentStatus, Long> {
}
