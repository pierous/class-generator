package es.pierous.generator.parser.java;

import es.pierous.generator.model.Table;
import es.pierous.generator.parser.GenericParserImpl;
import es.pierous.generator.utils.FileUtils;

public class JavaDaoHibernateParserImpl extends GenericParserImpl<Table> {
	
	private static String TEMPLATE = "java/daoHibernateImpl.txt";
	
	private static String NAME = "${name}";
	private static String ENTITY = "${entity}";
	
	// CONSTRUCTOR
	
	public JavaDaoHibernateParserImpl(Table item) {
		super(item);
	}

	// IMPLEMENTED METHODS
	
	public String parse() {
		String template = FileUtils.readFile(TEMPLATE);
		
		String result = template.replace(NAME, this.item.getName())
				.replace(ENTITY, this.item.getName());
		
		return result;
	}

}
