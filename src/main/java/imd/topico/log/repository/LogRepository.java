package imd.topico.log.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository ;
import org.springframework.data.mongodb.repository.Query;
import imd.topico.log.models.LogModels;

public interface LogRepository extends MongoRepository<LogModels, String> {

    @Query("{ timestamp : { $gte: ?0, $lte: ?1 } }")
    List<LogModels> findByTimestampBetween(String startDate, String endDate);
    
    @Query("{ 'level': ?0}")
    List<LogModels> findByLevelBetween(String level);
    
    @Query("{ 'microservice' : ?0}")
    List<LogModels> findByMicroserviceBetween(String microservice);
    
    @Query("{ 'thread' : ?0}")
    List<LogModels> findByThreadBetween(String thread);
    
    @Query("{ 'className' : ?0}")
    List<LogModels> findByClassNameBetween(String className);
    
    @Query("{ 'method' : ?0}")
    List<LogModels> findByMethodBetween(String method);

}
