package com.optimagrowth.license.events.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;

import com.optimagrowth.license.events.CustomChannels;
import com.optimagrowth.license.events.model.OrganizationChangeModel;

import java.util.function.Consumer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

//@EnableBinding(CustomChannels.class)
@Service
public class OrganizationChangeHandler {

    private static final Logger logger = LoggerFactory.getLogger(OrganizationChangeHandler.class);

    //@StreamListener("inboundOrgChanges")
    @Bean
    public Consumer<OrganizationChangeModel> organizationChange() {
        logger.debug("######## CONSUMER CALLED ##########");
    	return organization -> {
            try {
                logger.debug("Received a message of type " + organization.getType());
                
                switch(organization.getAction()){
                    case "GET":
                        logger.debug("Received a GET event from the organization service for organization id {}", organization.getOrganizationId());
                        break;
                    case "SAVE":
                        logger.debug("Received a SAVE event from the organization service for organization id {}", organization.getOrganizationId());
                        break;
                    case "UPDATE":
                        logger.debug("**** Received a UPDATE event from the organization service for organization id {}", organization.getOrganizationId());
                        break;
                    case "DELETE":
                        logger.debug("Received a DELETE event from the organization service for organization id {}", organization.getOrganizationId());
                        break;
                    default:
                        logger.error("Received an UNKNOWN event from the organization service of type {}", organization.getType());
                        break;
                }
            } catch (Exception e) {
                logger.error("ERROR GETTING MESSAGE "+e);
            }
        };
    }


}
