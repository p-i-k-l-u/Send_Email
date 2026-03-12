//package listeners;
//
//import org.testng.*;
//
//import utils.EmailSender;
//import utils.HtmlTemplateBuilder;
//
//public class TestListener implements ITestListener {
//
//	int passed = 0;
//	int failed = 0;
//	int skipped = 0;
//
//	public void onTestSuccess(ITestResult result) {
//		passed++;
//	}
//
//	public void onTestFailure(ITestResult result) {
//		failed++;
//	}
//
//	public void onTestSkipped(ITestResult result) {
//		skipped++;
//	}
//
//	public void onFinish(ITestContext context) {
//
//		int executed = passed + failed + skipped;
//
//		int planned = context.getAllTestMethods().length;
//
//		String html = HtmlTemplateBuilder.buildHtml(planned, executed, passed, failed, skipped);
//
//		EmailSender.sendEmail(html);
//
//	}
//
//}

// -------------------------------------- AWS ------------------------------------------------

package listeners;

import org.testng.*;
import utils.HtmlTemplateBuilder;
import utils.EmailSender;

public class TestListener implements ITestListener {

	int passed = 0;
	int failed = 0;
	int skipped = 0;

	public void onTestSuccess(ITestResult result) {
		passed++;
	}

	public void onTestFailure(ITestResult result) {
		failed++;
	}

	public void onTestSkipped(ITestResult result) {
		skipped++;
	}

	public void onFinish(ITestContext context) {

		int executed = passed + failed + skipped;
		int planned = context.getAllTestMethods().length;

		String html = HtmlTemplateBuilder.buildHtml(planned, executed, passed, failed, skipped);

		EmailSender.sendEmail("Automation Test Report", html);

	}

}
