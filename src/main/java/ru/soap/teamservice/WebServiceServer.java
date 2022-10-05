package ru.soap.teamservice;


import ru.soap.teamservice.config.LoggerConfig;
import ru.soap.teamservice.service.DaoGroup;
import ru.soap.teamservice.service.DaoRole;
import ru.soap.teamservice.service.DaoUser;
import ru.soap.teamservice.service.impl.DaoGroupImpl;
import ru.soap.teamservice.service.impl.DaoRoleImpl;
import ru.soap.teamservice.service.impl.DaoUserImpl;

import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;


public class WebServiceServer {
    private static Logger logger = Logger.getLogger(WebServiceServer.class.getName());


    public static void main(String[] args) {
        LoggerConfig.initialize();
        String useruri = "http://localhost:9898/Users";
        String roleuri = "http://localhost:9898/Roles";
        String groupuri = "http://localhost:9898/Groups";

        DaoUser daoUser = new DaoUserImpl();
        DaoRole daoRole = new DaoRoleImpl();
        DaoGroup daoGroup = new DaoGroupImpl();

        Endpoint user = Endpoint.publish(useruri, daoUser);
        Endpoint role = Endpoint.publish(roleuri, daoRole);
        Endpoint group = Endpoint.publish(groupuri, daoGroup);
        List<Endpoint> endpointList = new ArrayList<>();
        endpointList.add(user);
        endpointList.add(role);
        endpointList.add(group);

        logger.info("Server started at: " + useruri + "?wsdl");
        logger.info("Server started at: " + roleuri + "?wsdl");
        logger.info("Server started at: " + groupuri + "?wsdl");
        logger.info("press <enter> to stop the services.");

        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        sc.close();
        endpointList.stream().forEach(endpoint -> endpoint.stop());
        logger.info("All services has been stopped.");

    }

}
