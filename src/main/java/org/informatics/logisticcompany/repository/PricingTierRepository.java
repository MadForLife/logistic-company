package org.informatics.logisticcompany.repository;

import org.informatics.logisticcompany.model.PricingTier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingTierRepository extends JpaRepository<PricingTier, Long> {
}
