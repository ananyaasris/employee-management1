package com.github.yildizmy;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j(topic = "EmployeeApplication")
@SpringBootApplication
@RestController
@OpenAPIDefinition(info =
    @Info(
        title = "HR Employee Service API",
        version = "1.0",
        description = "Documentation for HR Employee Service"
    )
)
public class EmployeeApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(EmployeeApplication.class);
        Environment env = app.run(args).getEnvironment();
        logApplicationStartup(env);
    }

    @GetMapping("/hello")
    public String hello() {
        return "<h1>👨‍💼 Welcome Ananyaa! Employee Service is Running 🚀</h1>";
    }

    private static void logApplicationStartup(Environment env) {
        String protocol = (env.getProperty("server.ssl.key-store") != null) ? "https" : "http";
        String serverPort = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path", "/");
        String hostAddress = "localhost";

        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("The host name could not be determined, using localhost as fallback");
        }

        log.info("\n-------------------------------------------------------\n" +
                "Application '{}' is running!\n" +
                "Local:      {}://localhost:{}{}\n" +
                "External:   {}://{}:{}{}\n" +
                "-------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol, serverPort, contextPath,
                protocol, hostAddress, serverPort, contextPath);
    }
}
