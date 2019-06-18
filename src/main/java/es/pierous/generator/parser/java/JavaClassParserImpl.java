package es.pierous.generator.parser.java;

import java.util.List;

import es.pierous.generator.model.Attribute;
import es.pierous.generator.model.Table;
import es.pierous.generator.parser.GenericParserImpl;
import es.pierous.generator.parser.java.entity.AttributeJavaParserImpl;
import es.pierous.generator.utils.FileUtils;

public class JavaClassParserImpl extends GenericParserImpl<Table> {
	
	private static String TEMPLATE = "java/class.txt";
	
	private static String NAME = "${name}";
	private static String ATTRIBUTES = "${attributes}";

	public String parse(Table table) {
		String template = FileUtils.readFile(TEMPLATE);
		
		String attributes = this.parseAttributes(table.getAttributes());
		
		String result = template.replace(NAME, table.getName()).replace(ATTRIBUTES, attributes);
		
		return result;
	}
	
	private String parseAttributes(List<Attribute> attributes) {
		AttributeJavaParserImpl attrParser = new AttributeJavaParserImpl();
		
		String result = "";
		for (Attribute attribute : attributes) {
			result += attrParser.parse(attribute) + NL;
		}
		
		return result;
	}

}
