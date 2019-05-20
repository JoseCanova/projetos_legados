package org.nanotek.integration;

import org.nanotek.ws.xml.Artist;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

@MessageEndpoint
public class RecordingSelector implements MessageSelector {

	@Override
	@Filter
	public boolean accept(Message<?> message) {
		return ((Artist) message.getPayload()).getRecords().stream().anyMatch(r -> true);
	}
}
