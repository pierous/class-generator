package es.pierous.generator.parser.java.entity.attribute;

import es.pierous.generator.model.Attribute;
import es.pierous.generator.parser.GenericParserImpl;
import es.pierous.generator.utils.FileUtils;

public class HibernateAnnotationParserImpl extends GenericParserImpl<Attribute> {

	private static String TEMPLATE = "java/entity/attribute/hibernate.txt";
	
	private static String NAME = "${name}";
	private static String SIZE = "${size}";
	private static String NULLABLE = "${nullable}";
	
	// CONSTRUCTOR
	
	public HibernateAnnotationParserImpl(Attribute item) {
		super(item);
	}

	// IMPLEMENTED METHODS
	
	public String parse() {
		String template = FileUtils.readFile(TEMPLATE);
		String nullable = (this.item.getAdmitNull())? "true" : "false";
		
		return template
				.replace(NAME, this.item.getColumn())
				.replace(SIZE, this.item.getSize().toString())
				.replace(NULLABLE, nullable) + NL;
	}

}
