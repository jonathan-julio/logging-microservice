package imd.topico.log.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import imd.topico.log.models.LogModels;

public class Utils {
    public static void writeToFile(LogModels logModel) {
        try {
            File file = new File("logs.txt");
            FileWriter writer = new FileWriter(file, true); 
            writer.write(logModelToJson(logModel));
            writer.write(System.lineSeparator()); 
            writer.close();
            System.out.println("Added log to file: " + logModel.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void processPendingLogs(LogServivesImpl logServivesImpl) {
        File file = new File("logs.txt");
        if (file.exists()) {
            List<LogModels> logsToSave = readLogsFromFile(file);
            for (LogModels logModel : logsToSave) {
                logServivesImpl.save(logModel);
                System.out.println("Save logRepository: " + logModel.toString());
            }
            file.delete();
        }
    }

    public static List<LogModels> readLogsFromFile(File file) {
        List<LogModels> logs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                LogModels logModel = convertToLogModel(line);
                if (logModel != null) {
                    logs.add(logModel);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logs;
    }

    public static LogModels convertToLogModel(String line) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(line, LogModels.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String logModelToJson(LogModels logModel) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(logModel);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
