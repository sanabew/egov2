package gov.esprit.utils;

import javax.annotation.Generated;

/**
 * {@link Identifier} auto generation class.
 * 
 * @author monta
 */
public abstract class Identifier {

	/**
	 * rotation matrix TABREP_7.
	 */
	private static final Integer[][] TABREP_7 = { { 4, 2, 8, 6, 7, 5, 3, 1 }, { 6, 7, 8, 2, 5, 1, 3, 4 },
			{ 3, 1, 8, 7, 4, 2, 6, 5 }, { 2, 3, 8, 5, 7, 4, 1, 6 }, { 7, 6, 8, 3, 4, 1, 2, 5 },
			{ 5, 7, 8, 2, 4, 6, 3, 1 }, { 7, 4, 8, 1, 2, 6, 3, 5 }, { 5, 3, 8, 1, 4, 7, 2, 6 },
			{ 1, 7, 8, 5, 2, 3, 4, 6 }, { 7, 1, 8, 3, 4, 2, 6, 5 } };

	/**
	 * rotation matrix TABREP_8.
	 */
	private static final Integer[][] TABREP_8 = { { 5, 1, 9, 3, 4, 8, 6, 2, 7 }, { 8, 7, 9, 6, 2, 5, 1, 3, 4 },
			{ 7, 4, 9, 1, 2, 5, 8, 3, 6 }, { 1, 4, 9, 2, 3, 5, 7, 8, 6 }, { 2, 4, 9, 7, 1, 3, 5, 6, 8 },
			{ 6, 5, 9, 1, 4, 3, 2, 7, 8 }, { 1, 2, 9, 4, 3, 8, 6, 5, 7 }, { 4, 7, 9, 8, 5, 2, 1, 6, 3 },
			{ 3, 8, 9, 1, 4, 6, 5, 2, 7 }, { 6, 1, 9, 8, 5, 4, 2, 7, 3 } };

	/**
	 * @param digits
	 * @return String
	 */
	private static String checkSum(final String digits) {
		return String.format("%02d", (int) (98 - Long.parseLong(digits) * 100 % 97L) % 97);
	}

	/**
	 * encode.
	 * 
	 * @param digits
	 * @return {@link String}
	 */
	private static String encode(final String digits) {
		if (digits == null || digits.isEmpty()) {
			return null;
		}
		String crc = calcCRC(checkSum(digits));

		Integer[][] rotarray = null;

		switch (digits.length()) {
			case 7:
				rotarray = TABREP_7;
				break;
			case 8:
				rotarray = TABREP_8;
				break;
			default:
		}

		String result = digits + crc;
		// if rotation array is defined obfuscate the result
		if (rotarray != null) {
			String rotdigit = "";

			for (Integer element : rotarray[Integer.parseInt(crc)]) {
				rotdigit = rotdigit + result.substring(element - 1, element);
			}
			return rotdigit;
		}
		return result;
	}

	/**
	 * calcCRC.
	 * 
	 * @param crc
	 * @return {@link String}
	 */
	private static String calcCRC(final String crc) {
		String result = String.valueOf(Integer.parseInt(crc.substring(0, 1)) ^ Integer.parseInt(crc.substring(1)));
		while (result.length() > 1) {
			result = String.valueOf(Integer.parseInt(result.substring(0, 1)) + Integer.parseInt(result.substring(1)));
		}
		return result;
	}

	/**
	 * get generated identifier.
	 * 
	 * @param id
	 * @return {@link String}
	 */
	public static String generate(final Integer id){
		
		// check input
		if(id == null || id == 0){
			return null;
		}
		
		// encoding the key id
		String key = id.toString();
		String encodedKey = encode(key);
		
		// building the identifier
		StringBuilder sb = new StringBuilder();
		
		// front complete by zeros if length less than 8
		for (int i = 1; i < (8 - encodedKey.length() + 1); i++) {
			sb.append("0");
		}
		sb.append(encodedKey);
		
		// substring 8 chars if length greater than 8
		return sb.substring(0, 8);
	}
}