package in.hca.babu.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.hca.babu.entity.Patient;

public class PatientExcelExport extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, 
			Workbook workbook, HttpServletRequest 
			request,
			HttpServletResponse response) 
					throws Exception {
 response.addHeader("content-Disposition","attachment;filename=PatientDetails.xlsx");
 
    @SuppressWarnings("unchecked")
	List<Patient> list=(List<Patient>)model.get("list");
          Sheet sheet=workbook.createSheet("PatientDetails");
          setHead(sheet);
          
          setBody(sheet,list);
		
	}

	private void setBody(Sheet sheet, List<Patient> list) {
		int rowNum=1;
		for(Patient patient:list)
		{
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(patient.getId());
			row.createCell(1).setCellValue(patient.getFirstName());
			row.createCell(2).setCellValue(patient.getLastName());
			row.createCell(3).setCellValue(patient.getGender());
			row.createCell(4).setCellValue(patient.getMarialStatus());
			row.createCell(5).setCellValue(patient.getPrasentAddr());
			row.createCell(6).setCellValue(patient.getCommanAddr());
			row.createCell(7).setCellValue(patient.getNote());
			
		}
           
		
	}

	private void setHead(Sheet sheet) {

		     Row row=sheet.createRow(0);
		     row.createCell(0).setCellValue("ID");
		     row.createCell(1).setCellValue("FirstName");
		     row.createCell(2).setCellValue("Last Name");
		     row.createCell(3).setCellValue("Gender");
		     row.createCell(4).setCellValue("Marrial Status");
		     row.createCell(5).setCellValue("Prasent Address");
		     row.createCell(6).setCellValue("Communication Address");
		     row.createCell(7).setCellValue("Note");
		
	}

}
