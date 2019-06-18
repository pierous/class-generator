package es.pierous.generator.input.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.pierous.generator.input.GenericInput;
import es.pierous.generator.model.Attribute;
import es.pierous.generator.model.Table;

public class ExcelInputImpl implements GenericInput {
	
	// CONSTANTES
	public static Integer TABLE_BD_POS = 2;
	public static Integer ATTR_BD_POS = 3;
	public static Integer ATTR_JAVA_POS = 4;
	public static Integer TYPE_BD_POS = 7;
	public static Integer SIZE_BD_POS = 8;
	
	// PUBLIC METHODS
	
	@Override
	public Table toTable(String url) {
		Table result = null;
		
		try {
			FileInputStream file = new FileInputStream(new File(url));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			result = this.fromSheet(sheet);
			
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	// PRIVATE METHODS
	
	private Table fromSheet(XSSFSheet sheet) {
		
		Table table = null;
		
		Iterator<Row> iterator = sheet.iterator();
		
		while (iterator.hasNext()) {
			Row row = iterator.next();
			if (table == null) {
				table = this.fromCellTable(row);
			}
			table.getAttributes().add(this.fromCellAttribute(row));
		}
		
		return table;
	}
	
	private Table fromCellTable(Row row) {
		Table table = new Table();
		
		String name = row.getCell(TABLE_BD_POS).getStringCellValue();
		
		table.setName(name);
		
		return table;
	}
	
	private Attribute fromCellAttribute(Row row) {
		
		String nombreBD = row.getCell(ATTR_BD_POS).getStringCellValue();
	    String tipo = row.getCell(TYPE_BD_POS).getStringCellValue();
	    String nombreJava = (row.getCell(ATTR_JAVA_POS) != null) ? row.getCell(ATTR_JAVA_POS).getStringCellValue() : null;
	    Integer size = Double.valueOf(row.getCell(SIZE_BD_POS).getNumericCellValue()).intValue();
	    
	    Attribute attr = new Attribute();
	    
	    attr.setColumn(nombreBD);
	    attr.setName(nombreJava);
	    attr.setType(tipo);
	    attr.setSize(size);
		
		return attr;
	}

}
