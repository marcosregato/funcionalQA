package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
	
	public static String getProperty(String value) {
        Properties properties = new Properties();
        InputStream inputStream = null;
        String path = System.getProperty("user.dir");
        try {
            inputStream = new FileInputStream(path + "/config.properties");
            properties.load(inputStream);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    // Ignore close exception
                }
            }
        }
        String result = properties.getProperty(value);
        return result != null ? result.trim() : "";
    }
    
    public static String getProperty(String key, String defaultValue) {
        Properties properties = null;
        InputStream inputStream = null;
        String path = System.getProperty("user.dir");
        try {
            inputStream = new FileInputStream(path + "/config.properties");
            properties = new Properties();
            properties.load(inputStream);
            String result = properties.getProperty(key);
            return result != null ? result.trim() : defaultValue;
        } catch (Exception exception) {
            return defaultValue;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    // Ignore close exception
                }
            }
        }
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