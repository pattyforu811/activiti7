package com.macro.mall.controller;

import io.swagger.annotations.Api;
import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.process.runtime.connector.Connector;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.runtime.TaskRuntime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * activitiTest
 *
 * @author patty
 * @since 2020-06-19 14:40:27
 */
@Api(tags = "Activiti测试")
@Validated
@RestController
@RequestMapping("activiti")
//@PreAuthorize("hasRole('ACTIVITI_USER')")
public class BmsActivitiController {
    private Logger logger = LoggerFactory.getLogger(BmsActivitiController.class);

    @Autowired
    private ProcessRuntime processRuntime;
    @Autowired
    private TaskRuntime taskRuntime;

    @PostMapping("/documents")
    public String processFile(@RequestBody String content) {

        ProcessInstance processInstance = processRuntime.start(ProcessPayloadBuilder
                .start()
                .withProcessDefinitionKey("categorizeProcess")
                .withVariable("fileContent",content) //可省
                .build());
        String message = ">>> Created Process Instance: " + processInstance;
        System.out.println(message);
        return message;
    }


    @GetMapping("/process-definitions")
    public List<ProcessDefinition> getProcessDefinition(){
        return processRuntime.processDefinitions(Pageable.of(0, 100)).getContent();
   /*     Page<ProcessDefinition> processDefinitionPage = processRuntime.processDefinitions(Pageable.of(0, 10));
        logger.info("> Available Process definitions: " + processDefinitionPage.getTotalItems());
        for (ProcessDefinition pd : processDefinitionPage.getContent()) {
            logger.info("\t > Process definition: " + pd);
        }*/
    }

    @Bean
    public Connector processTextConnector() {
        return integrationContext -> {
            Map<String, Object> inBoundVariables = integrationContext.getInBoundVariables();
            String contentToProcess = (String) inBoundVariables.get("fileContent");
            // Logic Here to decide if content is approved or not
            if (contentToProcess.contains("activiti")) {
                integrationContext.addOutBoundVariable("approved",
                        true);
            } else {
                integrationContext.addOutBoundVariable("approved",
                        false);
            }
            return integrationContext;
        };
    }


}
