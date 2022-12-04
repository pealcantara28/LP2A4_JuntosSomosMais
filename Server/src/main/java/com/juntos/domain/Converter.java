package com.juntos.domain;

import java.util.ArrayList;

import com.juntos.domain.entities.Cliente;
import com.juntos.domain.viewmodel.TempCliente;

public class Converter {
	public static String boundingBox(double latitude, double longitude) {
		if (
		// Regras de validação para candidatos "Especiais"
		((-15.411580 < longitude) && (longitude < -2.196998) && (-46.361899 < latitude) && (latitude < -34.276938))
				|| ((-23.966413 < longitude) && (longitude < -19.766959) && (-52.997614 < latitude)
						&& (latitude < -44.428305))) {
			return "SPECIAL";
		} else if (
		// Regras de validação para candidatos "Normais"
		(-54.777426 < latitude) && (latitude < -46.603598) && (-34.016466 < longitude) && (longitude < -26.155681)) {
			return "NORMAL";
		} else {
			return "LABORIOUS";
		}
	}

	public static Cliente convertTempToCliente(TempCliente temp) {
		ArrayList<String> phoneList = new ArrayList<String>();
		phoneList.add(temp.getPhone());
		String boundingBox = "UNKNOWN";

		if (temp.getLocation() != null) {
			boundingBox = boundingBox(temp.getLocation().getCoordinates().getLatitude(),
					temp.getLocation().getCoordinates().getLongitude());
		}

		char genderCharacter = genderCharacter(temp.getGender());

		return new Cliente(genderCharacter, temp.getEmail(), boundingBox, temp.getDob().getDate(),
				temp.getRegistered().getDate(), temp.getPhone(), temp.getPhone(), temp.getLocation(), temp.getPicture(),
				temp.getName(), "BR");
	}

	public static String formatPhoneNumber(String phone) {
		return "+55" + phone.replace("(", "").replace(")", "").replace(" ", "");
	}

	public static char genderCharacter(String gender) {
		if (gender.equals("male"))
			return 'M';
		if (gender.equals("female"))
			return 'F';
		return 'X';
	}

}
