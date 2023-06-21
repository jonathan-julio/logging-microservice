package imd.topico.log.services;
import imd.topico.log.models.LogModels;
import java.util.List;

public interface logServices {
    void save(LogModels logModels);
    List<LogModels> findByTimestampBetween(String startDate, String endDate);
    List<LogModels> findByLevelBetween(String level, String startDate, String endDate);
    List<LogModels> findByMicroserviceBetween(String microservice, String startDate, String endDate);
    List<LogModels> findByThreadBetween(String thread, String startDate, String endDate);
    List<LogModels> findByClassNameBetween(String className, String startDate, String endDate);
    List<LogModels> findByMethodBetween(String method, String startDate, String endDate);
}
