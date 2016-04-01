package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.domain.SUser;
import com.springboot.service.Appctx;
import com.springboot.service.SUserService;

@SpringBootApplication
public class Application {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		Appctx.ctx = app.run(args);// 将密码加密 必须保证数据库s_user中有id为1的用户//code14
		SUserService suserService = (SUserService) Appctx.ctx
				.getBean("suserService");
		SUser su = suserService.findUserById(1);
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder(4);
		su.setPassword(bc.encode("111111"));
		suserService.update(su);
	}
}
