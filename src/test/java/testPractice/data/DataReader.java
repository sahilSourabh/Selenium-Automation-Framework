package testPractice.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String,String>> getJsonDataToMap() throws IOException
	{
		
		File file = new File(
				System.getProperty("user.dir") + "\\src\\test\\java\\testPractice\\data\\PurchaseOrder.json");
		//json to String
		String jsonContent = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		
		//String to HashMap
		ObjectMapper map = new ObjectMapper();
		List<HashMap<String, String>> data = 
				map.readValue(jsonContent,new TypeReference<List<HashMap<String, String>>>() {
				});
		
		return data;
	}

}
