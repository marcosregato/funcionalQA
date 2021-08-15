package relatorio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import util.Utilidade;

public class ManipularCsv {
	
	private static final String Path_TestData = System.getProperty("user.dir");
	String pathArquivo = Path_TestData+"/FERRAMENTA_TESTE/";
	Utilidade util = new Utilidade();

	public void criarDiretorio() {
		try {
			if(!new File(pathArquivo).exists()) {
				new File(pathArquivo).mkdir();

			}else {
				System.out.println("JA FOI CRIAADO");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void criarRelatorioCsv(String nomeClass) {
		try {
			Date dataHoraAtual = new Date();
			String data = new SimpleDateFormat("dd_MM_yyyy").format(dataHoraAtual);
			String horario = new SimpleDateFormat("HH_mm").format(dataHoraAtual);
			BufferedWriter pw = new BufferedWriter(new FileWriter(pathArquivo+ nomeClass + "_" + "" + data + "_"+horario+".csv"));
			String array = "status,data,hora,metodo,mensagem";
			pw.append(array);
			pw.append("\n");
			pw.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @param nomeClass
	 * @param nomeMetodo
	 * @param status
	 * @param mensagemErro
	 */
	public void escreverCsv(String metodo, String status, String erro) {
		try {
			Date dataHoraAtual = new Date();
			String data = new SimpleDateFormat("dd-MM-yyyy").format(dataHoraAtual);
			String hora = new SimpleDateFormat("HH:mm").format(dataHoraAtual);

			File arquivo = new File(pathArquivo+getUltimoArquivoCsv());

			String linha = status + "," + data + "," + hora + "," + metodo+","+erro;
			PrintWriter csvWriter;
			csvWriter = new  PrintWriter(new FileWriter(arquivo,true));
			csvWriter.println(linha);
			csvWriter.close();

		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>>>>>> escreverCsv <<<<<<<<<<<<<<<<<< \n");
			e.getMessage();
		}
	}

	@SuppressWarnings("unused")
	public String getUltimoArquivoCsv(){
		try {
			File arquivo = new File(pathArquivo);
		
			String ultimoArquivo = null;
			List<String> list = new ArrayList<String>();

			File listFile[] = arquivo.listFiles();
			for (int x = 0; x < listFile.length; x++) {
				if (listFile[x].getName().endsWith(".csv")) {
					list.add(listFile[x].getName());
				}
			}
			Collections.sort(list);

			for (int x = 0; x <= list.size(); x++) {
				ultimoArquivo = list.get(list.size() - 1);
				break;
			}
			return ultimoArquivo;


		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>>>>>>>>> getUltimoArquivoCsv <<<<<<<<<<<<<<<<<<<<<< \n");
			e.getMessage();
		}
		return null;
	}
}