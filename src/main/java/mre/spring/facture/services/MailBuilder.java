package mre.spring.facture.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@AllArgsConstructor
public class MailBuilder {

    private final TemplateEngine templateEngine;

    String buildEmail(String message) {
         Context context = new Context();
         context.setVariable("message", message);
         return templateEngine.process("mail", context);
    }
}
