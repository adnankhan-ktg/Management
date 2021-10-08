package com.management.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TestService {

  private static final Logger log = LoggerFactory.getLogger(TestService.class);

//  @Scheduled(initialDelay = 1000, fixedDelay = 3000)
  @Scheduled(cron = "*/5 54 * * * *")
  public String print()
  {
    log.info("hello : {}",new Date());
    return "status-1";

  }
}
