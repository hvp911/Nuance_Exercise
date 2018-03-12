package com.nuance.model;

import java.util.HashMap;

public class ReportOutputModel {

	// Creating singleton instance of ReportOutputModel.
	public HashMap<String, Integer> reportModel = new HashMap<String, Integer>();

	public static ReportOutputModel getInstance() {
		if (instance == null) {
			instance = new ReportOutputModel();
		}
		return instance;
	}

	private ReportOutputModel() {
	}

	private static ReportOutputModel instance;
}
