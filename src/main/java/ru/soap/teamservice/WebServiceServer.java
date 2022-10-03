package ru.soap.teamservice;

import ru.soap.teamservice.service.DaoGroup;
import ru.soap.teamservice.service.DaoRole;
import ru.soap.teamservice.service.DaoUser;
import ru.soap.teamservice.service.impl.DaoGroupImpl;
import ru.soap.teamservice.service.impl.DaoRoleImpl;
import ru.soap.teamservice.service.impl.DaoUserImpl;

import javax.xml.ws.Endpoint;
import java.util.logging.Logger;


public class WebServiceServer {
    private static Logger logger = Logger.getLogger(WebServiceServer.class.getName());

    public static void main(String[] args) {
        String bindingURI1 = "http://localhost:9898/team1";
        String bindingURI2 = "http://localhost:9898/team2";
        String bindingURI3 = "http://localhost:9898/team3";

        logger.info("This is level info logging");
        DaoUser daoUser = new DaoUserImpl();
        DaoRole daoRole = new DaoRoleImpl();
        DaoGroup group = new DaoGroupImpl();

        Endpoint.publish(bindingURI1, daoUser);
        Endpoint.publish(bindingURI2, daoRole);
        Endpoint.publish(bindingURI3, group);

        logger.info("Server started at: " + bindingURI1);
        logger.info("Server started at: " + bindingURI2);
        logger.info("Server started at: " + bindingURI3);


    }

}
