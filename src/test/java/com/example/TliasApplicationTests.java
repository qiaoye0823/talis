package com.example;

import com.example.controller.DeptController;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TliasApplicationTests {

    /*
    生成JWT令牌
     */
    @Test
    public void testGenJWT(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "tom");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "jodie") // 签名算法a
                .setClaims(claims) // 设置自定义内容
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 设置有效期一个小时
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void testParseJWT(){
        Claims claims = Jwts.parser()
                .setSigningKey("jodie")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY4NzA1ODQxOX0.oXCEvLiAjhvjpk0w2FNXq-FdKskCAfhYnHWz0kgP-Lw")
                .getBody();
        System.out.println(claims);
    }

    @Autowired
    private ApplicationContext applicationContext; // IOC 容器对象
    @Test
    public void testGetBean(){
        // 根据bean的名称获取
        DeptController bean1 = (DeptController) applicationContext.getBean("deptController");
        System.out.println(bean1);

        // 根据bean的类型获取
        DeptController bean2 = applicationContext.getBean(DeptController.class);
        System.out.println(bean2);

        // 根据bean的名称及类型获取
        DeptController bean3 = applicationContext.getBean("deptController", DeptController.class);
        System.out.println(bean3);
    }
}
