package com.thecitybank.soap;

import com.thecitybank.pojo.DataPDU;
import com.thecitybank.producer.*;
import com.thecitybank.utility.Constant;
import lombok.extern.slf4j.Slf4j;
import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.util.IteratorIterable;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Slf4j
@Endpoint
public class SOAPEndpoint {

    @PayloadRoot(namespace = Constant.NAMESPACE_URI, localPart = "send")
    @ResponsePayload
    public SendResponse send(@RequestPayload SendT request) {

        String message = request.getMessage().getBlock4();
        log.info("Response: {}", message);

        Document document =  convertStringToXml(message);



        ObjectFactory factory = new ObjectFactory();
        SendResponse response = factory.createSendResponse();
        ResultT resultT = new ResultT();
        resultT.setDatetime(new Date().toString());
        resultT.setType(AckNakType.ACK);
        resultT.setMir(request.getMessage().getMsgNetMir());
        response.setData(resultT);

        return response;
    }

    private Document convertStringToXml(String xmlString) {

        SAXBuilder sax = new SAXBuilder();

        sax.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        sax.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");

        try {

            Document doc = sax.build(new StringReader(xmlString));
            return doc;

        } catch (JDOMException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
