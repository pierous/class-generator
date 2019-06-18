package es.pierous.generator.model;

import java.util.ArrayList;
import java.util.List;

public class Table extends Parseable {
	
	// ATTRIBUTES
	private String name;
	private List<Attribute> attributes;
	
	// CONSTRUCTOR
	public Table() {
		this.attributes = new ArrayList<Attribute>();
	}
	
	// GETTERS & SETTERS

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
	
	

}
