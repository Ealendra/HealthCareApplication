package in.hca.babu.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxStreamingView;

import in.hca.babu.entity.Doctor;

public class DoctorExcelExport extends AbstractXlsxStreamingView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) 
					throws Exception {
		
		
	response.addHeader("contect-Disposition", "attachment;filename=Doctor.xlsx");
	     @SuppressWarnings("unchecked")
		List<Doctor> list=(List<Doctor>)model.get("list");
	        Sheet sheet= workbook.createSheet("Doctor");
	     setHead(sheet);
	     
	     setBody(sheet,list);
	            
		
	}

	private void setBody(Sheet sheet, List<Doctor> list) {
		
		int rowNum=1;
		for(Doctor doctor:list)
		{
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(doctor.getId());
			row.createCell(1).setCellValue(doctor.getFirstName());
			row.createCell(2).setCellValue(doctor.getLastName());
			row.createCell(3).setCellValue(doctor.getEmail());
			row.createCell(4).setCellValue(doctor.getAddress());
			row.createCell(5).setCellValue(doctor.getMobile());
			row.createCell(6).setCellValue(doctor.getGender());
			row.createCell(7).setCellValue(doctor.getNote());
		}
		
	}

	private void setHead(Sheet sheet) {
		
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("First Name");
		row.createCell(2).setCellValue("Last Name");
		row.createCell(3).setCellValue("Email Id");
		row.createCell(4).setCellValue("Address");
		row.createCell(5).setCellValue("Mobile");
		row.createCell(6).setCellValue("Gender");
		row.createCell(7).setCellValue("Note");
	}
	
	
	

}
