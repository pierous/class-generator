package es.pierous.generator.parser.java.entity.attribute;

import es.pierous.generator.model.Attribute;
import es.pierous.generator.parser.GenericParserImpl;
import es.pierous.generator.utils.FileUtils;

public class HibernateAnnotationIdParserImpl extends GenericParserImpl<Attribute> {

	private static String TEMPLATE = "java/entity/attribute/id.txt";
	
	// CONSTRUCTOR
	
	public HibernateAnnotationIdParserImpl(Attribute item) {
		super(item);
	}

	// IMPLEMENTED METHODS
	
	public String parse() {
		return (item.getIsId()) ? FileUtils.readFile(TEMPLATE) + NL : "";
	}

}
