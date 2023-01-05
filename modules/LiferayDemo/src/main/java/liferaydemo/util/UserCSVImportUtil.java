package liferaydemo.util;

import java.io.*;
import java.nio.file.Files;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import eventdemo.model.Data;
import eventdemo.service.DataLocalServiceUtil;
import liferaydemo.bean.UsersBean;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//User CSV  Import Class
public class UserCSVImportUtil {

    public static final Log LOG = LogFactoryUtil.getLog(UserCSVImportUtil.class);

    //Reading CSV File Method
    public static JSONArray readCSVFile(final File csvfile) throws IOException {

        final JSONArray csvData = JSONFactoryUtil.createJSONArray();

        try (InputStream targetStream = Files.newInputStream(csvfile.toPath());
             InputStreamReader isr = new InputStreamReader(targetStream)) {

            //Create New CSV Format and read the details from the CSVParser
            final CSVFormat csvFormat = CSVFormat.newFormat(',').withIgnoreEmptyLines().withTrim(true);
             CSVParser csvParser;
            csvParser = csvFormat.parse(isr);

            JSONObject rowObject;

            for (final CSVRecord record : csvParser) {
                rowObject = JSONFactoryUtil.createJSONObject();
                for (int j = 0; j < record.size(); j++) {
                    rowObject.put(String.valueOf(j), record.get(j));
                }

                //Store the data into JSON Array
                csvData.put(rowObject);
            }

            LOG.info("CSV Data : " + csvData.toString());

        } catch (IOException e) {
            LOG.error("Exception while reading file : ", e);
            throw e;
        }

        return csvData;
    }

    //Add User To the Database
    public static void addUserToDatabase(final JSONArray csvDataArray)
            throws PortalException, IOException {

        LOG.info("Data Array inside addUserToLiferayDb ===> " + csvDataArray);

        final long companyId = PortalUtil.getDefaultCompanyId();
        final User adminUser = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(), "utsav.inexture@gmail.com");

        LOG.info("Company Id ===> " + companyId);
        LOG.info("Admin User ===> " + adminUser);

        if (Validator.isNotNull(csvDataArray)) {
            LOG.info("Data Array Length ===> " + csvDataArray.length());
            for (int i = 1; i < csvDataArray.length(); i++) {

                final JSONObject jsonObject = csvDataArray.getJSONObject(i);
                LOG.info("Json Object ===> " + jsonObject);

                final UsersBean csvToBean = new UsersBean();

                if (Validator.isNotNull(jsonObject.getString("0"))) {
                    csvToBean.setSourceURL(jsonObject.getString("0").trim());
                    LOG.info("Source URL ===> " + jsonObject.getString("0").trim());
                }

                final Document doc = Jsoup.connect(jsonObject.getString("1")).get();

                final Elements hostNames = doc.getElementsByClass("flex flex-row mt-4 lg:mt-5");
                for (final Element element : hostNames){
                    final Elements hostName =element.getElementsByClass("font-medium");
                    for (final Element host : hostName){
                        csvToBean.setHostName(host.html());
                    }
                }

                final Elements eventAddresses = doc.getElementsByClass("top-24 sticky");
                for (final Element eventAddress : eventAddresses){
                    final Elements addresses =eventAddress.getElementsByClass("mt-5 text-sm");
                    for (final Element address : addresses){
                        final Elements elements = address.getElementsByClass("flex mt-5");
                        for (final Element element : elements){
                            final Elements eAddress = element.getElementsByClass("text-gray6");
                            csvToBean.setAddress(eAddress.html());
                        }
                    }
                }

                final Elements eventSummary = doc.getElementsByClass("px-6 sm:px-4 xl:px-0 md:max-w-screen w-full mt-5");
                for (final Element summary : eventSummary){
                    final Elements elements =summary.getElementsByClass("break-words");
                    for (final Element element : elements){
                        final Element element1 = element.child(0);
                        final String eSummary = element1.html().replaceAll("<.*?>", "");
                        csvToBean.setSummary(eSummary);
                    }
                }

                final Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
                final Element img = images.first();
                final String image = img.attr("src");
                csvToBean.setImage(image);
                csvToBean.setCounts("46");
                LOG.info("User Bean +++> " + csvToBean);

                addCSVUser(adminUser, csvToBean);

            }
        }
    }

    private static void addCSVUser(final User adminUser, final UsersBean usersBean) {

        LOG.info("******* In Data User *********");
        final Data data= DataLocalServiceUtil.createData(adminUser.getUserId());
        data.setHostName(usersBean.getHostName());
        data.setAddress(usersBean.getAddress());
        data.setImage(usersBean.getImage());
        data.setSummary(usersBean.getSummary());
        data.setTotalCount(usersBean.getCounts());
        data.setSourceURL(usersBean.getSourceURL());
        LOG.info("Data ==> " + data);
        DataLocalServiceUtil.addData(data);
    }

}
