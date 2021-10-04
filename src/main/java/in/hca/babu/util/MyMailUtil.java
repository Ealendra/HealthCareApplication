package in.hca.babu.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MyMailUtil {
	
	@Autowired
	private JavaMailSender mailsender;
	
	public boolean send(
			String to[],
			String cc[],
			String bcc[],
			String subject,
			String text,
			Resource files[])
	{
		
		boolean sent=false;	
		try {
			//1.Create one Empty MimeMessage
		MimeMessage message = mailsender.createMimeMessage();
		//.2.fill details Message,attchmentExit.?
		MimeMessageHelper helper= new MimeMessageHelper(message, files!=null && files.length>0); 
	    //3.fill the Details(Message , Attachment EXit or not)
		helper.setTo(to);
		if(cc!=null)
		helper.setCc(cc);
		if(bcc!=null)
		helper.setBcc(bcc);
		helper.setSubject(subject);
		helper.setText(text);
		if(files!=null)
		{
			for(Resource rob:files)
			{
				helper.addAttachment(rob.getFilename(), rob);
			}
		}
		//3.send Mail
		mailsender.send(message);
		sent=true;
		
		}catch(Exception e)
		{
			e.printStackTrace();
			sent=false;
		}
		return sent;
		
	}
	
	//override the methods
	public boolean send(
			String to,		
			String text,
			String subject,
			Resource file)
	{
		return send(new String[] {to},null,null,
				subject,text,
				file!=null?new Resource[] {file}:null);
		
	}
	
	public boolean send(
			String to,String text,String subject)
	{
		return send(to,text,subject,null);
	}
	
}
