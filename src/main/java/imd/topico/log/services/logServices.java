package imd.topico.log.services;
import imd.topico.log.models.LogModels;
import java.util.List;

public interface logServices {
    void save(LogModels logModels);
    List<LogModels> findByTimestampBetween(String startDate, String endDate);
    List<LogModels> findByLevelBetween(String level);
    List<LogModels> findByMicroserviceBetween(String microservice);
    List<LogModels> findByThreadBetween(String thread);
    List<LogModels> findByClassNameBetween(String className);
    List<LogModels> findByMethodBetween(String method);
    boolean testDatabaseConnection();
}
