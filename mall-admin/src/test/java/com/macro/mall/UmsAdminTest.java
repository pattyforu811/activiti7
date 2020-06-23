package com.macro.mall;

import com.macro.mall.entity.UmsAdmin;
import com.macro.mall.mapper.UmsAdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UmsAdminTest {
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
}

