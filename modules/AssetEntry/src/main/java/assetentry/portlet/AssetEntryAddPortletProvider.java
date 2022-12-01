package assetentry.portlet;

import assetentry.constants.AssetEntryPortletKeys;

import com.liferay.portal.kernel.portlet.AddPortletProvider;
import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import javax.portlet.PortletPreferences;

import org.osgi.service.component.annotations.Component;

/**
 * @author root328
 */
@Component(
	immediate = true,
	property = {
		"model.class.name=com.liferay.asset.kernel.model.AssetEntry",
		"service.ranking:Integer=" + Integer.MAX_VALUE
	},
	service = AddPortletProvider.class
)
public class AssetEntryAddPortletProvider
	extends BasePortletProvider implements AddPortletProvider {

	@Override
	public String getPortletName() {
		System.out.println("helloooooooo");
		return AssetEntryPortletKeys.ASSETENTRY;
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