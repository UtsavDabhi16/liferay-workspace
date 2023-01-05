package liferaydemo.portlet;

import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.util.*;
import eventdemo.model.Data;
import eventdemo.service.DataLocalService;
import eventdemo.service.DataLocalServiceUtil;
import liferaydemo.constants.LiferayDemoPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import javax.portlet.*;
import liferaydemo.util.UserCSVImportUtil;
import org.osgi.service.component.annotations.Component;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import org.osgi.service.component.annotations.Reference;


/**
 * @author root328
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=LiferayDemo",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + LiferayDemoPortletKeys.LIFERAYDEMO,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user", 
			"service.ranking:Integer=500"
	},
	service = Portlet.class
)
public class LiferayDemoPortlet extends MVCPortlet {
	public static final Log LOG = LogFactoryUtil.getLog(LiferayDemoPortlet.class);

	//Exporting the Event Details and Store into meetUpData CSV File.
	public static String[] columnNames = { "EventID","SourceURL", "HostName", "Image", "Address","Summary" ,"Count" };
	public static final String COMMA = ",";
	public static final String FILENAME = "meetUpData.csv";

	//Data Service Method Which is Imported From the EventDemo Module
	@Reference
	public DataLocalService dataLocalService;

	//Liferay Default Constructor
	public LiferayDemoPortlet() {
	}

	//User CSV Data Upload Method
	public final void userCSVDataUpload(final ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		LOG.info("******************** User CSV Data Upload ***************************");

		final String filePath = "/home/root328/Downloads/meetUpData.csv";
		try (FileOutputStream fOut = new FileOutputStream(filePath)) {
		final UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
	     InputStream inputStream;
			inputStream = uploadRequest.getFileAsStream("csvDataFile");
			int input;
			while (true) {
				if ((input = inputStream.read()) == -1) {
					break;
				}
				fOut.write(input);
			}

			final File csvFile = new File(filePath);
			LOG.info("CSV File ===> " + csvFile);

			if (Validator.isNotNull(csvFile)) {
				if (csvFile.getName().contains(".csv")) {


//					Read CSV File and Store the Data into Custom Database
					final JSONArray csvDataArray = UserCSVImportUtil.readCSVFile(csvFile);
					UserCSVImportUtil.addUserToDatabase(csvDataArray);

				} else {
					LOG.error("Uploaded File is not CSV file.Your file name is ----> " + csvFile.getName());
				}

			}
		} catch (Exception e) {
			LOG.error("Exception in CSV File Reading Process :: ", e);
		}
	}

	@Override
	public final void serveResource(final ResourceRequest resourceRequest,ResourceResponse resourceResponse) {

		LOG.info(" **** In Serve Resource Method *****");
	final 	String url = ParamUtil.getString(resourceRequest, "export");

		try {
			if (url != null && url.equals("exportCSV")) {

	  final StringBundler stringBundler = new StringBundler();
				for (final String columnName : columnNames) {
					stringBundler.append(getCSVFormattedValue(String.valueOf(columnName)));
					stringBundler.append(COMMA);
				}
				stringBundler.setIndex(stringBundler.index() - 1);
				stringBundler.append(CharPool.NEW_LINE);
				final			List<Data> usersList = DataLocalServiceUtil.getDatas(0,DataLocalServiceUtil.getDatasCount());
				LOG.info("DataList ===> " + usersList);
				for (final Data user : usersList) {
					try {
						stringBundler.append(getCSVFormattedValue(String.valueOf(user.getEventId())));
						stringBundler.append(COMMA);
						stringBundler.append(getCSVFormattedValue(String.valueOf(user.getSourceURL())));
						stringBundler.append(COMMA);
						stringBundler.append(getCSVFormattedValue(String.valueOf(user.getHostName())));
						stringBundler.append(COMMA);
						stringBundler.append(getCSVFormattedValue(String.valueOf(user.getImage())));
						stringBundler.append(COMMA);
						stringBundler.append(getCSVFormattedValue(String.valueOf(user.getAddress())));
						stringBundler.append(COMMA);
						stringBundler.append(getCSVFormattedValue(String.valueOf(user.getSummary())));
						stringBundler.append(COMMA);
						stringBundler.append(getCSVFormattedValue(String.valueOf(user.getTotalCount())));
						stringBundler.append(COMMA);
						stringBundler.setIndex(stringBundler.index() - 1);
						stringBundler.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						LOG.error("Error while export data : " + e);
					}
				}

				final			byte[] bytes = stringBundler.toString().getBytes();
				final			String contentType = ContentTypes.APPLICATION_TEXT;
				PortletResponseUtil.sendFile(resourceRequest, resourceResponse,FILENAME, bytes, contentType);
			}
		} catch (Exception e) {
			LOG.error("Exception While export CSV file : ", e);
		}
	}

	private  String getCSVFormattedValue(String value) {
		final	StringBundler stringBundler = new StringBundler(3);
		stringBundler.append(CharPool.QUOTE);
		stringBundler.append(StringUtil.replace(value, CharPool.QUOTE, StringPool.DOUBLE_QUOTE));
		stringBundler.append(CharPool.QUOTE);
		return stringBundler.toString();
	}

}