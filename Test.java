import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;

public class Test {
    public static void main(String[] args) throws Exception {
        // Load Excel file
        Workbook wb = new Workbook("workbook.xlsx");

        // Get all worksheets
        WorksheetCollection collection = wb.getWorksheets();

        // Loop through all the worksheets
        for (int worksheetIndex = 0; worksheetIndex < collection.getCount(); worksheetIndex++) {

        // Get worksheet using its index
        Worksheet worksheet = collection.get(worksheetIndex);

        // Print worksheet name
        System.out.print("Worksheet: " + worksheet.getName());

        // Get number of rows and columns
        int rows = worksheet.getCells().getMaxDataRow();
        int cols = worksheet.getCells().getMaxDataColumn();

        // Loop through rows
        for (int i = 0; i < rows; i++) {

            // Loop through each column in selected row
            for (int j = 0; j < cols; j++) {
                // Pring cell value
            System.out.print(worksheet.getCells().get(i, j).getValue() + " | ");
            }
            // Print line break
            System.out.println(" ");
        }
        }
    }
}
