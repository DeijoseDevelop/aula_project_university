package src.utils;

import java.util.*;

import com.aspose.cells.*;

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
                Cell cell = this.cells.get(i, j);
                String value = cell.getStringValue();

                if (this.cells.get(i, j).getType() == CellValueType.IS_NUMERIC) {
                    value = Long.toString((long) cell.getDoubleValue());
                }

                obj.put(
                    this.headers.get(j),
                    value
                );
            }
            data.add(obj);
        }
        return data;
    }
}
