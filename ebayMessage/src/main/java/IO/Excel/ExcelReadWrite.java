package IO.Excel;

import org.apache.poi.ss.usermodel.Workbook;

public interface ExcelReadWrite {
	public Workbook Read(String fileName); // if failed, return null.
	public boolean Write(String fileName,Workbook wb);
}
