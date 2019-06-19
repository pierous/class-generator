package es.pierous.generator.model;

import es.pierous.generator.enumerators.JavaTypeEnum;
import es.pierous.generator.enumerators.SQLServerTypeEnum;

public class Attribute extends Parseable {

	// ATTRIBUTES
	private String column;
	private String name;
	private SQLServerTypeEnum sqlServerType;
	private Integer size;
	private Boolean isId;
	private Boolean admitNull;
	
	// GETTERS & SETTERS
	
	public String getColumn() {
		return column;
	}
	
	public void setColumn(String column) {
		this.column = column;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public SQLServerTypeEnum getSqlServerType() {
		return sqlServerType;
	}
	
	public void setSqlServerType(SQLServerTypeEnum sqlServerType) {
		this.sqlServerType = sqlServerType;
	}
	
	public Integer getSize() {
		return size;
	}
	
	public void setSize(Integer size) {
		this.size = size;
	}

	public Boolean getIsId() {
		return isId;
	}

	public void setIsId(Boolean isId) {
		this.isId = isId;
	}

	public Boolean getAdmitNull() {
		return admitNull;
	}

	public void setAdmitNull(Boolean admitNull) {
		this.admitNull = admitNull;
	}
	
	// PUBLIC METHODS
	
	public String getSqlServerTypeValue() {
		return this.sqlServerType.getValue();
	}
	
	public String getJavaTypeValue() {
		return JavaTypeEnum.getEnumBySQL(this.sqlServerType).getValue();
	}
	
}
