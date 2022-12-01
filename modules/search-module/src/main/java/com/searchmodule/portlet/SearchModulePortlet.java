package com.searchmodule.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.searchmodule.constants.SearchModulePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import com.searchservice.service.StudentLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;

/**
 * @author root328
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=SearchModule",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SearchModulePortletKeys.SEARCHMODULE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SearchModulePortlet extends MVCPortlet {

	public void deleteStudent(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		String backURL  = ParamUtil.getString(actionRequest, "backURL");
		int studentId = ParamUtil.getInteger(actionRequest, "studentId");
		try {
			StudentLocalServiceUtil.deleteStudent(studentId);
			System.out.println("Successfully Deleted Student of Id =>"+studentId);
			actionResponse.sendRedirect(backURL);
		} catch (PortalException | SystemException e) {
			e.printStackTrace();
		}

	}
}