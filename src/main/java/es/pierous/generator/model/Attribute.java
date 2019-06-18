package es.pierous.generator.model;

public class Attribute extends Parseable {

	// ATTRIBUTES
	private String column;
	private String name;
	private String type;
	private Integer size;
	
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
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Integer getSize() {
		return size;
	}
	
	public void setSize(Integer size) {
		this.size = size;
	}
	
}
