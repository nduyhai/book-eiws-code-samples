package net.lkrnac.book.eiws.chapter08;

import lombok.extern.slf4j.Slf4j;
import net.lkrnac.book.eiws.chapter08.in.SiWrapperService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@Slf4j
@SpringBootApplication
@ImportResource("classpath:si-config.xml")
public class SiApplication {
  public static void main(String[] args) throws InterruptedException {
    ApplicationContext ctx = SpringApplication.run(SiApplication.class, args);

    SiWrapperService wrapperService = ctx.getBean(SiWrapperService.class);
    boolean resultSuccess =
        wrapperService.processText("messageSuccess;messageFail;messageSuccess");
    log.info("Result: " + resultSuccess);

    boolean resultFail =
        wrapperService.processText("messageSuccess;messageFail;");
    log.info("Result: " + resultFail);
  }
}
