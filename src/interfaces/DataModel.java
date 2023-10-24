package src.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import src.models.Student;

public interface DataModel {
    public static DataModel fromJson(Map<String, String> json) {
        return null;
    }

    public static List<DataModel> fromJsonList(List<Map<String, String>> jsonList) {
        List<DataModel> objModels = new ArrayList<DataModel>();
        for (Map<String, String> json : jsonList) {
            objModels.add(Student.fromJson(json));
        }
        return objModels;
    }
}
