package com.sasiperi.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

//Below is if we want a general global security definition to be enabled, on every endpoint.
// Which can be overridden on a specific operation/request-method/Path
@OpenAPIDefinition(info = @Info(title = "Demo Customer API",
		description = "Demo stuff", version = "v1"),
		security = { @SecurityRequirement(name = "security_client_creds") } )
//@OpenAPIDefinition(info = @Info(title = "Demo Customer API", description = "Demo stuff", version = "v1") )
@SecurityScheme(name = "security_client_creds", type = SecuritySchemeType.OAUTH2,
		flows = @OAuthFlows(clientCredentials = @OAuthFlow(
				tokenUrl = "${springdoc.oAuthFlow.tokenUrl}", scopes = {
				@OAuthScope(name = "urn:sp-api:read", description = "read scope"),
				@OAuthScope(name = "urn:sp-api:write", description = "write scope") })))
public class OpenApiConfig { }
