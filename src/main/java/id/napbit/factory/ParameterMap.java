package id.napbit.factory;

import java.util.HashMap;
import java.util.Map;

import id.napbit.constant.ParameterDataType;

public class ParameterMap {
	private static final Map<String, Parameter> parameterMap = new HashMap<String, Parameter>();
	
	static {
		parameterMap.put(ParameterDataType.INTEGER, new IntegerParameter());
		parameterMap.put(ParameterDataType.VARCHAR, new VarcharParameter());
		parameterMap.put(ParameterDataType.DATE, new DateParameter());
		parameterMap.put(ParameterDataType.DATETIME, new DateTimeParameter());
	}
	
	public static Parameter getParameter(String parameterDataType) {
		return parameterMap.get(parameterDataType);
	}
}
