package src.interfaces;

import java.util.*;
import com.aspose.cells.*;

public class ExcelFile {
    protected String filePath;
    protected Workbook workbook;
    protected WorksheetCollection collection;
    protected Worksheet worksheet;
    protected Cells cells;
    protected Map<Integer, String> headers;
    protected Map<String, Integer> reversedHeaders;

    public ExcelFile(String filePath) {
        try {
            this.filePath = filePath;
            this.workbook = new Workbook(filePath);
            this.collection = this.workbook.getWorksheets();
            this.worksheet = this.collection.get(0);
            this.cells = this.worksheet.getCells();
            this.headers = this.setHeaders();
            this.reversedHeaders = this.setReversedHeaders();
            this.deleteAdditionalWorksheets();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ExcelFile(String filePath, int worksheetIndex) {
        try {
            this.filePath = filePath;
            this.workbook = new Workbook(filePath);
            this.collection = this.workbook.getWorksheets();
            this.worksheet = this.collection.get(worksheetIndex);
            this.cells = this.worksheet.getCells();
            this.headers = this.setHeaders();
            this.deleteAdditionalWorksheets();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected Map<Integer, String> setHeaders() {
        Map<Integer, String> headers = new TreeMap<Integer, String>();
        for (int i = 0; i <= this.getCantColumns(); i++) {
            headers.put(i, this.cells.get(0, i).getStringValue());
        }
        return headers;
    }

    protected Map<String, Integer> setReversedHeaders() {
        Map<String, Integer> headers = new TreeMap<String, Integer>();
        for (int i = 0; i <= this.getCantColumns(); i++) {
            headers.put(this.cells.get(0, i).getStringValue(), i);
        }
        return headers;
    }

    public Map<Integer, String> getHeaders() {
        return this.headers;
    }

    public Map<String, Integer> getReversedHeaders() {
        return reversedHeaders;
    }

    public int getCantRows() {
        return this.cells.getMaxDataRow();
    }

    public int getCantColumns() {
        return this.cells.getMaxDataColumn();
    }

    protected void deleteAdditionalWorksheets() {
        for (int i = 1; i < this.workbook.getWorksheets().getCount(); i++) {
            workbook.getWorksheets().removeAt(i);
        }
    }
}
