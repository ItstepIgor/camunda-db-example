package com.camunda.camundaaccess.delegate;

import com.camunda.camundaaccess.config.ProcessVariableConstants;
import com.camunda.camundaaccess.service.AccessRequestService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class UpdateAccessRequest implements JavaDelegate {

    private final AccessRequestService accessRequestService;

    public UpdateAccessRequest(AccessRequestService accessRequestService) {
        this.accessRequestService = accessRequestService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Long entityId = (Long) delegateExecution.getVariable(ProcessVariableConstants.ENTITY_ID);
        String approver = (String) delegateExecution.getVariable(ProcessVariableConstants.APPROVER);
        Boolean isApproved = (Boolean) delegateExecution.getVariable(ProcessVariableConstants.IS_APPROVED);

        accessRequestService.update(entityId, approver, isApproved);
    }
}
