package id.napbit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import id.napbit.constant.Exit;
import id.napbit.constant.ParameterType;
import id.napbit.model.Parameter;

public class Main {
	
	public static void main(String[] args) {
		if (args.length <= 0) {
			System.out.println(Exit.NO_FILE_PATH_MESSAGE);
			System.exit(Exit.NO_FILE_PATH_CODE);
		}
		
		String pathToFileArg = args[0];
		
		try {
			if (!new File(pathToFileArg).exists()) {
				System.out.println(Exit.INVALID_FILE_PATH_MESSAGE);
				System.exit(Exit.INVALID_FILE_PATH_CODE);
			}
		} catch (Exception e) {
			System.out.println(Exit.INTERNAL_ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(Exit.INTERNAL_ERROR_CODE);
		}
		
		readFile(pathToFileArg);
	}
	
	private static List<Parameter> readFile(String pathToFile) {
		if (!pathToFile.contains(".txt")) {
			System.out.println(Exit.NON_TXT_FILE_MESSAGE);
			System.exit(Exit.NON_TXT_FILE_CODE);
		}
		
		List<Parameter> parameterList = new ArrayList<Parameter>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
		    String line;
		    
		    while ((line = br.readLine()) != null) {
		    	String[] parameter = line.split(" ");
		    	
	    		parameterList.add(
	    				new Parameter()
	    				.withParameterNo(parameterList.size()+1)
	    				.withParameterName(parameter[0].trim())
	    				.withParameterDataType(parameter[1].trim())
	    				.withParameterType(parameter.length > 2 ? ParameterType.OUT_PARAMETER : ParameterType.IN_PARAMETER));
		    }
		} catch (IOException e) {
			System.out.println(Exit.INTERNAL_ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(Exit.INTERNAL_ERROR_CODE);
		}
		
		return parameterList;
	}
	
	private static void writeFile(List<Parameter> parameterList, String pathToFile) {
		List<String> lines = new ArrayList<String>();

		for (Parameter parameter : parameterList) {
			
		}
	}

}
