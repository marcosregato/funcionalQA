package relatorio;

import java.io.File;

public class CriarPasta {
	private static final String Path_TestData = System.getProperty("user.dir");
	String pathArquivoLinux = Path_TestData+"/FERRAMENTA_TESTE/";
	

	
	public void criar() {
		if(!new File(pathArquivoLinux).exists()) {
			new File(pathArquivoLinux).mkdir();
			
		}else {
			System.out.println("JA FOI CRIADO O DIRETORIO FERRAMENTA_TESTE");
		}
	}
	
	public static void main(String... asd) {
		CriarPasta c  = new CriarPasta();
		c.criar();
	}

}
