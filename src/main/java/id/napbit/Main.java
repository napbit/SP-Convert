package id.napbit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import id.napbit.model.Parameter;

public class Main {
	
	public static final int NO_FILE_PATH = 40;
	public static final int INVALID_FILE_PATH = 41;
	public static final int NON_TXT_FILE = 42;
	public static final int INTERNAL_ERROR = 50;
	
	public static void main(String[] args) {
		if (args.length <= 0) {
			System.out.println("No file path arguments passed.");
			System.exit(NO_FILE_PATH);
		}
		
		String pathToFileArg = args[0];
		
		try {
			if (!new File(pathToFileArg).exists()) {
				System.out.println("Invalid path as no file is found.");
				System.exit(INVALID_FILE_PATH);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(INTERNAL_ERROR);
		}
		
		readFile(pathToFileArg);
	}
	
	private static void readFile(String pathToFile) {
		if (!pathToFile.contains(".txt")) {
			System.out.println("File is a non-txt file.");
			System.exit(NON_TXT_FILE);
		}
		
		List<Parameter> parameterList = new ArrayList<Parameter>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
		    String line;
		    
		    while ((line = br.readLine()) != null) {
		    	String[] parameter = line.split(" ");
		    	
		    	if (parameter.length > 2) {
		    		parameterList.add(
		    				new Parameter()
		    				.withParameterName(parameter[0].trim())
		    				.withParameterDataType(parameter[1].trim())
		    				.withParameterType("OUT"));
		    	} else {
		    		parameterList.add(
		    				new Parameter()
		    				.withParameterName(parameter[0].trim())
		    				.withParameterDataType(parameter[1].trim())
		    				.withParameterType("IN"));
		    	}
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (Parameter parameter : parameterList) {
			System.out.println(parameter.getParameterName() + " " + parameter.getParameterDataType() + " " + parameter.getParameterType());
		}
		
		System.out.println("Total Size: " + parameterList.size());
	}

}
