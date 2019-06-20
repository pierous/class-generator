package es.pierous.generator.output;

import es.pierous.generator.model.Table;
import es.pierous.generator.parser.GenericParser;
import es.pierous.generator.utils.FileUtils;

public abstract class GenericOutputImpl implements GenericOutput {
	
	// ATTRIBUTES
	
	private String directory;
	
	// CONSTRUCTOR
	
	public GenericOutputImpl(String directory) {
		this.directory = directory;
	}
	
	// PUBLIC METHODS
	
	public void createFile(Table table, GenericParser<Table> parser) {

		String content = parser.parse();
		FileUtils.createFile(this.directory + parser.getURI(), content);
	}

}
