package src.utils;

import java.util.*;

import src.interfaces.ExcelFile;

public class ExcelReader extends ExcelFile {
    private List<Map<String, String>> jsonData;

    public ExcelReader(String filePath) {
        super(filePath);
        this.jsonData = this.toJson();
    }

    public ExcelReader(String filePath, int worksheetIndex) {
        super(filePath, worksheetIndex);
        this.jsonData = this.toJson();
    }

    public List<Map<String, String>> getJsonData() {
        return this.jsonData;
    }

    public List<Map<String, String>> toJson() {
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        for (int i = 1; i <= this.getCantRows(); i++) {
            Map<String, String> obj = new TreeMap<String, String>();
            for (int j = 0; j <= this.getCantColumns(); j++) {
                obj.put(
                    this.getHeaders().get(j),
                    this.cells.get(i, j).getStringValue()
                );
            }
            data.add(obj);
        }
        return data;
    }
}
