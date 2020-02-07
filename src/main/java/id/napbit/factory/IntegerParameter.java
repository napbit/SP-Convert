package id.napbit.factory;

import java.util.HashMap;
import java.util.Map;

import id.napbit.constant.ParameterType;
import id.napbit.constant.Substitute;

public class IntegerParameter implements Parameter{
	private Map<String, String> parameterMap;
	
	public IntegerParameter() {
		parameterMap = new HashMap<String, String>();
		parameterMap.put(ParameterType.IN_PARAMETER, "cs.setInt(" + Substitute.SUBSTITUTE_STRING + ", 0);");
		parameterMap.put(ParameterType.OUT_PARAMETER, "cs.registerOutParameter(" + Substitute.SUBSTITUTE_STRING + ", Types.INTEGER);");
	}

	@Override
	public String getParameter(String parameterType) {
		return parameterMap.getOrDefault(parameterType, "NOT FOUND");
	}
}
