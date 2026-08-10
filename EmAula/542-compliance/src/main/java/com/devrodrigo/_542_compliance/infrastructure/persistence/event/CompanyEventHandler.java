package com.devrodrigo._542_compliance.infrastructure.persistence.event;

import com.devrodrigo._542_compliance.application.AnalyzeCompanyRiskUseCase;
import com.devrodrigo._542_compliance.infrastructure.persistence.entity.CompanyEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class CompanyEventHandler {
    private static final Logger LOG = LoggerFactory.getLogger(CompanyEventHandler.class);

    private final AnalyzeCompanyRiskUseCase analyzeCompanyUseCase;

    public CompanyEventHandler(AnalyzeCompanyRiskUseCase analyzeCompanyUseCase) {
        this.analyzeCompanyUseCase = analyzeCompanyUseCase;
    }

    @HandleAfterCreate
    public void handleAfterCreateEvent(CompanyEntity entity) {
        LOG.info("handleAfterCreateEvent {}", entity);
        this.analyzeCompanyUseCase.execute(entity.toDomain());
    }
}
