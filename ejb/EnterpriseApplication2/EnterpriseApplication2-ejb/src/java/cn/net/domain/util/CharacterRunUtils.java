package cn.net.domain.util;


import java.io.InputStream;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Range;



/**
 * 在Android读取Word文件时，在网上查看时可以用tm-extractors，
 * 但好像没有提到怎么读取Word文档中字体的颜色，字体，上下标等相关的属性。
 * 但由于需要，要把doc文档中的内容（字体，下划线，颜色等）读取应用到android中（不包括图片和图表）。
 * 	后面采用的是poi三方jar包（原包太大，可以从源代码里自己抽取有用的一些代码减少包的大小）。
 * 	我的想法是：把doc中的内容解析出来后，加上html对应的标签，
 * 在android中通过Html.fromHtml在TextView中进行显示，或者通过WebView.loadData进行加载显示
 * 	但测试后，发现如果加载太多内容的话，在Android中效率不行。
 */

/**
 * 处理字体相关的属性
 */
public class CharacterRunUtils {

	private static final short ENTER_ASCII = 13;
	//private static final short SPACE_ASCII = 32;
	//private static final short TABULATION_ASCII = 9;

	/**
	 * 做法２：（解析为font样式的，Html.fromHtml有效，但对应size的设置无效果） Html样式 通过字体样式解析
	 * 
	 * @param inputStream
	 * @return
	 */
	public StringBuffer readDocToHtml(InputStream inputStream) {
		HWPFDocument hwpfDocument = null;
		if (inputStream == null)
			throw new RuntimeException("inputStream is null ...");
		try {
			hwpfDocument = new HWPFDocument(inputStream);
		} catch (Exception e) {
			throw new RuntimeException("HWPFDocment Exception", e);
		}
		CharacterRun cur = null;
		StringBuffer sb = new StringBuffer();
		StringBuffer charStr = new StringBuffer();
		Range allRange = hwpfDocument.getRange();
		for (int i = 0; i < allRange.numCharacterRuns(); i++) {
			cur = allRange.getCharacterRun(i);
			charStr.append(CharacterRunUtils.toSupOrSub(cur,
					CharacterRunUtils.getSpicalSysbomByRun(cur.text())));
			sb.append(charStr);
			charStr.setLength(0);
		}
		hwpfDocument = null;
		return sb;
	}

	/**
	 * 做法１：（解析为span样式的，这种做法只能用WebView方式加载，Html.fromHtml无效） Span样式 通过字体的样式进行加载
	 * 
	 * @param inputStream
	 * @return
	 */
	public static String readDocToSpanByRun(InputStream inputStream) {
		HWPFDocument hwpfDocument = null;
		if (inputStream == null)
			throw new RuntimeException("inputStream is null ...");
		try {
			hwpfDocument = new HWPFDocument(inputStream);
		} catch (Exception e) {
			throw new RuntimeException("HWPFDocment Exception", e);
		}
		Range allRange = hwpfDocument.getRange();
		int length = allRange.numCharacterRuns();
		StringBuffer sb = new StringBuffer();
		CharacterRun cur;
		String text = "";
		for (int i = 0; i < length; i++) {
			cur = allRange.getCharacterRun(i);
			sb.append(CharacterRunUtils.toSpanType(cur));
			text = CharacterRunUtils.getSpicalSysbomByRun(cur.text());
			if (cur.getSubSuperScriptIndex() == 1)
				sb.append("<sup>").append(text).append("</sup>");
			else if (cur.getSubSuperScriptIndex() == 2)
				sb.append("<sub>").append(text).append("</sub>");
			else
				sb.append(text);
			sb.append("</span>");
		}
		return sb.toString();
	}

	/**
	 * 比对字体是否相同 可以继续加其它属性
	 * 
	 * @param cr1
	 * @param cr2
	 * @return
	 */
	public static boolean compareCharStyleForSpan(CharacterRun cr1,
			CharacterRun cr2) {
		return cr1.isBold() == cr2.isBold()
				&& cr1.getFontName().equals(cr2.getFontName())
				&& cr1.getFontSize() == cr2.getFontSize()
				&& cr1.isItalic() == cr2.isItalic()
				&& cr1.getColor() == cr2.getColor()
				&& cr1.getUnderlineCode() == cr2.getUnderlineCode()
				&& cr1.isStrikeThrough() == cr2.isStrikeThrough()
				&& cr1.getColor() == cr2.getColor();
	}

	public static boolean compareCharColor(CharacterRun cr1, CharacterRun cr2) {
		return cr1.getFontName().equals(cr2.getFontName())
				&& cr1.getFontSize() == cr2.getFontSize()
				&& cr1.getColor() == cr2.getColor();
	}

	public static String getSpicalSysbom(char currentChar) {
		String tempStr = "";
		if (currentChar == ENTER_ASCII) {
			tempStr += "<br/>";
		} else {
			tempStr += currentChar;
		}
		return tempStr;
	}

	public static String getSpicalSysbomSpan(char currentChar) {
		String tempStr = "";
		if (currentChar == ENTER_ASCII) {
			tempStr += "<br/>";
		}
		return tempStr;
	}

	/**
	 * 特殊字符的取代
	 * 
	 * @param currentChar
	 * @return
	 */
	public static String getSpicalSysbomByRun(String currentChar) {
		StringBuffer tempStr = new StringBuffer();
		int length = currentChar.length();
		for (int i = 0; i < length; i++) {
			tempStr.append(getSpicalSysbom(currentChar.charAt(i)));
		}
		return tempStr.toString();
	}

	/**
	 * span方式前缀
	 * 
	 * @param cr
	 * @return
	 */
	public static String toSpanType(CharacterRun cr) {
		StringBuffer spanStyle = new StringBuffer("<span style='font-family:");
		spanStyle.append(cr.getFontName()).append("; font-size:")
				.append(cr.getFontSize() / 2).append("pt;");
		if (cr.isBold())
			spanStyle.append("font-weight:bold;");
		if (cr.isItalic())
			spanStyle.append("font-style:italic;");
		if (cr.isStrikeThrough())
			spanStyle.append("text-decoration:line-through;");
		if (cr.getUnderlineCode() != 0)
			spanStyle.append("text-decoration:underline;");
		spanStyle.append("color:")
				.append(ColorUtils.getHexColor(cr.getIco24())).append(";")
				.append("'>");
		return spanStyle.toString();
	}

	/**
	 * 为font方式提供<font前缀
	 * 
	 * @param cr
	 * @return
	 */
	public static String fontFaceColorSizeToHtml(CharacterRun cr) {
		StringBuffer htmlType = new StringBuffer("<font ");
		htmlType.append("size='").append(cr.getFontSize() / 2).append("' ")
				.append("face='").append(cr.getFontName()).append("' ")
				.append("color='")
				.append(ColorUtils.getHexColor(cr.getIco24())).append("'>");
		return htmlType.toString();
	}

	/**
	 * 处理上下标
	 * 
	 * @param cr
	 * @param currentChar
	 * @return
	 */
	public static String toSupOrSub(CharacterRun cr, String currentChar) {
		int sub = cr.getSubSuperScriptIndex();
		if (sub != 0) {
			if (sub == 1)
				// 上标
				return "<sup>" + currentChar + "</sup>";
			else
				// 下标
				return "<sub>" + currentChar + "</sub>";
		} else
			return currentChar;
	}

	public static String toSupOrSub(CharacterRun cr, char currentChar) {
		return toSupOrSub(cr, new String(new char[] { currentChar }));
	}
}
