package es.pierous.generator.enumerators;

public enum SQLServerTypeEnum {
	
	BIT("bit"),
	CHAR("char"),
	DATE("date"),
	DATETIME("datetime"),
	DECIMAL("decimal"),
	FLOAT("float"),
	INT("int"),
	MONEY("money"),
	NVARCHAR("nvarchar"),
	TIME("time"),
	VARCHAR("varchar");
	
	private String value;
	
	private SQLServerTypeEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static SQLServerTypeEnum getEnum(String value) {
		for(SQLServerTypeEnum item: SQLServerTypeEnum.values()){
			if (value.equals(item.value)) {
				return item;
			}
		}
		return null;
	}

}
