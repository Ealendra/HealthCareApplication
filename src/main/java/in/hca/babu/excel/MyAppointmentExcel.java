package in.hca.babu.excel;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.hca.babu.entity.Appointment;
import in.hca.babu.entity.Doctor;

public class MyAppointmentExcel extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, 
			Workbook workbook,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		      response.addHeader("Content-Disposition", "attachment;filename=AppointDetails.xlsx");
		        @SuppressWarnings("unchecked")
				List<Appointment> list=(List<Appointment>)model.get("list");
		          Sheet sheet= workbook.createSheet("Appointment");
		           setHead(sheet);
		           setBody(sheet,list);
	}

	private void setBody(Sheet sheet, List<Appointment> list) {
		
		int rowNum=1;
		for(Appointment app:list)
		{
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(app.getId());
			row.createCell(1).setCellValue(app.getDate());
			row.createCell(2).setCellValue(app.getNoOfSlots());
			row.createCell(3).setCellValue(app.getNote());
			row.createCell(4).setCellValue(app.getConsultFee());
			//row.createCell(5).setCellValue(new Doctor());
		}
		
	}

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("Id");
		row.createCell(1).setCellValue("Date");
		row.createCell(2).setCellValue("No Of Slotes");
		row.createCell(3).setCellValue("Note");
		row.createCell(4).setCellValue("Consult Fees");
		//row.createCell(5).setCellValue("Doctor Name");
		
	}

}
