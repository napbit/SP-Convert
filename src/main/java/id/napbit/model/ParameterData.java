package id.napbit.model;

public class ParameterData {
	private int parameterNo;
	private String parameterName;
	private String parameterDataType;
	private String parameterType;
	
	public ParameterData() {
		super();
	}

	public ParameterData(int parameterNo, String parameterName, String parameterDataType, String parameterType) {
		super();
		this.parameterNo = parameterNo;
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
	
	public int getParameterNo() {
		return parameterNo;
	}

	public void setParameterNo(int parameterNo) {
		this.parameterNo = parameterNo;
	}

	public ParameterData withParameterNo(int parameterNo) {
		this.parameterNo = parameterNo;
		return this;
	}
	
	public ParameterData withParameterName(String parameterName) {
		if (parameterName.contains("@")) {
			parameterName = parameterName.replace("@", "");
		}
		
		this.parameterName = parameterName;
		return this;
	}
	
	public ParameterData withParameterDataType(String parameterDataType) {
		if (parameterDataType.contains(",")) {
			parameterDataType = parameterDataType.replace(",", "");
		}
		
		if (parameterDataType.contains("(") && parameterDataType.contains(")")) {
			parameterDataType = parameterDataType.substring(0, parameterDataType.indexOf("("));
		}
		
		this.parameterDataType = parameterDataType;
		return this;
	}
	
	public ParameterData withParameterType(String parameterType) {
		this.parameterType = parameterType;
		return this;
	}
}
