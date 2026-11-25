
package edu.jsp.banking_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
    "edu.jsp.banking_app",
    "edu.jsp_banking_app_entity",
    "edu.jsp_banking_app_repository",
    "edu.jsp_banking_app_Service"
})
public class BankingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingApplication.class, args);
    }
}
