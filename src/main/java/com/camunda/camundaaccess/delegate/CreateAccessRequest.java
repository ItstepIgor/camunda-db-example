package com.camunda.camundaaccess.delegate;

import com.camunda.camundaaccess.config.ProcessVariableConstants;
import com.camunda.camundaaccess.service.AccessRequestService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class CreateAccessRequest implements JavaDelegate {

    private final AccessRequestService accessRequestService;

    public CreateAccessRequest(AccessRequestService accessRequestService) {
        this.accessRequestService = accessRequestService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String userName = (String) delegateExecution.getVariable(ProcessVariableConstants.USER_NAME);
        String comment = (String) delegateExecution.getVariable(ProcessVariableConstants.COMMENT);
        Long entityId = (Long) delegateExecution.getVariable(ProcessVariableConstants.ENTITY_ID);
        Long id = accessRequestService.create(entityId, userName, comment);

        delegateExecution.setVariable(ProcessVariableConstants.ID, id);
    }
}
