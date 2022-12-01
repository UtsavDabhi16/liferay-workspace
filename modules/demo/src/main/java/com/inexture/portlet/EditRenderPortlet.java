package com.inexture.portlet;

import com.inexture.constants.DemoModulePortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

/**
 * @author root328
 */
@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + DemoModulePortletKeys.DEMOMODULE,
			"mvc.command.name=/demo"
	},
	service = MVCRenderCommand.class
)

public class EditRenderPortlet implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		System.out.println("inside render method");
		return "/demo.jsp";
	}

}