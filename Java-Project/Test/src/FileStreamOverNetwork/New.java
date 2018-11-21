package FileStreamOverNetwork;

import java.io.File;

public class New {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		File dir = new File("src");
		File[] dirlist = dir.listFiles();
		
		
		for(int a =0 ; a<dirlist.length ; a++) {
			
			File nm = dirlist[a];
			String name = nm.getName();
			System.out.println(name);
		}
		
	}

}
