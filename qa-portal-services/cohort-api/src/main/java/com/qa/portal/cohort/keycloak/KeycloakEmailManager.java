package com.qa.portal.cohort.keycloak;

import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.qa.portal.common.email.QaEmailClient;


@Component
public class KeycloakEmailManager {
	public static final String QA_PORTAL_ACCOUNT_SETUP_EMAIL_SUBJECT = "QA Portal Account Setup";
	
	public static final String QA_ACCOUNT_SETUP_MESSAGE_BODY_PROPERTY = "qa.account.setup.message.body";

    public static final String QA_ACCOUNT_SETUP_MESSAGE_URL_PROPERTY = "qa.account.setup.message.url";
    
    private QaEmailClient qaEmailClient;
    
    private Environment environment;
    
    public KeycloakEmailManager(QaEmailClient qaEmailClient, Environment environment) {
    	this.qaEmailClient = qaEmailClient;
    	this.environment = environment;
    }
    
    private String getEmailBody(UserRepresentation userRepresentation) {
        String emailBody = String.format(environment.getProperty(QA_ACCOUNT_SETUP_MESSAGE_BODY_PROPERTY),
                environment.getProperty(KeycloakEmailManager.QA_ACCOUNT_SETUP_MESSAGE_URL_PROPERTY),
                userRepresentation.getUsername(),
                userRepresentation.getCredentials().get(0).getValue());
        return emailBody;
    }
    
    public void sendEmail(UserRepresentation userRepresentation) {
        qaEmailClient.sendEmail(userRepresentation.getUsername(),
                QA_PORTAL_ACCOUNT_SETUP_EMAIL_SUBJECT,
                getEmailBody(userRepresentation));
    }

}
