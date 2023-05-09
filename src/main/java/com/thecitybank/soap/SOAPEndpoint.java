package com.thecitybank.soap;

import com.thecitybank.producer.*;
import com.thecitybank.utility.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;


@Slf4j
@Endpoint
public class SOAPEndpoint {

    @PayloadRoot(namespace = Constant.NAMESPACE_URI, localPart = "send")
    @ResponsePayload
    public SendResponse send(@RequestPayload SendT request) {

        String message = request.getMessage().getBlock4();
        log.info("Request: {}", message);

        Document document = stringToDom(message);
        Node body = document.getDocumentElement().getElementsByTagName("Body").item(0);
        NodeList list = body.getChildNodes();
        Node AppHdr = list.item(1);
        String mir = AppHdr.getChildNodes().item(5).getTextContent().trim();
        log.info("MIR: {}", mir);

        ObjectFactory factory = new ObjectFactory();
        SendResponse response = factory.createSendResponse();
        ResultT resultT = new ResultT();
        resultT.setDatetime(toDate());
        resultT.setType(AckNakType.ACK);
        resultT.setMir(mir);
        response.setData(resultT);

        log.info("Response: {}", response);

        return response;
    }

    public Document stringToDom(String xmlSource) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new InputSource(new StringReader(xmlSource)));
        } catch (ParserConfigurationException | IOException | SAXException e) {
         throw new RuntimeException(e);
        }
    }

    private String toDate(){

        SimpleDateFormat formatter = new SimpleDateFormat("YYMMdd");
        return formatter.format(new Date());
    }
}
