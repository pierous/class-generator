package es.pierous.generator.parser.java.entity.attribute;

import es.pierous.generator.model.Attribute;
import es.pierous.generator.parser.GenericParserImpl;
import es.pierous.generator.utils.FileUtils;

public class AttributeDeclarationParserImpl extends GenericParserImpl<Attribute> {

	private static String TEMPLATE = "java/entity/attribute/declaration.txt";
	
	private static String TYPE = "${type}";
	private static String NAME = "${name}";
	
	// CONSTRUCTOR
	
	public AttributeDeclarationParserImpl(Attribute item) {
		super(item);
	}
	
	// IMPLEMENTED METHODS
	
	public String parse() {
		String template = FileUtils.readFile(TEMPLATE);
		
		return template.replace(TYPE, this.item.getJavaTypeValue()).replace(NAME, this.item.getName()) + NL;
	}

}
