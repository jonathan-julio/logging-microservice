package imd.topico.log;

import com.fasterxml.jackson.databind.ObjectMapper;
import imd.topico.log.models.LogModels;
import imd.topico.log.services.LogServivesImpl;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
@EnableRabbit
public class LogApplication {

    private LogServivesImpl logServivesImpl;

    private static final String QUEUE_NAME = "vascobank.logs";

    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class, args);
    }

     @RabbitListener(queues = QUEUE_NAME)
    public void processLogMessages(String messages) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            LogModels logModel = objectMapper.readValue(messages, LogModels.class);
            this.logServivesImpl.save(logModel);
            System.out.println("Save logRepository: " + messages );
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

