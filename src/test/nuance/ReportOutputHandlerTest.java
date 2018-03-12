package test.nuance;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nuance.handler.ReportOutputHandler;
import com.nuance.model.InputFileModel;
import com.nuance.model.ReportOutputModel;

public class ReportOutputHandlerTest {
	@Test
	public void updateOutputReportModelTestSuccess() {
		InputFileModel inputFileModelTest = new InputFileModel("ON", "Waterloo", "School1", "K", 5);
		ReportOutputHandler.getReportOutputHandler().updateOutputReportModel(inputFileModelTest);
		assertTrue(ReportOutputModel.getInstance().reportModel.get("ON") == 5);
		assertTrue(ReportOutputModel.getInstance().reportModel.get("Waterloo") == 5);
		assertTrue(ReportOutputModel.getInstance().reportModel.get("School1") == 5);
	}

	@Test
	public void updateOutputReportModelTestFailure() {
		// The program will fail if City, Province Or School has same name in
		// the same row.
		InputFileModel inputFileModelTest = new InputFileModel("QC", "QC", "School1", "K", 5);
		ReportOutputHandler.getReportOutputHandler().updateOutputReportModel(inputFileModelTest);
		assertTrue(ReportOutputModel.getInstance().reportModel.get("QC") == 5);
	}
}
