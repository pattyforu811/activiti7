
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.macro.mall.dao.AdminDao;
import com.macro.mall.pojo.UmsAdmin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@SpringBootTest
public class UmsAdminTest {
    @Autowired
    private   AdminDao adminDao;

    @Test
    @Transactional
    @Rollback
    void addAdmin(){

    }

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<UmsAdmin> userList = adminDao.selectList(null);

       // Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
}
