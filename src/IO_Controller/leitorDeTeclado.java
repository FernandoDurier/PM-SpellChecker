/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO_Controller;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import keyboard.layout;

/**
 *
 * @author Cliente
 */
public class leitorDeTeclado {
    
    private ArrayList<layout> listaDeTeclados = new ArrayList<layout>();
    
    public ArrayList<layout> getLayoutTecladoDoXML(){
         try {

	File fXmlFile = new File("./KeyboardLayouts.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);

	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

	NodeList nList = doc.getElementsByTagName("layout");

	//System.out.println("----------------------------");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);

		//System.out.println("\nCurrent Element :" + nNode.getNodeName());

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        layout lteclado = new layout();
			Element eElement = (Element) nNode;
                        //System.out.println("Model: " + eElement.getAttribute("model"));
                        lteclado.setTipo(eElement.getAttribute("model"));
			//System.out.println("line1 :" + eElement.getChildNodes().item(1).getTextContent());
                        lteclado.setLine1(eElement.getChildNodes().item(1).getTextContent());
                        //System.out.println("line2 :" + eElement.getChildNodes().item(3).getTextContent());
                        lteclado.setLine2(eElement.getChildNodes().item(3).getTextContent());
                        if(eElement.getChildNodes().item(3).getAttributes().getNamedItem("offset") != null){
                        //System.out.println("offset2 :" + eElement.getChildNodes().item(3).getAttributes().getNamedItem("offset").getNodeValue());
                        lteclado.setOffset2(Double.parseDouble(eElement.getChildNodes().item(3).getAttributes().getNamedItem("offset").getNodeValue()));
                        }
                        else{
                        //System.out.println("offset2 : 0");
                        lteclado.setOffset2(0);
                        }
                        
                        //System.out.println("line3 :" + eElement.getChildNodes().item(5).getTextContent());
                        lteclado.setLine3(eElement.getChildNodes().item(5).getTextContent());
                        if(eElement.getChildNodes().item(3).getAttributes().getNamedItem("offset") != null){
                        //System.out.println("offset3 :" + eElement.getChildNodes().item(5).getAttributes().getNamedItem("offset").getNodeValue());
                        lteclado.setOffset3(Double.parseDouble(eElement.getChildNodes().item(5).getAttributes().getNamedItem("offset").getNodeValue()));
                        }
                        else{
                        //System.out.println("offset3 : 0");
                        lteclado.setOffset3(0);
                        }
                        listaDeTeclados.add(lteclado);
			

		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
         listaDeTeclados.add(new layout("Neutro","","","",1,1));
         return listaDeTeclados;
    }
   
}
