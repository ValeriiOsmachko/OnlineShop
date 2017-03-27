package com.epam.osmachko.xml_parser;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.epam.osmachko.bean.SequrityBean;
import com.epam.osmachko.sequrity.SequrityBeanContainer;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XmlParser {

	
	public SequrityBeanContainer parseXMLWithXStream() throws FileNotFoundException {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("SequrityBean", SequrityBean.class);
        xstream.alias("SequrityBeanContainer", SequrityBeanContainer.class);
        xstream.processAnnotations(SequrityBeanContainer.class);
        xstream.processAnnotations(SequrityBean.class);
        InputStream in = new FileInputStream(this.getClass().getResource("/sequrity.xml").getFile());
        SequrityBeanContainer var = (SequrityBeanContainer) xstream.fromXML(in);
        return var;
		
	}
	
	
}
