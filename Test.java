import com.aspose.cells.Cell;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;

public class Test {
    public static void main(String[] args) throws Exception {
        // Load Excel file
        Workbook wb = new Workbook("workbook.xlsx");

        // Get all worksheets
        WorksheetCollection collection = wb.getWorksheets();
        System.out.println(collection.getCount());

        // Loop through all the worksheets
        for (int worksheetIndex = 0; worksheetIndex < collection.getCount(); worksheetIndex++) {

            // Get worksheet using its index
            Worksheet worksheet = collection.get(worksheetIndex);

            // Print worksheet name
            System.out.println("Worksheet: " + worksheet.getName());

            // Get number of rows and columns
            int rows = worksheet.getCells().getMaxDataRow();
            int cols = worksheet.getCells().getMaxDataColumn();
            System.out.println(worksheet.getCells().get(0, 0));
            System.out.println(worksheet.getCells().getMaxDataRow());
            System.out.println(worksheet.getCells().getMaxDataColumn());

            // Loop through rows
            for (int i = 0; i < rows; i++) {

                // Loop through each column in selected row
                for (int j = 0; j < cols; j++) {
                    // Pring cell value
                    Cell cell = worksheet.getCells().get(i, j);
                    // System.out.println(cell.getName());
                    System.out.print(cell.getValue() + " | ");
                }
                // Print line break
                System.out.println(" ");
            }
        }
    }
    
}
