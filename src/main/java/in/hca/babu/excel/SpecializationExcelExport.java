package in.hca.babu.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.hca.babu.entity.Specialization;


public class SpecializationExcelExport extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.addHeader("content-Disposition", "attachment;filename=SPECIAL.xlsx");
		
		@SuppressWarnings("unchecked")
		List<Specialization> list=(List<Specialization>)model.get("list");
		
		          Sheet sheet=workbook.createSheet("SPECIALIZATION");
		          setHead(sheet);
		          setBody( sheet,list);
		               
		
		
		
	
	}

	private void setHead(Sheet sheet) {
		
		             Row row=sheet.createRow(0);
		             row.createCell(0).setCellValue("ID");
		             row.createCell(1).setCellValue("CODE");
		             row.createCell(2).setCellValue("NAME");
		             row.createCell(3).setCellValue("NOTE");
		
		
	}


private void setBody(Sheet sheet, List<Specialization> list) {
	int rowNum=1;
	for(Specialization special : list)
	{
		Row row=sheet.createRow(rowNum++);
		row.createCell(0).setCellValue(special.getId());
		row.createCell(1).setCellValue(special.getCode());
		row.createCell(2).setCellValue(special.getName());
		row.createCell(3).setCellValue(special.getNote());
		
	}
	
	
	
}


}
