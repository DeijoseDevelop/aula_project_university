package src.interfaces;

import java.util.*;
import com.aspose.cells.*;

public class ExcelFile {
    protected Workbook workbook;
    protected WorksheetCollection collection;
    protected Worksheet worksheet;
    protected Cells cells;
    protected List<String> headers;

    public ExcelFile(String filePath) {
        try {
            this.workbook = new Workbook(filePath);
            this.collection = this.workbook.getWorksheets();
            this.worksheet = this.collection.get(0);
            this.cells = this.worksheet.getCells();
            this.headers = this.setHeaders();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ExcelFile(String filePath, int worksheetIndex) {
        try {
            this.workbook = new Workbook(filePath);
            this.collection = this.workbook.getWorksheets();
            this.worksheet = this.collection.get(worksheetIndex);
            this.cells = this.worksheet.getCells();
            this.headers = this.setHeaders();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected List<String> setHeaders() {
        List<String> headers = new ArrayList<String>();
        for (int i = 0; i <= this.getCantColumns(); i++) {
            headers.add(this.cells.get(0, i).getStringValue());
        }
        return headers;
    }

    public List<String> getHeaders() {
        return this.headers;
    }

    public int getCantRows() {
        return this.cells.getMaxDataRow();
    }

    public int getCantColumns() {
        return this.cells.getMaxDataColumn();
    }
}
