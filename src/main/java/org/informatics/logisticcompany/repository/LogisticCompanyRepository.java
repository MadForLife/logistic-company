package org.informatics.logisticcompany.repository;

import org.informatics.logisticcompany.model.LogisticCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogisticCompanyRepository extends JpaRepository<LogisticCompany, Long> {
}
