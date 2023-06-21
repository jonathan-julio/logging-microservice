package imd.topico.log.models;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class LogModels {
    @Id
    private String id;
    private String timestamp;
    private String level;
    private String microservice;
    private String thread;
    @JsonProperty("class")
    private String className;
    private String method;
    private String message;
    private String context;
    private String ip;

    // Construtor
    public LogModels(String id, String timestamp, String level, String microservice, String thread, String className,
                    String method, String message, String context, String ip) {
        this.id = id;
        this.timestamp = timestamp;
        this.level = level;
        this.microservice = microservice;
        this.thread = thread;
        this.className = className;
        this.method = method;
        this.message = message;
        this.context = context;
        this.ip = ip;
    }

    public LogModels(String timestamp, String level, String microservice, String thread, String className,
                    String method, String message, String context, String ip) {
        this.timestamp = timestamp;
        this.level = level;
        this.microservice = microservice;
        this.thread = thread;
        this.className = className;
        this.method = method;
        this.message = message;
        this.context = context;
        this.ip = ip;
    }

    // Getters e Setters

    public LogModels() {
    }
    
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMicroservice() {
        return microservice;
    }

    public void setMicroservice(String microservice) {
        this.microservice = microservice;
    }

    public String getThread() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread = thread;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getParsedTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss.SSS");
        try {
            return dateFormat.parse(timestamp);
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Ou trate o erro de acordo com sua necessidade
        }
    }
}
