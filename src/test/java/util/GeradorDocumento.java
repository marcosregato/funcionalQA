package util;

import java.util.InputMismatchException;
import java.util.Random;

/**
 * Gerador de documenetos
 * RG
 * CPF
 * @author Atomic
 */
public class GeradorDocumento {


	private int randomiza(int n) {
		int ranNum = (int) (Math.random() * n);
		return ranNum;
	}

	private int mod(int dividendo, int divisor) {
		return (int) Math.round(dividendo - (Math.floor(dividendo / divisor) * divisor));
	}

	
	/**
	 * @param formato for true , o cnpj retorna com pontuacao
	 * @return
	 */
	public String gerarCPF(boolean formato) {
		try {

			int n = 9;
			int n1 = randomiza(n);
			int n2 = randomiza(n);
			int n3 = randomiza(n);
			int n4 = randomiza(n);
			int n5 = randomiza(n);
			int n6 = randomiza(n);
			int n7 = randomiza(n);
			int n8 = randomiza(n);
			int n9 = randomiza(n);
			int d1 = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;

			d1 = 11 - (mod(d1, 11));

			if (d1 >= 10)
				d1 = 0;

			int d2 = d1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;

			d2 = 11 - (mod(d2, 11));

			String retorno = null;

			if (d2 >= 10)
				d2 = 0;
			retorno = "";

			if (formato!=false)
				retorno = "" + n1 + n2 + n3 + '.' + n4 + n5 + n6 + '.' + n7 + n8 + n9 + '-' + d1 + d2;
			else
				retorno = "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + d1 + d2;
			return retorno;
		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>> gerarCPF <<<<<<<<<<<<<<<<<<<<<<<<<<<<< \n");
		}
		return null;
	}
	
	/**
	 * 
	 * @param formato for true , o cnpj retorna com pontuacao
	 * @return
	 */
	public String gerarCnpj(boolean formato) {
		int n = 9;
		Random r = new Random();
		int n1 = r.nextInt(n);
		int n2 = r.nextInt(n);
		int n3 = r.nextInt(n);
		int n4 = r.nextInt(n);
		int n5 = r.nextInt(n);
		int n6 = r.nextInt(n);
		int n7 = r.nextInt(n);
		int n8 = r.nextInt(n);
		int n9 = 0; 
		int n10 = 0;
		int n11 = 0;
		int n12 = 1;
		int d1 = n12 * 2 + n11 * 3 + n10 * 4 + n9 * 5 + n8 * 6 + n7 * 7 + n6 * 8 + n5 * 9 + n4 * 2 + n3 * 3 + n2 * 4 + n1 * 5;

		d1 = 11 - (mod(d1, 11));

		if (d1 >= 10)
			d1 = 0;

		int d2 = d1 * 2 + n12 * 3 + n11 * 4 + n10 * 5 + n9 * 6 + n8 * 7 + n7 * 8 + n6 * 9 + n5 * 2 + n4 * 3 + n3 * 4 + n2 * 5 + n1 * 6;

		d2 = 11 - (mod(d2, 11));

		if (d2 >= 10)
			d2 = 0;

		String retorno = null;

		if (formato!= false) {
			retorno = "" + n1 + n2 + "." + n3 + n4 + n5 + "." + n6 + n7 +
					n8 + "/" + n9 + n10 + n11 + n12 + "-" + d1 + d2; 
		}else {

			retorno = "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + n10 + n11 + n12 + d1 + d2;
		}
		return retorno;
	}

	public boolean isCPF(String CPF) {

		CPF = removeCaracteresEspeciais(CPF);

		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") || CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555") || CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888") || CPF.equals("99999999999") || (CPF.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);

			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	private String removeCaracteresEspeciais(String doc) {
		if (doc.contains(".")) {
			doc = doc.replace(".", "");
		}
		if (doc.contains("-")) {
			doc = doc.replace("-", "");
		}
		if (doc.contains("/")) {
			doc = doc.replace("/", "");
		}
		return doc;
	}
}