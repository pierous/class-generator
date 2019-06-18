package es.pierous.generator.parser.java.entity.attribute;

import es.pierous.generator.model.Attribute;
import es.pierous.generator.parser.GenericParserImpl;
import es.pierous.generator.utils.FileUtils;

public class HibernateAnnotationParserImpl extends GenericParserImpl<Attribute> {
	
	private static String TEMPLATE = "java/entity/attribute/hibernate.txt";
	
	private static String NAME = "${name}";
	private static String SIZE = "${size}";

	public String parse(Attribute attribute) {
		String template = FileUtils.readFile(TEMPLATE);
		
		return template.replace(NAME, attribute.getName()).replace(SIZE, attribute.getSize().toString()) + NL;
	}

}
