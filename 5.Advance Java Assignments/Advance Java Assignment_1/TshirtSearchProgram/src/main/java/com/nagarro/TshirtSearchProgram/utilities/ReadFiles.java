package com.nagarro.TshirtSearchProgram.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.nagarro.TshirtSearchProgram.constant.Constant;
import com.nagarro.TshirtSearchProgram.model.Tshirt;

public class ReadFiles implements Constant {

	public static List<Tshirt> readDirectory() {

		Tshirt tshirt;
		List<Tshirt> listOfTshirts = new ArrayList<>();
		File sourceFolder = new File(Constant.FILE_PATH);
		String line;

		File[] fileList = sourceFolder.listFiles();
		String fileName;

		for (File file : fileList) {
			fileName = file.getName();
			if (file.isFile() && fileName.substring(fileName.lastIndexOf('.') + 1).equals(Constant.CSV)) {
				try {

					@SuppressWarnings("resource")
					BufferedReader br = new BufferedReader(new FileReader(file));
					line = br.readLine();
					while ((line = br.readLine()) != null) {
						tshirt = new Tshirt();
						String[] value = line.split(Pattern.quote("|"));

						tshirt.setTshirtId(value[0]);
						tshirt.setTshirtBrandName(value[1]);
						tshirt.setTshirtColor(value[2]);
						tshirt.setGenderRecommendation(value[3].toUpperCase().charAt(0));
						tshirt.setTshirtSize(value[4]);
						tshirt.setTshirtPrice(Double.parseDouble(value[5]));
						tshirt.setTshirtRating(Double.parseDouble(value[6]));
						tshirt.setTshirtAvailability(value[7].charAt(0));
						listOfTshirts.add(tshirt);

					}
				} catch (FileNotFoundException e) {
					System.out.println(Constant.FILE_NOT_FOUND);

				} catch (NumberFormatException | IOException e) {

					e.printStackTrace();
				}
			} else {
				System.out.println(Constant.FILE_NOT_FOUND);
			}

		}
		return listOfTshirts;
	}

}
