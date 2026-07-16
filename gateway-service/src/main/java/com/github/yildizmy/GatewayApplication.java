package com.github.yildizmy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RequestMapping("/gateway-service")
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(GatewayApplication.class);
        Environment env = app.run(args).getEnvironment();
        logApplicationStartup(env);
    }

    @GetMapping("/hi")
    public String hi() {
        return "<h1>👋 Hi! Gateway Service is Running Successfully.</h1>";
    }

    @GetMapping("/stopped")
    public String welcome() {
        return "<h1>🚀 Welcome to My Gateway Service!</h1>";
    }

    private static void logApplicationStartup(Environment env) {
        String protocol = env.getProperty("server.ssl.key-store") != null ? "https" : "http";
        String serverPort = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path", "/");
        String hostAddress = "localhost";

        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("Host name could not be determined, using localhost");
        }

        log.info(
                "\n-------------------------------------------------------\n" +
                "Application '{}' is running!\n" +
                "Local:      {}://localhost:{}{}\n" +
                "External:   {}://{}:{}{}\n" +
                "-------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol, serverPort, contextPath,
                protocol, hostAddress, serverPort, contextPath
        );
    }
}
