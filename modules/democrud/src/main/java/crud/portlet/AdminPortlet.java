package crud.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import crud.constants.cruddemoPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

@Component(
        immediate = true,
        property = {

                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.name=" + cruddemoPortletKeys.ADMINDEMO,
                "javax.portlet.resource-bundle=content.Language",
                "com.liferay.portlet.display-category=category.hidden",
                "com.liferay.portlet.scopeable=true",
                "javax.portlet.display-name=Students",
                "javax.portlet.expiration-cache=0",
                "javax.portlet.init-param.portlet-title-based-navigation=true",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/admin/view.jsp",
                "javax.portlet.security-role-ref=administrator",
                "javax.portlet.supports.mime-type=text/html",
                "com.liferay.portlet.add-default-resource=true"
        },
        service = Portlet.class
)


public class AdminPortlet extends MVCPortlet {


}
