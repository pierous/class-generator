package es.pierous.generator.output;

import es.pierous.generator.model.Table;
import es.pierous.generator.parser.GenericParser;
import es.pierous.generator.utils.FileUtils;

public abstract class GenericOutputImpl implements GenericOutput {
	
	public void createFile(String url, Table table, GenericParser<Table> parser) {

		String content = parser.parse(table);
		FileUtils.createFile(url, content);
	}

}
