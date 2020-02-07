package id.napbit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import id.napbit.constant.Exit;
import id.napbit.constant.ParameterType;
import id.napbit.constant.Substitute;
import id.napbit.factory.Parameter;
import id.napbit.factory.ParameterMap;
import id.napbit.model.ParameterData;

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
		
		List<ParameterData> parameterList = readFile(pathToFileArg);
		
		if (parameterList.isEmpty()) {
			System.out.println(Exit.EMPTY_TXT_FILE_MESSAGE);
			System.exit(Exit.EMPTY_TXT_FILE_CODE);
		}
		
		if (writeFile(parameterList, pathToFileArg)) {
			System.out.println(Exit.SUCCESS_MESSAGE);
			System.exit(Exit.SUCCESS_CODE);
		} else {
			System.out.println(Exit.UNSUCCESSFUL_MESSAGE);
			System.exit(Exit.INTERNAL_ERROR_CODE);
		}
	}
	
	private static List<ParameterData> readFile(String pathToFile) {
		if (!pathToFile.contains(".txt")) {
			System.out.println(Exit.NON_TXT_FILE_MESSAGE);
			System.exit(Exit.NON_TXT_FILE_CODE);
		}
		
		List<ParameterData> parameterList = new ArrayList<ParameterData>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
		    String line;
		    
		    while ((line = br.readLine()) != null) {
		    	String[] parameter = line.split(" ");
		    	
	    		parameterList.add(
	    				new ParameterData()
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
	
	private static boolean writeFile(List<ParameterData> parameterList, String pathToFile) {
		Path file = Paths.get(pathToFile);
		
		try {
			Files.write(file, createLines(parameterList), StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println(Exit.INTERNAL_ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(Exit.INTERNAL_ERROR_CODE);
		}
		
		return Files.exists(file, LinkOption.NOFOLLOW_LINKS);
	}
	
	private static List<String> createLines(List<ParameterData> parameterList) {
		List<String> lines = new ArrayList<String>();

		for (ParameterData parameter : parameterList) {
			Parameter dataType = ParameterMap.getParameter(parameter.getParameterDataType());
			String line = dataType.getParameter(parameter.getParameterType());
			lines.add(line.replace(Substitute.SUBSTITUTE_STRING, String.valueOf(parameter.getParameterNo())));
		}
		
		return lines;
	}

}
