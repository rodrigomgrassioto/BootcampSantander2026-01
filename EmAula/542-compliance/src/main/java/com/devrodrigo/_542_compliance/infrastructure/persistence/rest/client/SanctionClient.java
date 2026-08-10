package com.devrodrigo._542_compliance.infrastructure.persistence.rest.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "sanction-client", url = "https://a2fa188f-7b2b-41fa-b4d4-18aae59f1fef.mock.pstmn.io")
public interface SanctionClient {
    @GetMapping("/sanctions/companies/{registrationNumber}")
    void getCompanyRisk(@PathVariable String registrationNumber);
}
