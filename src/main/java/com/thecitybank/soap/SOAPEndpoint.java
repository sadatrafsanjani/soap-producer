package com.thecitybank.soap;

import com.thecitybank.producer.ObjectFactory;
import com.thecitybank.producer.ResultT;
import com.thecitybank.producer.SendResponse;
import com.thecitybank.producer.SendT;
import com.thecitybank.utility.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Slf4j
@Endpoint
public class SOAPEndpoint {

    @PayloadRoot(namespace = Constant.NAMESPACE_URI, localPart = "send")
    @ResponsePayload
    public SendResponse send(@RequestPayload SendT request) {

        log.info("Response: {}", request.getMessage().getBlock4());

        ObjectFactory factory = new ObjectFactory();
        SendResponse response = factory.createSendResponse();
        ResultT test = new ResultT();
        test.setCode("ACK");
        test.setDatetime("ACK");
        response.setData(test);

        return response;
    }
}
