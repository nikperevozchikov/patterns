package strategy;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

public class StrategyDOM implements Strategy {
    @Override
    public void parsing(String inputFile, String outputFile) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputFile);


            NodeList nodeList = document.getElementsByTagName("student");
            NodeList nodeList2 = nodeList.item(0).getChildNodes();
            int sum = 0;
            int count = 0;
            double docAverage = 0;
            NamedNodeMap attributes;

            for (int i = 0; i < nodeList2.getLength(); i++) {

                attributes = nodeList2.item(i).getAttributes();

                if (nodeList2.item(i).getNodeName().equals("subject") && attributes != null) {
                    count++;
                    sum+=  Integer.parseInt(attributes.getNamedItem("mark").getNodeValue());
                    System.out.println(
                            "title-----" + attributes.getNamedItem("title").getNodeValue() +
                                    " mark-----" + attributes.getNamedItem("mark").getNodeValue()
                    );
                } else if (nodeList2.item(i).getNodeName().equals("average")) {
                    docAverage=Double.parseDouble(nodeList2.item(i).getFirstChild().getNodeValue());
                    System.out.println(
                            "average-----" + nodeList2.item(i).getFirstChild().getNodeValue()
                    );
                }
            }

            double trueAverage = (double) sum / count;
            System.out.println("docAverage:" + docAverage + " trueAverage:" + trueAverage);


            if (trueAverage != docAverage) {
                NodeList nodeList3 = document.getElementsByTagName("average");
                nodeList3.item(0).getFirstChild().setNodeValue(String.valueOf(trueAverage));
                System.out.println("In input file " + inputFile + " bad average "
                        + docAverage + " replaced on " + trueAverage);
            }

            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(outputFile);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(domSource, streamResult);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
