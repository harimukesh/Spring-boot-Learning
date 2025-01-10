package com.example.springbootpractice;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "conditional" , value = "enabled" , havingValue = "true" , matchIfMissing = false)    //it should match with application.properties attributes
public class ConditionalProperty {
     ConditionalProperty() {
        System.out.println("ConditionalonProperty");
    }
}
