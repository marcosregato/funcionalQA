package util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EstiloRoupa {
	
	public String estiloPopular() {
		final Map<String, String> estilo = new HashMap<String, String>();
		estilo.put("01", "Faded Short Sleeve T-shirts");
		estilo.put("02", "Blouse");
		estilo.put("03", "Printed Dress");
		estilo.put("04", "Printed Summer Dress");
		estilo.put("05", "Printed Chiffon Dress");
		Object randomEstilo = estilo.keySet().toArray()[new Random().nextInt(estilo.keySet().toArray().length)];
    	return estilo.get(randomEstilo);
	}
	
	public String ordemProduto() {
		final Map<String, String> ordem = new HashMap<String, String>();
		ordem.put("01", "price:asc");
		ordem.put("02", "price:desc");
		ordem.put("03", "name:asc");
		ordem.put("04", "name:desc");
		ordem.put("05", "quantity:desc");
		ordem.put("06", "reference:asc");
		ordem.put("07", "reference:desc");
		ordem.put("08", "position:asc");
	
		Object randomOrdem = ordem.keySet().toArray()[new Random().nextInt(ordem.keySet().toArray().length)];
    	return ordem.get(randomOrdem);
	}
	
	

}
