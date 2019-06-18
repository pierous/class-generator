package es.pierous.generator.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {
	
	public static String readFile(String file) {
		String data = null;
        
        try {
			Path path = Paths.get(FileUtils.class.getClassLoader().getResource(file).toURI());
			
			Stream<String> lines = Files.lines(path);
		    data = lines.collect(Collectors.joining("\n"));
		    lines.close();
		    return data;
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return data;
	}
	
	public static void createFile(String url, String content) {
		Path path = Paths.get(url);
		
		try {
			Files.createDirectories(path.getParent());
			
			Files.write(path, content.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
