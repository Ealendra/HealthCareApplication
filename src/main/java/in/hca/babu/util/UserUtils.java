package in.hca.babu.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class UserUtils {
	
	public String genPwd()
	{
		return UUID.randomUUID().toString().replace("-", "").substring(0,8);
	}

}
