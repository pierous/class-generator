package es.pierous.generator.parser.java.entity;

import java.util.ArrayList;
import java.util.List;

import es.pierous.generator.model.Attribute;
import es.pierous.generator.parser.GenericParserImpl;
import es.pierous.generator.parser.java.entity.attribute.AttributeDeclarationParserImpl;
import es.pierous.generator.parser.java.entity.attribute.HibernateAnnotationParserImpl;

public class AttributeJavaParserImpl extends GenericParserImpl<Attribute> {
	
	private List<GenericParserImpl<Attribute>> parsers;
	
	public AttributeJavaParserImpl() {
		parsers = new ArrayList<GenericParserImpl<Attribute>>();
		
		parsers.add(new HibernateAnnotationParserImpl());
		parsers.add(new AttributeDeclarationParserImpl());
	}

	public String parse(Attribute attribute) {
		String result = "";
		
		for (GenericParserImpl<Attribute> parser : this.parsers) {
			result += parser.parse(attribute);
		}
		
		return result;
	}

}
