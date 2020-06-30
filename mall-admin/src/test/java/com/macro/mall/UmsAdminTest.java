package com.macro.mall;

import com.macro.mall.entity.UmsAdmin;
import com.macro.mall.mapper.UmsAdminMapper;
import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.runtime.TaskRuntime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UmsAdminTest {

    private final Logger logger = LoggerFactory.getLogger(UmsAdminTest.class);


    @Autowired
    private UmsAdminMapper adminDao;

    @Test
//    @Transactional
//    @Rollback
    public  void addAdmin(){

    }

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<UmsAdmin> userList = adminDao.selectList(null);

        // Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }






    @Autowired
    private ProcessRuntime processRuntime;
    @Autowired
    private TaskRuntime taskRuntime;

    @Test
    public void ProcessDefinition() {

        org.activiti.api.runtime.shared.query.Page<ProcessDefinition> processDefinitionPage = processRuntime.processDefinitions(Pageable.of(0, 10));
        logger.info("> Available Process definitions: " + processDefinitionPage.getTotalItems());
        for (ProcessDefinition pd : processDefinitionPage.getContent()) {
            logger.info("\t > Process definition: " + pd);
        }
    }
}

