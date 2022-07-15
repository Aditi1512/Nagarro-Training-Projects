package com.nagarro.TshirtSearchProgram;

import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import com.nagarro.TshirtSearchProgram.constant.Constant;
import com.nagarro.TshirtSearchProgram.hibernateUtil.HibernateUtils;
import com.nagarro.TshirtSearchProgram.inputOutput.InputTshirtDetails;
import com.nagarro.TshirtSearchProgram.inputOutput.OutputTshirtDetails;
import com.nagarro.TshirtSearchProgram.model.Tshirt;
import com.nagarro.TshirtSearchProgram.utilities.ReadFiles;
import com.nagarro.TshirtSearchProgram.validator.InputValidation;

/**
 * This Class consist of main function that runs and execute the whole
 * application or program.
 */
public class App {

	/**
	 * This is main function that executes the whole program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Timer timer = setTimerForModifyingCSVFiles();
		try {
			Thread.sleep(500);
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);

			char choice;
			do {

				Tshirt inputList = InputTshirtDetails.getUserInput();

				HibernateUtils tshirtList = new HibernateUtils();

				List<Tshirt> sortedTshirtList = tshirtList.getData(inputList);

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

	/**
	 * This method use to read modified CSV files at specific time intervals.
	 * 
	 * @return timer the time interval for which the method runs
	 */
	private static Timer setTimerForModifyingCSVFiles() {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				ReadFiles.readFiles();
			}
		};

		Timer timer = new Timer();

		timer.schedule(task, Constant.DELAY, Constant.PERIOD);
		return timer;
	}
}
