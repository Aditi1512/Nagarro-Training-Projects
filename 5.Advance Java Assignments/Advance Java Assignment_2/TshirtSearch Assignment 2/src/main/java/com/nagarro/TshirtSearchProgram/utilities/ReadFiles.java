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
import com.nagarro.TshirtSearchProgram.hibernateUtil.HibernateUtils;
import com.nagarro.TshirtSearchProgram.model.Tshirt;

/**
 * 
 * This class consist of a function to to read CSV files data.
 *
 */
public class ReadFiles {

	/**
	 * This method reads CSV files data stores it in the object of model class.
	 */
	public static void readFiles() {

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

						String[] tshirtData = line.split(Pattern.quote("|"));
						Tshirt tshirt = new Tshirt(tshirtData[0], tshirtData[1], tshirtData[2],
								tshirtData[3].toUpperCase().charAt(0), tshirtData[4], Double.parseDouble(tshirtData[5]),
								Double.parseDouble(tshirtData[6]), tshirtData[7].charAt(0));
						listOfTshirts.add(tshirt);
					}

				} catch (FileNotFoundException e) {
					System.out.println(Constant.FILE_NOT_FOUND);

				} catch (IOException e) {

					e.printStackTrace();
				}

			} else {
				System.out.println(Constant.FILE_NOT_FOUND);
			}
		}
		HibernateUtils.saveData(listOfTshirts);
	}

}
