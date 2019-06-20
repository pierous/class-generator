package es.pierous.generator.parser.java;

import es.pierous.generator.model.Table;
import es.pierous.generator.parser.GenericParserImpl;
import es.pierous.generator.utils.FileUtils;

public class JavaDaoInterfaceParserImpl extends GenericParserImpl<Table> {
	
	private static String TEMPLATE = "java/daoInterface.txt";
	
	private static String PACKAGE = "${package}";
	private static String NAME = "${name}";
	private static String ENTITY = "${entity}";
	
	// CONSTRUCTOR
	
	public JavaDaoInterfaceParserImpl(Table item) {
		super(item);
	}

	// IMPLEMENTED METHODS
	
	public String getURI() {
		return "/persistence/dao/" + this.item.getName() + "Dao.java";
	}

	public String parse() {
		String template = FileUtils.readFile(TEMPLATE);
		
		String result = template
				.replace(PACKAGE, item.getPack())
				.replace(NAME, this.item.getName())
				.replace(ENTITY, this.item.getName());
		
		return result;
	}

}
