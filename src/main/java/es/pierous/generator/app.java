package es.pierous.generator;

import es.pierous.generator.input.GenericInput;
import es.pierous.generator.input.excel.ExcelInputImpl;
import es.pierous.generator.model.Table;
import es.pierous.generator.output.GenericOutput;
import es.pierous.generator.output.java.JavaOutputImpl;
import es.pierous.generator.parser.java.JavaClassParserImpl;

public class app {

	public static void main(String[] args) {
		GenericInput input = new ExcelInputImpl();
		
		for (String string : args) {
			System.out.println(string);
		}
		
		Table table = input.toTable("C:/Users/piero/Desktop/pruebas/Prueba.xlsx");
		
		GenericOutput  output = new JavaOutputImpl();
		
		output.createFile("output/java/prueba.txt", table, new JavaClassParserImpl());
	}

}
