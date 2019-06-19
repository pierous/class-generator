package es.pierous.generator;

import es.pierous.generator.input.GenericInput;
import es.pierous.generator.input.excel.ExcelInputImpl;
import es.pierous.generator.model.Table;
import es.pierous.generator.output.GenericOutput;
import es.pierous.generator.output.java.JavaOutputImpl;
import es.pierous.generator.parser.java.JavaClassParserImpl;
import es.pierous.generator.parser.java.JavaDaoHibernateParserImpl;
import es.pierous.generator.parser.java.JavaDaoInterfaceParserImpl;

public class app {

	public static void main(String[] args) {
		GenericInput input = new ExcelInputImpl();
		
		for (String string : args) {
			System.out.println(string);
		}
		
		Table table = input.toTable("C:/Users/dulloa/Desktop/Prueba.xlsx");
		
		GenericOutput  output = new JavaOutputImpl();
		
		output.createFile("output/java/class.txt", table, new JavaClassParserImpl(table));
		
		output.createFile("output/java/dao.txt", table, new JavaDaoInterfaceParserImpl(table));
		
		output.createFile("output/java/daoHibernate.txt", table, new JavaDaoHibernateParserImpl(table));
	}

}
