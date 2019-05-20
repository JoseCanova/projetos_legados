package br.com.valid.bio.tests;


import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.config.EnableIntegrationManagement;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.support.PeriodicTrigger;

import br.com.valid.bio.conveniadas.abis.configuration.AbisConfiguration;

@SpringBootApplication
@EnableIntegration
@IntegrationComponentScan
@EnableIntegrationManagement
@EnableAutoConfiguration(exclude={RabbitAutoConfiguration.class})
public class ExpirablePeriodicTrigger extends PeriodicTrigger {

	private static final Logger logger = LoggerFactory.getLogger(AbisConfiguration.class);

    protected AtomicBoolean expired = new AtomicBoolean(false);

	public static void main(String[] args) {
		SpringApplication.run(ExpirablePeriodicTrigger.class, args);
	}
	
	public ExpirablePeriodicTrigger() {
		 super(1000);
	}
	
	@Bean
	public ExpirablePeriodicTrigger trigger() { 
		return new ExpirablePeriodicTrigger(1000);
	}
	
    public ExpirablePeriodicTrigger(long period) {
        super(period);
    }

    public ExpirablePeriodicTrigger(long period, TimeUnit timeUnit) {
        super(period, timeUnit);
    }

    public void expire() {
        expired.getAndSet(true);
    }

    public boolean isExpired() {
        return expired.get();
    }

    @Override
    public Date nextExecutionTime(TriggerContext triggerContext) {
        
        Date result;

        if (isExpired())
            result = null;

        else
            result = super.nextExecutionTime(triggerContext);

        if (logger.isDebugEnabled()) {
        	logger.debug(String.format("nextExecutionTime - expired: %s, result: %s",
                    expired, result));
        }

        return result;
    }
}
