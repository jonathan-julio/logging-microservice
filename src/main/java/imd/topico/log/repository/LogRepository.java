package imd.topico.log.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository ;
import org.springframework.data.mongodb.repository.Query;

import imd.topico.log.models.LogModels;

public interface LogRepository extends MongoRepository<LogModels, String> {

    @Query("{ timestamp : { $gte: ?0, $lte: ?1 } }")
    List<LogModels> findByTimestampBetween(String startDate, String endDate);
    
    @Query("{ 'level': ?0, 'timestamp': { $gte: ?1, $lte: ?2 } }")
    List<LogModels> findByLevelBetween(String level,String startDate, String endDate);
    
    @Query("{ 'microservice' : ?0, 'timestamp': { $gte: ?1, $lte: ?2 } }")
    List<LogModels> findByMicroserviceBetween(String microservice,String startDate, String endDate);
    
    @Query("{ 'thread' : ?0, 'timestamp': { $gte: ?1, $lte: ?2 } }")
    List<LogModels> findByThreadBetween(String thread,String startDate, String endDate);
    
    @Query("{ 'className' : ?0, 'timestamp': { $gte: ?1, $lte: ?2 } }")
    List<LogModels> findByClassNameBetween(String className,String startDate, String endDate);
    
    @Query("{ 'method' : ?0, 'timestamp': { $gte: ?1, $lte: ?2 } }")
    List<LogModels> findByMethodBetween(String method,String startDate, String endDate);

}
