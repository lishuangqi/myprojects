package com.lishuangqi.utils;

import org.apache.commons.io.FileUtils;
//import org.apache.poi.hwpf.HWPFDocument;
//import org.apache.poi.hwpf.converter.PicturesManager;
//import org.apache.poi.hwpf.converter.WordToHtmlConverter;
//import org.apache.poi.hwpf.usermodel.Picture;
//import org.apache.poi.hwpf.usermodel.PictureType;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.net.URL;
import java.util.List;

/**
 * 在线浏览
 * byte[]转成html
 * @author Administrator
 *
 */
public class PoiWordToHtml {
	public static void wordToHtml(byte[] content1) throws Exception {
//		PoiWordToHtml p = new PoiWordToHtml();
//		URL resource = p.getClass().getResource("/");
//		final String path = new File(resource.getFile(), "../../"+"/qcs/pages/qcsPlantemplate/").getCanonicalPath();
//		InputStream input = new ByteArrayInputStream(content1);
//		HWPFDocument wordDocument = new HWPFDocument(input);
//		WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
//				DocumentBuilderFactory.newInstance().newDocumentBuilder()
//						.newDocument());
//		wordToHtmlConverter.setPicturesManager(new PicturesManager() {
//			public String savePicture(byte[] content, PictureType pictureType,
//					String suggestedName, float widthInches, float heightInches) {
//				return suggestedName;
//			}
//		});
//		wordToHtmlConverter.processDocument(wordDocument);
//		List pics = wordDocument.getPicturesTable().getAllPictures();
//		if (pics != null) {
//			for (int i = 0; i < pics.size(); i++) {
//				Picture pic = (Picture) pics.get(i);
//				try {
//					pic.writeImageContent(new FileOutputStream(path
//							+ pic.suggestFullFileName()));
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		Document htmlDocument = wordToHtmlConverter.getDocument();
//		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//		DOMSource domSource = new DOMSource(htmlDocument);
//		StreamResult streamResult = new StreamResult(outStream);
//		TransformerFactory tf = TransformerFactory.newInstance();
//		Transformer serializer = tf.newTransformer();
//		serializer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
//		serializer.setOutputProperty(OutputKeys.INDENT, "yes");
//		serializer.setOutputProperty(OutputKeys.METHOD, "html");
//		serializer.transform(domSource, streamResult);
//		outStream.close();
//		String content = new String(outStream.toByteArray());
//		FileUtils.writeStringToFile(new File(path, "wordToHtml.html"), content,"ISO-8859-1");
	}

}
