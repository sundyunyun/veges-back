package dhu.sun.vege.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * mapper的单元测试
 *
 * @author Tan Jie
 * @date 2017/12/10
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RoleMapperTest {

    @Autowired
    private RoleMapper roleMapper;

    /*@Before
    public void before() throws Exception{
        String[] s = {"1","2"};
        Application.main(s);
    }*/
    @Test
    public void selectListByUserId() throws Exception {
        //List<Role> roles = roleMapper.selectListByUserId(1L);
        //System.out.println("\n" + roles + "\n");
    }

}