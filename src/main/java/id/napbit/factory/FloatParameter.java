package id.napbit.factory;

import java.util.HashMap;
import java.util.Map;

import id.napbit.constant.ParameterType;
import id.napbit.constant.Substitute;

public class FloatParameter implements Parameter{
	
	private Map<String, String> parameterMap;
	
	public FloatParameter() {
		parameterMap = new HashMap<String, String>();
		parameterMap.put(ParameterType.IN_PARAMETER, "cs.setFloat(" + Substitute.SUBSTITUTE_STRING + ", 0.00);");
		parameterMap.put(ParameterType.OUT_PARAMETER, "cs.registerOutParameter(" + Substitute.SUBSTITUTE_STRING + ", Types.FLOAT);");
	}
	
	@Override
	public String getParameter(String parameterType) {
		return parameterMap.get(parameterType);
	}
}
