package br.com.valid.bio.conveniadas.abis.configuration.thread;


import java.util.Optional;
import java.util.concurrent.ThreadFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPoolConfiguration {

	public static final int MONGO_MAX_CONNECTIONS = 10000;
	
	@Bean(name="normalPriorityThreadFactory")
	@Qualifier(value="normalPriorityThreadFactory")
	public ThreadFactory normalPriorityThreadFactory() { 
		return constructThread(Thread.NORM_PRIORITY , false); 
	}
	
	@Bean(name="highPriorityThreadFactory")
	@Qualifier("highPriorityThreadFactory")
	public ThreadFactory highPriorityThreadFactory() { 
		return constructThread(Thread.MAX_PRIORITY , false); 
	}

	@Bean(name="lowPriorityThreadFactory")
	@Qualifier("lowPriorityThreadFactory")
	public ThreadFactory lowPriorityThreadFactory() { 
		return constructThread(Thread.MIN_PRIORITY , false); 
	}

	@Bean(name="mongoLowPriorityThreadFactory")
	@Qualifier("mongoLowPriorityThreadFactory")
	public ThreadFactory mongoLowPriorityThreadFactory() { 
		return constructThread(Thread.MIN_PRIORITY , false); 
	}
	
	@Bean(name="mongoHighPriorityThreadFactory")
	@Qualifier("mongoHighPriorityThreadFactory")
	public ThreadFactory mongoHighPriorityThreadFactory() { 
		return constructThread(Thread.MAX_PRIORITY , false); 
	}
	
	private ThreadFactory constructThread(final int priority , final Boolean daemon) { 
		return new ThreadFactory() { 
			@Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(Optional.ofNullable(daemon).orElse(false));
                t.setPriority(priority);
                return t;
            }
		};
	}
	
	@Bean(name="normalPriorityThreadPoolExecutor")
	@Qualifier(value="normalPriorityThreadPoolExecutor")
    public ThreadPoolTaskExecutor normalPriorityThreadPoolExecutor(@Autowired @Qualifier("normalPriorityThreadFactory") ThreadFactory threadFactory) { 
    	ThreadPoolTaskExecutor tpe =  new ThreadPoolTaskExecutor();
    	tpe.setCorePoolSize(20);
    	tpe.setMaxPoolSize(Integer.MAX_VALUE);
    	tpe.setThreadFactory(threadFactory);
    	return tpe;
    }
	
	@Bean(name="highPriorityThreadPoolExecutor")
	@Qualifier(value="highPriorityThreadPoolExecutor")
    public ThreadPoolTaskExecutor highPriorityThreadPoolExecutor(@Autowired @Qualifier("highPriorityThreadFactory") ThreadFactory threadFactory) { 
    	ThreadPoolTaskExecutor tpe =  new ThreadPoolTaskExecutor();
    	tpe.setCorePoolSize(100);
    	tpe.setMaxPoolSize(Integer.MAX_VALUE);
    	tpe.setThreadFactory(threadFactory);
    	return tpe;
    }

	@Bean(name="lowPriorityThreadPoolExecutor")
	@Qualifier(value="lowPriorityThreadPoolExecutor")
    public ThreadPoolTaskExecutor lowPriorityThreadPoolExecutor(@Autowired @Qualifier("lowPriorityThreadFactory") ThreadFactory threadFactory) { 
    	ThreadPoolTaskExecutor tpe =  new ThreadPoolTaskExecutor();
    	tpe.setCorePoolSize(100);
    	tpe.setMaxPoolSize(Integer.MAX_VALUE);
    	tpe.setThreadFactory(threadFactory);
    	return tpe;
    }
	
	@Bean(name="mongoLowPriorityThreadPoolExecutor")
	@Qualifier(value="mongoLowPriorityThreadPoolExecutor")
    public ThreadPoolTaskExecutor mongoLowPriorityThreadPoolExecutor(@Autowired @Qualifier("mongoLowPriorityThreadFactory") ThreadFactory threadFactory) { 
    	ThreadPoolTaskExecutor tpe =  new ThreadPoolTaskExecutor();
    	tpe.setCorePoolSize(100);
    	tpe.setMaxPoolSize(MONGO_MAX_CONNECTIONS);
    	tpe.setThreadFactory(threadFactory);
    	return tpe;
    }
	
	@Bean(name="mongoHighPriorityThreadPoolExecutor")
	@Qualifier(value="mongoHighPriorityThreadPoolExecutor")
    public ThreadPoolTaskExecutor mongoHighPriorityThreadPoolExecutor(@Autowired @Qualifier("mongoHighPriorityThreadFactory") ThreadFactory threadFactory) { 
    	ThreadPoolTaskExecutor tpe =  new ThreadPoolTaskExecutor();
    	tpe.setCorePoolSize(100);
    	tpe.setMaxPoolSize(MONGO_MAX_CONNECTIONS);
    	tpe.setThreadFactory(threadFactory);
    	return tpe;
    }
}