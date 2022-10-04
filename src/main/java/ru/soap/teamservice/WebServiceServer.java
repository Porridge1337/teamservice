package ru.soap.teamservice;


import ru.soap.teamservice.config.LoggerConfig;
import ru.soap.teamservice.service.DaoGroup;
import ru.soap.teamservice.service.DaoRole;
import ru.soap.teamservice.service.DaoUser;
import ru.soap.teamservice.service.impl.DaoGroupImpl;
import ru.soap.teamservice.service.impl.DaoRoleImpl;
import ru.soap.teamservice.service.impl.DaoUserImpl;

import javax.xml.ws.Endpoint;
import java.io.IOException;
import java.util.logging.Logger;


public class WebServiceServer {
    private static Logger logger = Logger.getLogger(WebServiceServer.class.getName());


    public static void main(String[] args) throws IOException {
        LoggerConfig.initialize();
        String useruri = "http://localhost:9898/Users";
        String roleuri = "http://localhost:9898/Roles";
        String groupuri = "http://localhost:9898/Groups";

        DaoUser daoUser = new DaoUserImpl();
        DaoRole daoRole = new DaoRoleImpl();
        DaoGroup daoGroup = new DaoGroupImpl();

        Endpoint.publish(useruri, daoUser);
        Endpoint.publish(roleuri, daoRole);
        Endpoint.publish(groupuri, daoGroup);

        logger.info("Server started at: " + useruri + "?wsdl");
        logger.info("Server started at: " + roleuri + "?wsdl");
        logger.info("Server started at: " + groupuri + "?wsdl");
    }

}
