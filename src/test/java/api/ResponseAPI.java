package api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonWriter;

public class ResponseAPI {

	@SuppressWarnings("unchecked")
	public void criarJson(List<String> arqCSV ) {

		JSONObject bodyJson = new JSONObject();
		JSONObject bodyJsonObject = new JSONObject();
		JSONArray bodyJsonList = new JSONArray();

		for(int x = 0; x <= arqCSV.size(); x++ ) {

			bodyJson.put("status", arqCSV.get(0));
			bodyJson.put("data", arqCSV.get(1));
			bodyJson.put("hora", arqCSV.get(2));
			bodyJson.put("metodo", arqCSV.get(3));
			bodyJson.put("mensagem", arqCSV.get(4));

		}

		bodyJsonObject.put("funcional", bodyJson);
		bodyJsonList.add(bodyJsonObject);

		System.out.println(bodyJsonList);

		try (FileWriter file = new FileWriter("employees.json")) {
			file.write(bodyJsonList.toJSONString()); 
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


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
	}

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
		URL obj = new URL(url);
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
