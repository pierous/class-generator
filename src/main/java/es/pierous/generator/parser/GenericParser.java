package es.pierous.generator.parser;

import es.pierous.generator.model.Parseable;

public interface GenericParser<E extends Parseable> {
	
	public String parse();

}
