package com.anchtun.keycloak.demo;

import org.keycloak.authentication.RequiredActionContext;
import org.keycloak.authentication.RequiredActionProvider;
import org.keycloak.connections.jpa.JpaConnectionProvider;
import org.keycloak.models.jpa.entities.UserAttributeEntity;
import org.keycloak.models.jpa.entities.UserEntity;

import jakarta.ws.rs.core.MultivaluedMap;
import lombok.extern.slf4j.Slf4j;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Slf4j
public class FeelingSurveyRequiredActionProvider implements RequiredActionProvider {

    @Override
    public void evaluateTriggers(RequiredActionContext context) {
        var now = LocalDate.now();
        // trigger this every Monday
        if (now.getDayOfWeek() == DayOfWeek.MONDAY && !now.toString().equals(context.getUser().getFirstAttribute("last_triggered_date"))) {
            context.getUser().addRequiredAction("feeling-survey");
            // I had to add this, otherwise the action will be triggered indefinitely on Mondays
            // and the user will not be able to use the app, we need a condition to escape after the first add
            addAttribute(context, "last_triggered_date", LocalDate.now().toString());
        }
    }

    // create a form for this context
    @Override
    public void requiredActionChallenge(RequiredActionContext context) {
        context.challenge(context.form().createForm("how-do-you-feel.ftl"));
    }

    // user accepted or or skipped.
    @Override
    public void processAction(RequiredActionContext context) {
    	MultivaluedMap<String, String> formData = context.getHttpRequest().getDecodedFormParameters();
    	String skip = formData.getFirst("skip");
    	String feeling = formData.getFirst("feeling");
    	log.info("skipValue= " + skip);
        if (skip != null) {
            context.success();
            return;
        }
        log.info("feelingValue= " + feeling);
        addAttribute(context, "feeling", Objects.isNull(feeling) ? null : feeling);
        context.success();
    }

    @Override
    public void close() {

    }

    private void addAttribute(RequiredActionContext context, String attributeName, String attributeValue) {
        var entityManager = context.getSession().getProvider(JpaConnectionProvider.class).getEntityManager();
        var lastSurveyDate = new UserAttributeEntity();
        lastSurveyDate.setName(attributeName);
        lastSurveyDate.setValue(attributeValue);
        var userEntity = new UserEntity();
        userEntity.setId(context.getUser().getId());
        lastSurveyDate.setUser(userEntity);
        lastSurveyDate.setId(UUID.randomUUID().toString());
        entityManager.persist(lastSurveyDate);
    }
}