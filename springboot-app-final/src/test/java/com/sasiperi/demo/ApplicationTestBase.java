package com.sasiperi.demo;

import org.junit.jupiter.api.Disabled;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


/*
 * Throw any common (boiler plate) annotations that are common across ALL test classes here.
 * And let every test extend from here.
 */

@ActiveProfiles("test")
@Disabled
@SpringBootTest
//Throw all/any list of custom extensions (e.g. Test Logging, Log statements for PHI or a specific error code etc..) here.
//@ExtendWith(LoggingExtension.class, MyPHIExtension.class)

public class ApplicationTestBase {

}
