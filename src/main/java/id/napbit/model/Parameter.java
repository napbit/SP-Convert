package id.napbit.model;

public class Parameter {
	private String parameterName;
	private String parameterDataType;
	private String parameterType;
	
	public Parameter() {
		super();
	}

	public Parameter(String parameterName, String parameterDataType, String parameterType) {
		super();
		this.parameterName = parameterName;
		this.parameterDataType = parameterDataType;
		this.parameterType = parameterType;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterDataType() {
		return parameterDataType;
	}

	public void setParameterDataType(String parameterDataType) {
		this.parameterDataType = parameterDataType;
	}

	public String getParameterType() {
		return parameterType;
	}

	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}
	
	public Parameter withParameterName(String parameterName) {
		if (parameterName.contains("@")) {
			parameterName = parameterName.replace("@", "");
		}
		
		this.parameterName = parameterName;
		return this;
	}
	
	public Parameter withParameterDataType(String parameterDataType) {
		if (parameterDataType.contains(",")) {
			parameterDataType = parameterDataType.replace(",", "");
		}
		
		this.parameterDataType = parameterDataType;
		return this;
	}
	
	public Parameter withParameterType(String parameterType) {
		this.parameterType = parameterType;
		return this;
	}
}
