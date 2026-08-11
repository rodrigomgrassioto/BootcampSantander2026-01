package com.devrodrigo._542_compliance.domain;

public class CompliancePolicy {
    public static RiskAssessment evaluate(ComplianceScreening screening) {
        var status = RiskAssessmentStatus.APPROVED;

        // hasCriticalSanction será true se uma confidence for maior q 80%
        boolean hasCriticalSanction = screening.sanctions().stream()
                .anyMatch(s -> s.confidence() > 0.8);


        if (hasCriticalSanction) {
            status = RiskAssessmentStatus.REJECTED; // se maior q 80% status fica rejected
        } else if (screening.amlProfile().isPepPresent()) {
            status = RiskAssessmentStatus.MANUAL_REVIEW; // se for politicamente exposto.
        }

        int amlScore = screening.amlProfile().riskScore();

        // se pontos de risco for maior q 70%
        if (status == RiskAssessmentStatus.APPROVED && amlScore > 70) {
            status = RiskAssessmentStatus.MANUAL_REVIEW;
        }

        return new RiskAssessment(amlScore, status);
    }
}
