package com.camunda.camundaaccess.repository;

import com.camunda.camundaaccess.domain.AccessRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccessRequestRepository extends JpaRepository<AccessRequest, Long> {

    Optional<AccessRequest> findOneByEntityId(Long entityId);
}
