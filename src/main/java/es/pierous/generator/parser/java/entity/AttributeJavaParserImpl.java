package es.pierous.generator.parser.java.entity;

import java.util.ArrayList;
import java.util.List;

import es.pierous.generator.model.Attribute;
import es.pierous.generator.parser.GenericParserImpl;
import es.pierous.generator.parser.java.entity.attribute.AttributeDeclarationParserImpl;
import es.pierous.generator.parser.java.entity.attribute.HibernateAnnotationIdParserImpl;
import es.pierous.generator.parser.java.entity.attribute.HibernateAnnotationParserImpl;

public class AttributeJavaParserImpl extends GenericParserImpl<Attribute> {
	
	private List<GenericParserImpl<Attribute>> parsers;
	
	// CONSTRUCTOR
	
	public AttributeJavaParserImpl(Attribute item) {
		super(item);
		parsers = new ArrayList<GenericParserImpl<Attribute>>();
		
		parsers.add(new HibernateAnnotationIdParserImpl(item));
		parsers.add(new HibernateAnnotationParserImpl(item));
		parsers.add(new AttributeDeclarationParserImpl(item));
	}

	// IMPLEMENTED METHODS
	
	public String parse() {
		String result = "";
		
		for (GenericParserImpl<Attribute> parser : this.parsers) {
			result += parser.parse();
		}
		
		return result;
	}

}
