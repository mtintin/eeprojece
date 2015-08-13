package cn.net.domain.util;

import cn.net.domain.entity.Question;
import cn.net.domain.vo.QuestionCategory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Range;

public class WordQuestion {
	static QuestionCategory questypesta = new QuestionCategory();
	static StringBuffer sBuffer = new StringBuffer();
	public static QuestionCategory getQuestionTypecal(String path) {
		try {
		questypesta.setName("exam");	
		getWord(new File(path),
					questypesta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questypesta;

	}
	
	@SuppressWarnings("rawtypes")
	public static List getQuestions() {	
		List<Question> list = new ArrayList<Question>();
		
		try {
			iterator(questypesta, list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
  //遍历 word dir
	private static void iterator(QuestionCategory questypest, List<Question> list)
			throws Exception {
		List<QuestionCategory> questionTypes = questypest.getQcategorys();
                 
		if (questypest.flag) {
			list.addAll(PraseWord(questypest));
		}
		if (questionTypes != null && questionTypes.size() > 0) {
			for (int i = 0; i < questionTypes.size(); i++) {
				iterator(questionTypes.get(i), list);
			}
                        
                        
                        
                       
		}

	}
	
   //获取word dir
	private static void getWord(File file, QuestionCategory questypepatten)
			throws Exception {
		if (file == null)
			return;
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			QuestionCategory questype = new QuestionCategory();
			
			if (files[i].isDirectory()) {
				questype.setName(files[i].getName());
                                questype.setQcategory(questypepatten);
				questypepatten.getQcategorys().add(questype);
				getWord(files[i], questype);
			} else {
				String name = files[i].getName().replace(".doc", "");
				questype.setName(name);
				questype.wordnames=files[i].getAbsolutePath();
				questype.flag = true;
                                questype.setQcategory(questypepatten);
				questypepatten.getQcategorys().add(questype);
			}
		}
	}

	//获取word 题目
	private static List<Question> PraseWord(QuestionCategory questypest) throws Exception {
          
			return getQuestions(questypest.wordnames, questypest.getId());

	}
	

	//获取试卷
	private static List<Question> getQuestions(String path, long id)
			throws Exception {
          
		if (!new File(path).exists()) {
			return null;
		}
		List<Question> list = new ArrayList<Question>();
		InputStream inputStream = new FileInputStream(path);
		HWPFDocument hwpfDocument = new HWPFDocument(inputStream);
		CharacterRun cur = null;
		Range allRange = hwpfDocument.getRange();
		StringBuffer charStr = new StringBuffer();
		if (sBuffer == null) {
			sBuffer = new StringBuffer();
		}
		for (int i = 0; i < allRange.numCharacterRuns(); i++) {
			cur = allRange.getCharacterRun(i);
			String temp = CharacterRunUtils.toSupOrSub(cur, CharacterRunUtils
					.getSpicalSysbomByRun(cur.text()));
			// 所有空格去掉，所有全角点替换为半角点
			charStr.append(temp.trim().replaceAll(" ", "").replaceAll("　", "")
					.replaceAll("．", "."));
			sBuffer.append(charStr);
			while (sBuffer.toString().contains("<br/><br/>")) {
				String end = sBuffer.substring(
						sBuffer.indexOf("<br/><br/>") + 10).toString();
				sBuffer.delete(sBuffer.indexOf("<br/><br/>") + 10, sBuffer
						.length());
				list.add(getQue(id, sBuffer,path));
				sBuffer.setLength(0);
				sBuffer.append(end);
			}
			charStr.setLength(0);
		}
		hwpfDocument = null;
		return list;
	}

	//获取题目
	private static Question getQue(long typeId, StringBuffer sBuffer,String path)
			throws UnsupportedEncodingException {
		String question = "";
		String optionA = "";
		String optionB = "";
		String optionC = "";
		String optionD = "";
		String optionE = "";
		String answer = "";
		String analysis = "";
		if (sBuffer.toString().contains("A.")) {
			question = sBuffer.substring(0, sBuffer.indexOf("A."));
			sBuffer.delete(0, sBuffer.indexOf("A."));
		} else if (sBuffer.toString().contains("a.")) {
			question = sBuffer.substring(0, sBuffer.indexOf("a."));
			sBuffer.delete(0, sBuffer.indexOf("a."));
		}

		if (sBuffer.toString().contains("B.")) {
			optionA = sBuffer.substring(0, sBuffer.indexOf("B."));
			sBuffer.delete(0, sBuffer.indexOf("B."));
		} else if (sBuffer.toString().contains("b.")) {
			optionA = sBuffer.substring(0, sBuffer.indexOf("b."));
			sBuffer.delete(0, sBuffer.indexOf("b."));
		}

		if (sBuffer.toString().contains("C.")) {
			optionB = sBuffer.substring(0, sBuffer.indexOf("C."));
			sBuffer.delete(0, sBuffer.indexOf("C."));
		} else if (sBuffer.toString().contains("c.")) {
			optionB = sBuffer.substring(0, sBuffer.indexOf("c."));
			sBuffer.delete(0, sBuffer.indexOf("c."));
		}

		if (sBuffer.toString().contains("D.")) {
			optionC = sBuffer.substring(0, sBuffer.indexOf("D."));
			sBuffer.delete(0, sBuffer.indexOf("D."));
		} else if (sBuffer.toString().contains("d.")) {
			optionC = sBuffer.substring(0, sBuffer.indexOf("d."));
			sBuffer.delete(0, sBuffer.indexOf("d."));
		}

		if (sBuffer.toString().contains("E.")) {
			optionD = sBuffer.substring(0, sBuffer.indexOf("E."));
			sBuffer.delete(0, sBuffer.indexOf("E."));
		} else if (sBuffer.toString().contains("e.")) {
			optionD = sBuffer.substring(0, sBuffer.indexOf("e."));
			sBuffer.delete(0, sBuffer.indexOf("e."));
		}

		if (sBuffer.toString().contains("<br/>")) {
			optionE = sBuffer.substring(0, sBuffer.indexOf("<br/>"));
			sBuffer.delete(0, sBuffer.indexOf("<br/>") + 5);
		}
		if (sBuffer.toString().contains("<br/>")) {
			answer = sBuffer.substring(0, sBuffer.indexOf("<br/>"));
		}

		if (sBuffer.toString().contains("【解析】")) {
			analysis = sBuffer.substring(0, sBuffer.indexOf("<br/>"));
			sBuffer.setLength(0);
		}
		Question que = new Question();
		question = question.replace("<br/>", "");
		optionA = optionA.replace("<br/>", "");
		optionB = optionB.replace("<br/>", "");
		optionC = optionC.replace("<br/>", "");
		optionD = optionD.replace("<br/>", "");
		que.setTitle(question);
		que.setChecka(optionA);
		que.setCheckb(optionB);
		que.setCheckc(optionC);
		que.setCheckd(optionD);
		que.setChecke(optionE);
		que.setAnswer(answer);
		que.setNote(analysis);
		que.setQuestionCategory(typeId);
                if(path.contains("多选题"))
                    que.setType(1);
		return que;
	}


}
