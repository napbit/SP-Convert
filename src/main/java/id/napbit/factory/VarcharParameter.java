package id.napbit.factory;

import java.util.HashMap;
import java.util.Map;

import id.napbit.constant.ParameterType;
import id.napbit.constant.Substitute;

public class VarcharParameter implements Parameter{
	private Map<String, String> parameterMap;
	
	public VarcharParameter() {
		parameterMap = new HashMap<String, String>();
		parameterMap.put(ParameterType.IN_PARAMETER, "cs.setString(" + Substitute.SUBSTITUTE_STRING + ", \"\");");
		parameterMap.put(ParameterType.OUT_PARAMETER, "cs.registerOutParameter(" + Substitute.SUBSTITUTE_STRING + ", Types.VARCHAR);");
	}

	@Override
	public String getParameter(String parameterType) {
		return parameterMap.getOrDefault(parameterType, "NOT FOUND");
	}
}
