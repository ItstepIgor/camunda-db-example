package com.camunda.camundaaccess.service;

public interface AccessRequestService {

    Long create(Long entityId, String userName, String comment);

    void update(Long entityId, String approver, Boolean isApproved);
}
