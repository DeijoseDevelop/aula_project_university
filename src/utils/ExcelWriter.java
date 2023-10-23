package src.utils;

import java.util.Map;

import com.aspose.cells.*;

import src.interfaces.ExcelFile;

public class ExcelWriter extends ExcelFile {

    public ExcelWriter(String filePath) {
        super(filePath);
    }

    public ExcelWriter(String filePath, int worksheetIndex) {
        super(filePath, worksheetIndex);
    }

    public void writeData(Map<String, String> obj) {
        int maxRow = this.getCantRows() + 1;
        for (int i = 0; i < this.headers.size(); i++) {
            Cell cell = this.cells.get(maxRow, i);
            String header = this.headers.get(i);

            cell.setValue(obj.get(header).toString());
        }

        this.saveWorkbook();
    }

    private void saveWorkbook() {
        try {
            this.workbook.save(this.filePath);
            this.deleteAdditionalWorksheets();
            this.deleteAdditionalWorksheets();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
