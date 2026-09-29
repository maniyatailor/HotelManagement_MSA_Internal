package com.mycompany.hotelapplication.config;
import jakarta.annotation.security.DeclareRoles;
import jakarta.ws.rs.ApplicationPath;
import org.eclipse.microprofile.auth.LoginConfig;

@SuppressWarnings({"EmptyClass", "SuppressionAnnotation"})
@DeclareRoles({"CUSTOMER","OWNER"})
@LoginConfig(authMethod="MP-JWT")
@ApplicationPath("rest")
public class BootStrap extends jakarta.ws.rs.core.Application {
}
