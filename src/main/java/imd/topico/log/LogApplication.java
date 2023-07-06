package imd.topico.log;

import com.fasterxml.jackson.databind.ObjectMapper;
import imd.topico.log.models.LogModels;
import imd.topico.log.services.LogServivesImpl;
import imd.topico.log.services.Utils;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class LogApplication {

    @Autowired
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
            logServivesImpl.save(logModel);
               
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

