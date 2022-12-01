package com.liferay.hook;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;

/**
 * @author root318
 */
public class DemohookStartupAction extends SimpleAction {

	@Override
	public void run(String[] lifecycleEventIds) throws ActionException {
		for (String eventId : lifecycleEventIds) {
			System.out.println("Startup event ID " + eventId);
		}
	}

}