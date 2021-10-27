package in.hca.babu;

import java.util.UUID;

public class Test {
	
	public static void main(String[] args)
	{
		   String pwd=UUID.randomUUID().
				   toString().
				   replace("-", "").
				    substring(0,8);
		   
		   System.out.println(pwd);
	}
		
	

}
