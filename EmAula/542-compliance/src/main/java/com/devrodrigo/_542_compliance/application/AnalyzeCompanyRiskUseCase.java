package com.devrodrigo._542_compliance.application;

import com.devrodrigo._542_compliance.domain.Company;
import com.devrodrigo._542_compliance.infrastructure.rest.client.SanctionClient;
import org.springframework.stereotype.Service;

@Service
public class AnalyzeCompanyRiskUseCase {

    private final SanctionClient sanctionClient;

    public AnalyzeCompanyRiskUseCase(SanctionClient sanctionClient) {
        this.sanctionClient = sanctionClient;
    }

    public void execute(Company domain){
        sanctionClient.getCompanyRisk(domain.getRegistrationNumber());
        // KYC - API de sanções
        // AML - API mocada de lavagem de dinheiro
    }
}
