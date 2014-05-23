package br.edu.fatec.okonesports.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyUtils {

	public static BigDecimal formatStringToBigDecimal(String value) {
		value = value.replace(".", "").replace(",", ".").replace("R$ ", "");
		return new BigDecimal(value);
	}

	public static String formatBigDecimalToCurrency(BigDecimal value) {
		if (value == null) {
			return "";
		}
		return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(value);
	}

}