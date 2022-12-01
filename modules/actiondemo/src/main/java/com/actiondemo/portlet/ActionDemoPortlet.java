package com.actiondemo.portlet;

import com.actiondemo.constants.ActionDemoPortletKeys;

import com.actiondemo.model.Entry;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author root328
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ActionDemo",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ActionDemoPortletKeys.ACTIONDEMO,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ActionDemoPortlet extends MVCPortlet {

	@ProcessAction(name = "addEntry")
	public void addEntry(ActionRequest request, ActionResponse response) {
		try {
			PortletPreferences prefs = request.getPreferences();

			String[] guestbookEntries = prefs.getValues("user-data",
					new String[1]);

			ArrayList<String> entries = new ArrayList<String>();

			if (guestbookEntries[0] != null) {
				entries = new ArrayList<String>(Arrays.asList(prefs.getValues(
						"user-data", new String[1])));
			}

			String userName = ParamUtil.getString(request, "name");
			String message = ParamUtil.getString(request, "message");
			String entry = userName + "^" + message;

			entries.add(entry);

			System.out.println("User Data List is :" + entries );
			String[] array = entries.toArray(new String[entries.size()]);

			prefs.setValues("user-data", array);

			try {
				prefs.store();
			}
			catch (IOException ex) {
//				Logger.getLogger(GuestbookPortlet.class.getName()).log(
//						Level.SEVERE, null, ex);
			}
			catch (ValidatorException ex) {
//				Logger.getLogger(GuestbookPortlet.class.getName()).log(
//						Level.SEVERE, null, ex);
			}

		}
		catch (ReadOnlyException ex) {
//			Logger.getLogger(GuestbookPortlet.class.getName()).log(
//					Level.SEVERE, null, ex);
		}
	}


	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {

		PortletPreferences prefs = renderRequest.getPreferences();
		String[] guestbookEntries = prefs.getValues("user-data", new String[1]);

		if (guestbookEntries[0] != null) {
			List<Entry> entries = parseEntries(guestbookEntries);
			renderRequest.setAttribute("entries", entries);
		}
		System.out.println("inside render method");
		super.render(renderRequest, renderResponse);
	}


	private List<Entry> parseEntries(String[] guestbookEntries) {
		List<Entry> entries = new ArrayList<Entry>();

		for (String entry : guestbookEntries) {
			String[] parts = entry.split("\\^", 2);
			Entry gbEntry = new Entry(parts[0], parts[1]);
			entries.add(gbEntry);
		}
		return entries;
	}


}