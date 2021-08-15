package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
	
	public static String getProperty(String value) {
        Properties properties = null;
        InputStream inputStream = null;
        String path = System.getProperty("user.dir");
        try {
            inputStream = new FileInputStream(path + "/config.properties");
            properties = new Properties();
            properties.load(inputStream);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return properties.getProperty(value).trim();
    }
	
	public String pathFile(String file) {
		String path = System.getProperty("user.dir");
		String nomeArquivo=null;
		
		if(file =="csv") {
			File arquivo = new File(path+"/arquivoCSV/");
			File[] f = arquivo.listFiles();
			
			for(int a =0; a< f.length;a++) {
				nomeArquivo = f[a].getName();
			}
		}else {
			File arquivo = new File(path+"/arquivoJSON/");
			File[] f = arquivo.listFiles();
			
			for(int a =0; a< f.length;a++) {
				nomeArquivo = f[a].getName();
			}
		}
		return nomeArquivo;
	}
	
}