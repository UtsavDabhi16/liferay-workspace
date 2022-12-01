package assetentry.portlet;

import com.liferay.journal.constants.JournalPortletKeys;
import com.liferay.portal.kernel.portlet.AddPortletProvider;
import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletPreferences;

/**
 * @author root328
 */
@Component(
	immediate = true,
	property = {
		"model.class.name=com.liferay.journal.model.JournalArticle",
		"service.ranking:Integer=" + Integer.MAX_VALUE
	},
	service = AddPortletProvider.class
)
public class JournalArticleAddPortletProvider
	extends BasePortletProvider implements AddPortletProvider {

	@Override
	public String getPortletName() {
		System.out.println("hyyyyy");
		return JournalPortletKeys.JOURNAL;
	}

	@Override
	public void updatePortletPreferences(
			PortletPreferences portletPreferences, String portletId,
			String className, long classPK, ThemeDisplay themeDisplay)
		throws Exception {

		portletPreferences.setValue("className", className);
		portletPreferences.setValue("classPK", String.valueOf(classPK));
	}

}