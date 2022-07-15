package com.nagarro.serviceImplementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.constants.Constants;
import com.nagarro.dao.TshirtDao;
import com.nagarro.model.Tshirt;
import com.nagarro.service.ReadFilesService;

/**
 * This class is use to save information from CSV files into database.
 *
 */
@Service
public class ReadFilesServiceImpl implements ReadFilesService {
	@Autowired
	private TshirtDao tshirtDao;

	/**
	 * This method is use to save information from cCSV files into database.
	 *
	 */
	public void readDirectory() {

		Tshirt tshirt = null;
		List<Tshirt> listOfTshirts = new ArrayList<>();
		File sourceFolder = new File(Constants.FOLDER_PATH);

		String line;

		File[] fileList = sourceFolder.listFiles();
		String fileName;

		for (File file : fileList) {
			fileName = file.getName();
			if (file.isFile() && fileName.substring(fileName.lastIndexOf('.') + 1).equals(Constants.CSV)) {
				try {
					@SuppressWarnings("resource")
					BufferedReader br = new BufferedReader(new FileReader(file));
					br.readLine();
					while ((line = br.readLine()) != null) {

						String[] value = line.split(Pattern.quote("|"));
						tshirt = new Tshirt(value[0], value[1], value[2], value[3].toUpperCase().charAt(0), value[4],
								Float.parseFloat(value[5]), Float.parseFloat(value[6]), value[7].charAt(0));
						listOfTshirts.add(tshirt);
					}
				} catch (FileNotFoundException e) {
					System.err.println(Constants.FILE_NOT_FOUND);
					e.printStackTrace();
				} catch (IOException e) {
					System.err.println(Constants.IO_EXCEPTION);
					e.printStackTrace();
				}
			} else {
				System.err.println(Constants.FILE_NOT_FOUND);
			}

		}

		tshirtDao.saveData(listOfTshirts);
	}
}