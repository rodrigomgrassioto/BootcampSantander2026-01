package com.devrodrigo._542_compliance.application;

import com.devrodrigo._542_compliance.domain.Company;
import com.devrodrigo._542_compliance.domain.CompanyRepository;
import com.devrodrigo._542_compliance.domain.CompliancePolicy;
import com.devrodrigo._542_compliance.domain.ComplianceScreening;
import com.devrodrigo._542_compliance.infrastructure.rest.client.AntiMoneyLaunderingClient;
import com.devrodrigo._542_compliance.infrastructure.rest.client.SanctionClient;
import org.springframework.stereotype.Service;

@Service
public class AnalyzeCompanyRiskUseCase {
    private final SanctionClient sanctionClient;
    private final AntiMoneyLaunderingClient antiMoneyLaunderingClient;
    private final CompanyRepository companyRepository;

    public AnalyzeCompanyRiskUseCase(SanctionClient sanctionClient, AntiMoneyLaunderingClient antiMoneyLaunderingClient, CompanyRepository companyRepository) {
        this.sanctionClient = sanctionClient;
        this.antiMoneyLaunderingClient = antiMoneyLaunderingClient;
        this.companyRepository = companyRepository;
    }

    public void execute(Company company){
        // Já converte o JSON para objeto
        var sanctions = sanctionClient.getCompanyRisk(company.getRegistrationNumber()).toDomain();
        var amlProfile = antiMoneyLaunderingClient.screening(company.getRegistrationNumber()).toDomain();

        var screening = new ComplianceScreening(sanctions, amlProfile);
        var riskAssessment = CompliancePolicy.evaluate(screening);

        company.applyRiskAssessment(riskAssessment);
        companyRepository.save(company);
    }
}
