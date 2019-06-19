package es.pierous.generator.enumerators;

public enum JavaTypeEnum {
	
	BIGDECIMAL("java.math.BigDecimal"),
	BOOLEAN("Boolean"),
	DATE("java.sql.Date"),
	DOUBLE("Double"),
	FLOAT("Float"),
	INTEGER("Integer"),
	LONG("Long"),
	OBJECT("Object"),
	STRING("String"),
	TIME("java.sql.Time"),
	TIMESTAMP("java.sql.Timestamp");
	
	private String value;
	
	private JavaTypeEnum(String value){
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
	
	public static JavaTypeEnum getEnum(String value) {
		for(JavaTypeEnum item: JavaTypeEnum.values()){
			if (value.equals(item.value)) {
				return item;
			}
		}
		return null;
	}
	
	public static JavaTypeEnum getEnumBySQL(SQLServerTypeEnum sqlType) {
		
		switch (sqlType) {
			case VARCHAR:
			case NVARCHAR:
			case CHAR:
				return STRING;
			case DECIMAL:
			case FLOAT:
			case MONEY:
				return BIGDECIMAL;
			case BIT:
				return BOOLEAN;
			case INT:
				return INTEGER;
			case DATE:
				return DATE;
			case TIME:
				return TIME;
			case DATETIME:
				return TIMESTAMP;
			default:
				return OBJECT;
		}
		
	}


}
