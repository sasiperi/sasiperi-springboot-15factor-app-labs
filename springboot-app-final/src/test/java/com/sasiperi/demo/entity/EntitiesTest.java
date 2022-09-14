package com.sasiperi.demo.entity;

import org.junit.jupiter.api.Test;
import org.meanbean.test.VerifierSettings;

import java.sql.Timestamp;
import java.util.function.Consumer;

import static org.meanbean.test.BeanVerifier.forClass;

public class EntitiesTest {

    private Consumer<VerifierSettings> verifierSettings = (settings) -> { settings.registerFactory(Timestamp.class, new TimestampTestFactory()); };

    @Test
    void testCustomer() {
        forClass(Customer.class)
                .withSettings(verifierSettings)
                .verify();
    }

}
