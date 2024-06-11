package it.uniroma3.diadia;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class ClassFinder {
    public static List<String> getClassesInPackage(String packageName) {
        String path = packageName.replace('.', '/');
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource(path);

        List<String> classes = new ArrayList<>();

        if (resource == null) {
            return classes;
        }

        String filePath;
        try {
            filePath = URLDecoder.decode(resource.getFile(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return classes;
        }

        File directory = new File(filePath);
        if (directory.exists()) {
            String[] files = directory.list();
            for (String file : files) {
                if (file.endsWith(".class")&&file.startsWith("Comando")) {
                    String className = file.substring(7, file.length() - 6);
                    if (!className.endsWith("Test") && !className.equals("NonValido")){   //ignora le classi di test
                    classes.add(className);
                }
                }
            }
        }

        return classes;
 
    }
}
