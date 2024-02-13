package org.informatics.logisticcompany.repository;

import org.informatics.logisticcompany.model.OfficeBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeBranchRepository extends JpaRepository<OfficeBranch, Long> {
}
