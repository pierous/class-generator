package es.pierous.generator.parser;

import es.pierous.generator.model.Parseable;

public abstract class GenericParserImpl<E extends Parseable> implements GenericParser<E> {
	
	protected static final String NL = "\r\n";

}
