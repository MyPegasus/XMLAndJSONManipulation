package com.example.mypegasus.xmlandjsonmanipulation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class MainActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text);
        /*try {
            InputStream is = getAssets().open("languages.xml");

            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(is);
            Element rootElement = document.getDocumentElement();

            NodeList list = rootElement.getElementsByTagName("lan");
            for (int i = 0; i < list.getLength(); i++) {
                Node item = list.item(i);
                Element lan = (Element) item;
                text.append("\n" + lan.getAttribute("id") + "\n");
                text.append(lan.getElementsByTagName("name").item(0).getTextContent() + "\n");
                text.append(lan.getElementsByTagName("ide").item(0).getTextContent() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }*/

        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();

            Document newXML = builder.newDocument();
            Element languages = newXML.createElement("Languages");
            languages.setAttribute("cat", "it");
            newXML.appendChild(languages);

            Element lan1 = newXML.createElement("lan");
            lan1.setAttribute("id", "1");
            Element name1 = newXML.createElement("name");
            name1.setTextContent("Java");
            Element ide1 = newXML.createElement("ide");
            ide1.setTextContent("Eclipse");
            lan1.appendChild(name1);
            lan1.appendChild(ide1);
            languages.appendChild(lan1);

            Element lan2 = newXML.createElement("lan");
            lan2.setAttribute("id", "2");
            Element name2 = newXML.createElement("name");
            name2.setTextContent("Swift");
            Element ide2 = newXML.createElement("ide");
            lan2.setTextContent("XCode");
            lan2.appendChild(name2);
            lan2.appendChild(ide2);
            languages.appendChild(lan2);

            Element lan3 = newXML.createElement("lan");
            lan3.setAttribute("id", "3");
            Element name3 = newXML.createElement("name");
            name3.setTextContent("C#");
            Element ide3 = newXML.createElement("ide");
            lan3.setTextContent("Visual Studio");
            lan3.appendChild(name3);
            lan3.appendChild(ide3);
            languages.appendChild(lan3);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty("encoding", "utf-8");

            StringWriter sw = new StringWriter();
            transformer.transform(new DOMSource(newXML), new StreamResult(sw));
            text.setText(sw.toString());
            sw.close();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
