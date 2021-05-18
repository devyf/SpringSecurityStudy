package com.fengye.securityspringboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SecuritySpringbootApplicationTests {

    @Test
    public void testBCryptPasswordEncoder() {
        //对原始密码加密
        String saltPassword = BCrypt.hashpw("123", BCrypt.gensalt());
        System.out.println(saltPassword);
        //检验原始密码和BCrypt密码是否一致，加密加盐后的值
        boolean res = BCrypt.checkpw("123", "$2a$10$lVKKazLSJncZ5fPYV1TjEOKHliXt7Xo.IeTuFUktEcOHoqEigCSXu");
        System.out.println(res);
    }

}
