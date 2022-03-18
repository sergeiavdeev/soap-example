package ru.avdeev.soap.example.ws;

import mobilesmarts.cleverence.DeviceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.pecom.ws.esb.collectdelivery.cargoreceipt.CargoInfoResponse;
import ru.pecom.ws.esb.collectdelivery.cargoreceipt.ObjectFactory;

import java.math.BigInteger;

@Endpoint
public class TerminalReceiptEndpoint {

    private static final String NAMESPACE = "http://collectdelivery.esb.ws.pecom.ru/cargoreceipt";
    private static final Logger logger = LoggerFactory.getLogger(TerminalReceiptEndpoint.class);

    public TerminalReceiptEndpoint() {
        logger.info("TerminalReceiptEndpoint init...");
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "CargoInfo")
    @ResponsePayload
    public CargoInfoResponse cargoInfo(
            @RequestPayload String barcode,
            @RequestPayload String warehouseId,
            @RequestPayload DeviceInfo deviceInfo) {

        logger.info("cargoInfo handle...");
        ObjectFactory factory = new ObjectFactory();
        CargoInfoResponse response = factory.createCargoInfoResponse();

        mobilesmarts.cleverence.CargoInfo info = new mobilesmarts.cleverence.CargoInfo();
        info.setCount(BigInteger.valueOf(10));
        response.setReturn(info);

        return response;
    }
}
