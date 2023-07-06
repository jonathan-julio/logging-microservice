package imd.topico.log.controller;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import imd.topico.log.models.LogModels;
import imd.topico.log.services.LogServivesImpl;

@RestController
@RequestMapping("/api/logs")
public class logController {

    @Autowired
    private LogServivesImpl logServivesImpl;

    private ResponseEntity<?> authenticateUser(String user, String password) {
        if (!"root".equals(user) || !"password_123".equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonList("Falha na autenticação"));
        }
        return null; 
    }

    @GetMapping("/timestamp/{startDate}/{endDate}")
    public ResponseEntity<?> getByTimestampRange(
            @RequestParam("user") String user,
            @RequestParam("password") String password,
            @PathVariable String startDate,
            @PathVariable String endDate) {

        ResponseEntity<?> authenticationResult = authenticateUser(user, password);
        if (authenticationResult != null) {
            return authenticationResult;
        }

        List<LogModels> logs = logServivesImpl.findByTimestampBetween(startDate, endDate);
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/level/{level}")
    public ResponseEntity<?> getByLevelRange(
            @RequestParam("user") String user,
            @RequestParam("password") String password,
            @PathVariable String level) {

        ResponseEntity<?> authenticationResult = authenticateUser(user, password);
        if (authenticationResult != null) {
            return authenticationResult;
        }

        List<LogModels> logs = logServivesImpl.findByLevelBetween(level);
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/microservice/{microservice}")
    public ResponseEntity<?> getByMicroserviceRange(
            @RequestParam("user") String user,
            @RequestParam("password") String password,
            @PathVariable String microservice) {

        ResponseEntity<?> authenticationResult = authenticateUser(user, password);
        if (authenticationResult != null) {
            return authenticationResult;
        }

        List<LogModels> logs = logServivesImpl.findByMicroserviceBetween(microservice);
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/thread/{thread}")
    public ResponseEntity<?> getByThreadRange(
            @RequestParam("user") String user,
            @RequestParam("password") String password,
            @PathVariable String thread) {

        ResponseEntity<?> authenticationResult = authenticateUser(user, password);
        if (authenticationResult != null) {
            return authenticationResult;
        }

        List<LogModels> logs = logServivesImpl.findByThreadBetween(thread);
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/className/{className}")
    public ResponseEntity<?> getByClassNameRange(
            @RequestParam("user") String user,
            @RequestParam("password") String password,
            @PathVariable String className) {

        ResponseEntity<?> authenticationResult = authenticateUser(user, password);
        if (authenticationResult != null) {
            return authenticationResult;
        }

        List<LogModels> logs = logServivesImpl.findByClassNameBetween(className);
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/method/{method}")
    public ResponseEntity<?> getByMethodRange(
            @RequestParam("user") String user,
            @RequestParam("password") String password,
            @PathVariable String method) {

        ResponseEntity<?> authenticationResult = authenticateUser(user, password);
        if (authenticationResult != null) {
            return authenticationResult;
        }

        List<LogModels> logs = logServivesImpl.findByMethodBetween(method);
        return ResponseEntity.ok(logs);
    }
}
