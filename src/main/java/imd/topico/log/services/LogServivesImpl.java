package imd.topico.log.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.stereotype.Service;
import imd.topico.log.models.LogModels;
import imd.topico.log.repository.LogRepository;
import java.util.List;

@Service
public class LogServivesImpl implements logServices {
    
    private final LogRepository logRepository;

    @Autowired
    public LogServivesImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public void save(LogModels logModels) {
        logRepository.save(logModels);
    }

    @Override
    public List<LogModels> findByTimestampBetween(String startDate, String endDate) {
        return logRepository.findByTimestampBetween(startDate, endDate);
    }

    @Override
    public List<LogModels> findByLevelBetween(String level) {
        return logRepository.findByLevelBetween(level);
    }

    @Override
    public List<LogModels> findByMicroserviceBetween(String microservice) {
        return logRepository.findByMicroserviceBetween(microservice);
    }

    @Override
    public List<LogModels> findByThreadBetween(String thread) {
        return logRepository.findByThreadBetween(thread);
    }

    @Override
    public List<LogModels> findByClassNameBetween(String className) {
        return logRepository.findByClassNameBetween(className);
    }

    @Override
    public List<LogModels> findByMethodBetween(String method) {
        return logRepository.findByMethodBetween(method);
    }
    
    @Override
    public boolean testDatabaseConnection() {
        try {
            String mongoURI = "mongodb://mongo:h6YnE3VZ73HSEVWt3TFQ@containers-us-west-26.railway.app:5629/logs?authSource=admin";
            SimpleMongoClientDatabaseFactory mongoDbFactory = new SimpleMongoClientDatabaseFactory(mongoURI);
            MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);
            mongoTemplate.getDb().listCollections().first();
            return true; 
        } catch (Exception e) {
            return false; 
        }
    }
}
