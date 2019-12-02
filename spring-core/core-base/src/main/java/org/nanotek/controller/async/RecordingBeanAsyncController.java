package org.nanotek.controller.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.nanotek.beans.csv.RecordingBean;
import org.nanotek.service.http.RecordingBeanHttpClientService;
import org.nanotek.service.mq.RecordingBeanDispatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class RecordingBeanAsyncController {

	@Autowired
	RecordingBeanHttpClientService httpService;

	@Autowired
	RecordingBeanDispatcherService dispatcher;

	@RequestMapping("/recording_bean/run")
	public String run() throws InterruptedException, ExecutionException	{

		StringBuffer log = new StringBuffer();

		Future<RecordingBean> process1 = null;
		do{
			process1 = httpService.process();
			while(!process1.isDone()){
				Thread.sleep(5);
			}
			if (process1.get() !=null) { 
				dispatcher.dispatch(process1.get());
			}
		}while (process1 !=null && process1.get() != null);
		log.append("<br />Process 1 finished");
		return log.toString();
	}
}
