package Models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadTXT {

	public ArrayList<String> readTXT(String fileAdress)
	{
		ArrayList<String> arrayList=new ArrayList<String>();
		
		try {
			BufferedReader br= new BufferedReader(new FileReader(fileAdress));
			String data = br.readLine();
			while(data!=null)
			{
				String[] dataArray=data.split(" "); //split the string to array
				for(int i=0; i<dataArray.length;i++) //loop to get data from dataArray
				{
					arrayList.add(dataArray[i]); //add string 
				}
				data = br.readLine(); //try to read next line
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arrayList;
	}
}
