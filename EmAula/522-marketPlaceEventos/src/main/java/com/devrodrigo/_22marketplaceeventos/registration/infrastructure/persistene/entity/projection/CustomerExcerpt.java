package com.devrodrigo._22marketplaceeventos.registration.infrastructure.persistene.entity.projection;

import com.devrodrigo._22marketplaceeventos.registration.infrastructure.persistene.entity.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "excerpt", types = Customer.class)
public interface CustomerExcerpt {
    String getFirstName();
    String getLastName();

    @Value("#{target.address?.toString()}")
    String getAddress();
}
