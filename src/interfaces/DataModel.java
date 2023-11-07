package src.interfaces;

import java.util.*;

import src.utils.DataFilter;


public interface DataModel {

    public int getId();

    public static DataModel fromJson(
        Map<String, String> json,
        DataFilter dataFilter
    ) {
        return null;
    }

    public static List<DataModel> fromJsonList(
        List<Map<String, String>> jsonList,
        DataFilter dataFilter
    ) {
        return null;
    }

    public Map<String, String> toJson();
}
