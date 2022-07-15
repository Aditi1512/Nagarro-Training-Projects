package com.nagarro.TshirtSearchProgram;

import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.nagarro.TshirtSearchProgram.constant.Constant;
import com.nagarro.TshirtSearchProgram.inputOutput.InputTshirtDetails;
import com.nagarro.TshirtSearchProgram.inputOutput.OutputTshirtDetails;
import com.nagarro.TshirtSearchProgram.model.Tshirt;
import com.nagarro.TshirtSearchProgram.utilities.ReadFiles;
import com.nagarro.TshirtSearchProgram.utilities.SearchTshirt;
import com.nagarro.TshirtSearchProgram.validator.InputValidation;

public class App {

	static List<Tshirt> tshirtFileList;

	public static void main(String[] args) {

		Timer timer = setTimerForModifyingCSVFiles();
		try {
			Thread.sleep(1000);
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);

			char choice;

			do {
				Thread.sleep(1000);
				Tshirt inputList = InputTshirtDetails.getUserInput();

				SearchTshirt tshirtList = new SearchTshirt();

				List<Tshirt> sortedTshirtList = tshirtList.sortTshirtList(inputList, tshirtFileList);

				System.out.println(Constant.RESULT);
				Thread.sleep(500);
				OutputTshirtDetails.displayTshirt(sortedTshirtList);

				System.out.println(Constant.CONTINUE);
				do {
					choice = sc.nextLine().toUpperCase().charAt(0);
				} while (!InputValidation.isValidChoice(choice));
			} while (choice == 'Y');

			System.out.println(Constant.EXITING);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			timer.cancel();
		}
	}

	private static Timer setTimerForModifyingCSVFiles() {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				tshirtFileList = ReadFiles.readDirectory();
			}
		};

		Timer timer = new Timer();

		timer.schedule(task, Constant.DELAY, Constant.PERIOD);
		return timer;
	}
}
