package es.pierous.generator.output;

import es.pierous.generator.model.Table;
import es.pierous.generator.parser.GenericParser;

public interface GenericOutput {
	
	public void createFile(String url, Table table, GenericParser<Table> parser);

}
