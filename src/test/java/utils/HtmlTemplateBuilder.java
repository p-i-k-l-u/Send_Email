//package utils;
//
//public class HtmlTemplateBuilder {
//
//	public static String buildHtml(int planned, int executed, int passed, int failed, int skipped) {
//
//		double passRate = (double) passed / executed * 100;
//
//		String html =
//
//				"<html>" + "<body style='font-family:Arial'>" +
//
//						"<h2>Automation Test Summary</h2>" +
//
//						"<table border='1' cellpadding='10'>" +
//
//						"<tr><td><b>Planned Tests</b></td><td>" + planned + "</td></tr>"
//						+ "<tr><td><b>Executed Tests</b></td><td>" + executed + "</td></tr>"
//						+ "<tr><td><b>Passed</b></td><td style='color:green'>" + passed + "</td></tr>"
//						+ "<tr><td><b>Failed</b></td><td style='color:red'>" + failed + "</td></tr>"
//						+ "<tr><td><b>Skipped</b></td><td>" + skipped + "</td></tr>"
//						+ "<tr><td><b>Pass Rate</b></td><td>" + String.format("%.2f", passRate) + "%</td></tr>" +
//
//						"</table>" +
//
//						"<br>" + "<p>Automation execution completed.</p>" +
//
//						"<p>Thanks<br>Automation Team</p>" +
//
//						"</body>" + "</html>";
//
//		return html;
//
//	}
//
//}

// ---------------------------------------------- AWS --------------------------------------

package utils;

public class HtmlTemplateBuilder {

	public static String buildHtml(int planned, int executed, int passed, int failed, int skipped) {

		int passRate = (passed * 100) / executed;

		String html = "<html><body>" +

				"<h2>Automation Test Summary</h2>" +

				"<table border='1' cellpadding='10'>" +

				"<tr><td>Planned Tests</td><td>" + planned + "</td></tr>" + "<tr><td>Executed Tests</td><td>" + executed
				+ "</td></tr>" + "<tr><td>Passed</td><td>" + passed + "</td></tr>" + "<tr><td>Failed</td><td>" + failed
				+ "</td></tr>" + "<tr><td>Skipped</td><td>" + skipped + "</td></tr>" + "<tr><td>Pass Rate</td><td>"
				+ passRate + "%</td></tr>" +

				"</table>" +

				"</body></html>";

		return html;

	}

}
