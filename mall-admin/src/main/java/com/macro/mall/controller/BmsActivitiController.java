package com.macro.mall.controller;

import io.swagger.annotations.Api;
import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.runtime.TaskRuntime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    /**
     * process definitions
     */
    @GetMapping("/processDefinition")
//    @PreAuthorize("hasAuthority('pms:brand:read')")//有权限
    public void processDefinition() {
        Page<ProcessDefinition> processDefinitionPage = processRuntime.processDefinitions(Pageable.of(0, 10));
        logger.info("> Available Process definitions: " + processDefinitionPage.getTotalItems());
        for (ProcessDefinition pd : processDefinitionPage.getContent()) {
            logger.info("\t > Process definition: " + pd);
        }
    }
}
