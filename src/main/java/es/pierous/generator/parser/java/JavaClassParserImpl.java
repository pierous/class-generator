package es.pierous.generator.parser.java;

import java.util.List;

import es.pierous.generator.model.Attribute;
import es.pierous.generator.model.Table;
import es.pierous.generator.parser.GenericParserImpl;
import es.pierous.generator.parser.java.entity.AttributeJavaParserImpl;
import es.pierous.generator.utils.FileUtils;

public class JavaClassParserImpl extends GenericParserImpl<Table> {

	private static String TEMPLATE = "java/class.txt";
	
	private static String TABLE = "${table}";
	private static String NAME = "${name}";
	private static String ATTRIBUTES = "${attributes}";
	
	// CONSTRUCTOR
	
	public JavaClassParserImpl(Table item) {
		super(item);
	}

	// IMPLEMENTED METHODS
	
	public String parse() {
		String template = FileUtils.readFile(TEMPLATE);
		
		String attributes = this.parseAttributes(this.item.getAttributes());
		
		String result = template.replace(TABLE, this.item.getName())
				.replace(NAME, this.item.getName())
				.replace(ATTRIBUTES, attributes);
		
		return result;
	}
	
	// PRIVATE METHODS
	
	private String parseAttributes(List<Attribute> attributes) {
		
		String result = "";
		for (Attribute attribute : attributes) {
			AttributeJavaParserImpl attrParser = new AttributeJavaParserImpl(attribute);
			result += attrParser.parse() + NL;
		}
		
		return result;
	}

}
