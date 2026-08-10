package com.devrodrigo._542_compliance.infrastructure.persistence.entity;

//import com.devrodrigo._542_compliance.domain.Company;
//import com.devrodrigo._542_compliance.domain.CompanyId;
//import com.devrodrigo._542_compliance.domain.RiskAssessment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import java.util.Optional;
import java.util.UUID;

@KeySpace("companies") // do keyvalue para salvar em memória
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntity {
    @Id
    private UUID id;
    private String name, registrationNumber;
//    private RiskAssessment assessment;

//    public static CompanyEntity from(Company company) {
//        return new CompanyEntity(
//                company.getId().id(),
//                company.getName(),
//                company.getRegistrationNumber(),
//                company.getRiskAssessment().orElse(null)
//
//        );
//    }
//    public Company toDomain(){
//        return new Company(
//                new CompanyId(this.getId()),
//                this.getName(),
//                this.getRegistrationNumber(),
//                Optional.ofNullable(getAssessment())
//        );
//    };
}
