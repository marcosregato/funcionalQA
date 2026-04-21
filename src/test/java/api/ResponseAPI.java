package api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ResponseAPI {
	public void criarJson(List<String> arqCSV ) {

		JsonObject bodyJson = new JsonObject();
		JsonObject bodyJsonObject = new JsonObject();
		JsonArray bodyJsonList = new JsonArray();

		if (arqCSV.size() >= 5) {
			bodyJson.addProperty("status", arqCSV.get(0));
			bodyJson.addProperty("data", arqCSV.get(1));
			bodyJson.addProperty("hora", arqCSV.get(2));
			bodyJson.addProperty("metodo", arqCSV.get(3));
			bodyJson.addProperty("mensagem", arqCSV.get(4));
		}

		bodyJsonObject.add("funcional", bodyJson);
		bodyJsonList.add(bodyJsonObject);

		System.out.println(bodyJsonList);

		try (FileWriter file = new FileWriter("employees.json")) {
			Gson gson = new Gson();
			file.write(gson.toJson(bodyJsonList)); 
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	public void updateJson(File arqJdon) {
		try {

			String nameRead;

			JsonParser parser = new JsonParser();
			Object obj = parser.parse(new FileReader(arqJdon));
			JsonObject jsonObject = (JsonObject) obj;

			JsonArray msg = (JsonArray)jsonObject.get("funcional");
			Iterator<JsonElement> iterator = msg.iterator();

			while(iterator.hasNext()) {
				nameRead = iterator.next().toString();
			}

			Name name = new Name();
			name.setName("Vamsi");
			Gson gson = new Gson();
			String json = gson.toJson(name);

			FileWriter file = new FileWriter(arqJdon, false);
			JsonWriter jw = new JsonWriter(file);
			iterator = msg.iterator();
			Employees emps = new Employees();

			while(iterator.hasNext()) {
				emps.addEmployee(gson.fromJson(iterator.next().toString(), Name.class));
			}
			emps.addEmployee(name);
			gson.toJson(emps, Employees.class, jw);
			file.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * @param nomeClass
	 * @param nomeMetodo
	 * @param status
	 * @param mensagemErro
	 */
	public void escreverJson(String metodo, String status, String erro) {
		try {
			ArrayList<String> json = new ArrayList<String>();
			Date dataHoraAtual = new Date();
			String data = new SimpleDateFormat("dd-MM-yyyy").format(dataHoraAtual);
			String hora = new SimpleDateFormat("HH:mm").format(dataHoraAtual);

			json.add(status);
			json.add(data);
			json.add(hora);
			json.add(metodo);
			json.add(erro);

			criarJson(json);

		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>>>>>> escreverCsv <<<<<<<<<<<<<<<<<< \n");
			e.getMessage();
		}
	}

	public static void main(String[] asd) {
		ResponseAPI res = new ResponseAPI();
		res.escreverJson("click","OK", null);
		res.escreverJson("click","ERRO", null);
	}

	@SuppressWarnings("unused")
	private void sendingPostRequest(String postJsonData) throws Exception {

		String url = "http://localhost:8081/funcional";
		URI uri = URI.create(url);
		URL obj = uri.toURL();
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("Accept-Language", "pt-br,en;q=0.9,*;q=0.8");
		con.setRequestProperty("Content-Type","application/json");

		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(postJsonData);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));

		String output;
		StringBuffer response = new StringBuffer();

		while ((output = in.readLine()) != null) {
			response.append(output);
		}
		in.close();

		System.out.println(response.toString());
	}

}
