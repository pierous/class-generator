package es.pierous.generator;

import es.pierous.generator.input.GenericInput;
import es.pierous.generator.input.excel.ExcelInputImpl;
import es.pierous.generator.model.Table;
import es.pierous.generator.output.GenericOutput;
import es.pierous.generator.output.java.JavaOutputImpl;
import es.pierous.generator.parser.java.JavaClassParserImpl;
import es.pierous.generator.parser.java.JavaDaoHibernateParserImpl;
import es.pierous.generator.parser.java.JavaDaoInterfaceParserImpl;
import es.pierous.generator.parser.java.JavaServiceImplementationParsetImpl;
import es.pierous.generator.parser.java.JavaServiceInterfaceParsetImpl;

public class app {

	public static void main(String[] args) {
		GenericInput input = new ExcelInputImpl();
		
		for (String string : args) {
			System.out.println(string);
		}
		
		Table table = input.toTable("C:/Users/dulloa/Desktop/Prueba.xlsx");
		
		table.setPack("cag.metro.xggi.keops");
		
		GenericOutput  output = new JavaOutputImpl("output");
		
		output.createFile(table, new JavaClassParserImpl(table));
		
		output.createFile(table, new JavaDaoInterfaceParserImpl(table));
		
		output.createFile(table, new JavaDaoHibernateParserImpl(table));
		
		output.createFile(table, new JavaServiceInterfaceParsetImpl(table));
		
		output.createFile(table, new JavaServiceImplementationParsetImpl(table));
	}

}
