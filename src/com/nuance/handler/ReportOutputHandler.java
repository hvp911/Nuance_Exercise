package com.nuance.handler;

import java.util.Map;

import com.nuance.model.InputFileModel;
import com.nuance.model.ReportOutputModel;

public class ReportOutputHandler {
	// making ReportOutputHandler singleton here.
	public static ReportOutputHandler getReportOutputHandler() {
		if (instance == null) {
			instance = new ReportOutputHandler();
		}
		return instance;
	}

	// output will be printed from the hash map.
	public void printReportOutput() {
		for (Map.Entry<String, Integer> entry : ReportOutputModel.getInstance().reportModel.entrySet()) {
			System.out.printf(OUTPUT_STRING_FORMAT, entry.getKey(), entry.getValue());
		}
	}

	public void updateOutputReportModel(InputFileModel inputFileModel) {
		// Based on the fields we want to see in output, we will add keys to out
		// output hashmap.
		updateKeySpecificModel(inputFileModel.getProvince(), inputFileModel.getPopulation());
		updateKeySpecificModel(inputFileModel.getCity(), inputFileModel.getPopulation());
		updateKeySpecificModel(inputFileModel.getSchool(), inputFileModel.getPopulation());
	}

	private void updateKeySpecificModel(String keyString, int population) {
		// Updating ReportOutputModel, inserting or updating keys with new
		// population values.
		if (!ReportOutputModel.getInstance().reportModel.containsKey(keyString)) {
			ReportOutputModel.getInstance().reportModel.put(keyString, population);
		} else {
			int previousPopulation = ReportOutputModel.getInstance().reportModel.get(keyString);
			ReportOutputModel.getInstance().reportModel.put(keyString, previousPopulation + population);
		}
	}

	private ReportOutputHandler() {
	}

	private static ReportOutputHandler instance;
	private static final String OUTPUT_STRING_FORMAT = "%-20s%s%n";
}
