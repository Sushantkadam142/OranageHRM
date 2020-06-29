package HRM;

import java.io.File;

public class testpath {

	public static void main(String[] args) 
	{
	System.out.println(new File(System.getProperty("user.dir")).getAbsolutePath());

	}

}
