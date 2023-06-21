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
    public List<LogModels> findByLevelBetween(String level, String startDate, String endDate) {
        return logRepository.findByLevelBetween(level, startDate, endDate);
    }

    @Override
    public List<LogModels> findByMicroserviceBetween(String microservice, String startDate, String endDate) {
        return logRepository.findByMicroserviceBetween(microservice, startDate, endDate);
    }

    @Override
    public List<LogModels> findByThreadBetween(String thread, String startDate, String endDate) {
        return logRepository.findByThreadBetween(thread, startDate, endDate);
    }

    @Override
    public List<LogModels> findByClassNameBetween(String className, String startDate, String endDate) {
        return logRepository.findByClassNameBetween(className, startDate, endDate);
    }

    @Override
    public List<LogModels> findByMethodBetween(String method, String startDate, String endDate) {
        return logRepository.findByMethodBetween(method, startDate, endDate);
    }

    @Override
    public boolean testDatabaseConnection() {
        try {
            String mongoURI = "mongodb://localhost:27017/test";
            SimpleMongoClientDatabaseFactory mongoDbFactory = new SimpleMongoClientDatabaseFactory(mongoURI);
            MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);
            mongoTemplate.getDb().listCollections().first();
            return true; 
        } catch (Exception e) {
            return false; 
        }
    }
}
