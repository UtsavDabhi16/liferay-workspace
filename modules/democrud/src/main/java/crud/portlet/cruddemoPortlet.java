package crud.portlet;

import com.liferay.counter.kernel.service.CounterLocalService;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
//import com.seconddemo.builder.model.Employee;
//import com.seconddemo.builder.service.EmployeeLocalService;
import crud.constants.cruddemoPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import democrudservice.model.Student;
import democrudservice.service.StudentLocalService;
import democrudservice.service.StudentLocalServiceUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import userapp.model.UserApp;
import userapp.service.UserAppLocalService;

import java.io.IOException;
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
		"javax.portlet.display-name=cruddemo",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + cruddemoPortletKeys.CRUDDEMO,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class cruddemoPortlet extends MVCPortlet {

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference
	CounterLocalService counterLocalService;

	@Reference
	StudentLocalService studentLocalService;

	@Reference
	UserAppLocalService userAppLocalService;

//	@Reference
//	EmployeeLocalService employeeLocalService;

	@ProcessAction(name = "addStudent")
	public void addStudent(ActionRequest actionRequest, ActionResponse actionResponse) {
		long studentId = counterLocalService.increment(Student.class.getName());
		String enrollmentNo = ParamUtil.getString(actionRequest, "enrollmentNo");
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String contactNo = ParamUtil.getString(actionRequest, "contactNo");
		String city = ParamUtil.getString(actionRequest, "city");

		Student student = studentLocalService.createStudent(studentId);
		student.setStudentId(studentId);
		student.setEnrollmentNo(enrollmentNo);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setContactNo(contactNo);
		student.setCity(city);
		studentLocalService.addStudent(student);
	}

	@ProcessAction(name = "updateStudent")
	public void updateStudent(ActionRequest actionRequest,  ActionResponse actionResponse) {
		long studentId = ParamUtil.getLong(actionRequest,"studentId", GetterUtil.DEFAULT_LONG);
		String enrollmentNo = ParamUtil.getString(actionRequest, "enrollmentNo", GetterUtil.DEFAULT_STRING);
		String firstName = ParamUtil.getString(actionRequest, "firstName", GetterUtil.DEFAULT_STRING);
		String lastName = ParamUtil.getString(actionRequest, "lastName", GetterUtil.DEFAULT_STRING);
		String contactNo = ParamUtil.getString(actionRequest, "contactNo", GetterUtil.DEFAULT_STRING);
		String city = ParamUtil.getString(actionRequest, "city", GetterUtil.DEFAULT_STRING);

		Student student = null;
		try {
			student = studentLocalService.getStudent(studentId);
		} catch (Exception e) {
			log.error(e.getCause(), e);
		}

		if(Validator.isNotNull(student)) {
			student.setEnrollmentNo(enrollmentNo);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setContactNo(contactNo);
			student.setCity(city);
			studentLocalService.updateStudent(student);
		}
	}

	@ProcessAction(name = "deleteStudent")
	public void deleteStudent(ActionRequest actionRequest, ActionResponse actionResponse){
		long studentId = ParamUtil.getLong(actionRequest, "studentId", GetterUtil.DEFAULT_LONG);
		try {
			studentLocalService.deleteStudent(studentId);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException{

//		System.out.println("finder: "+studentLocalService.getStudentByFistName("Utsav"));


		System.out.println("getForPagination: "+studentLocalService.getForPagination(1,2));
		List<Student> studentList = studentLocalService.getStudents(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute("studentList", studentList);

//		Employee employee = employeeLocalService.createEmployee(2);
//		employee.setEname("utsavsss");
//		employeeLocalService.addEmployee(employee);

		UserApp userApp = userAppLocalService.createUserApp("2");
		userApp.setDescription("hyy");
		userApp.setLink("ink");
		userApp.setLogoUrl("logourl");
		userApp.setName("dabhi");
		userAppLocalService.addUserApp(userApp);

		//Using External DataBase
//		List<Employee> employeeList = employeeLocalService.getEmployees(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
//		for (Employee employee: employeeList){
//			System.out.println("Employee List is :"+ employee);
//		}

		super.render(renderRequest, renderResponse);

	}

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		List<Student> getByCityList = StudentLocalServiceUtil.getStudentFormCity("rajkot");
		for (Student s: getByCityList){
			System.out.println("Student List is :"+ s.getFirstName());
		}

		//Get Custom SQL Data
		List<Student> firstName= studentLocalService.getStudentByFistName("jemy");
		for(Student s: firstName){
			System.out.println("First Name is :"+ s.getFirstName());

		}
		//Get Dynamic Data
//		System.out.println(studentLocalService.findByEntryfirstkName(1));
//		List<Student> firstName= studentLocalService.findByEntryfirstkName(1);
//		for(Student s: firstName){
//			System.out.println("First Name is :"+ s.getFirstName());
//		}

		include(viewTemplate, renderRequest, renderResponse);
	}


//	public void deleteRecord(ActionRequest actionRequest,ActionResponse actionResponse) throws IOException, PortletException {
//   /*
//   *    Get cur(current page) and delta(records per page) from URL
//        HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
//        String cur = PortalUtil.getOriginalServletRequest(request).getParameter("_demo_WAR_searchcontainerportlet_cur");
//        String delta = PortalUtil.getOriginalServletRequest(request).getParameter("_demo_WAR_searchcontainerportlet_delta");
//                                           OR
//  */
//		int cur = ParamUtil.getInteger(actionRequest, "cur");
//		int delta = ParamUtil.getInteger(actionRequest, "delta");
//		String backURL = ParamUtil.getString(actionRequest, "backURL");
//		int employeeId = ParamUtil.getInteger(actionRequest, "studentId");
//
//		try {
//			StudentLocalServiceUtil.deleteStudent(employeeId);
//			int totalRecord = StudentLocalServiceUtil.getStudentsCount();
//			int maxPage ;// Maximum page after delete employee
//			if(totalRecord%delta != 0){
//				maxPage = totalRecord/delta +1;
//			}else{
//				maxPage = totalRecord/delta;
//			}
//			if(maxPage<cur){
//				String first = "_cur="+cur;
//				String second = "_cur="+maxPage;
//				backURL = backURL.replace(first, second);
//			}
//			actionResponse.sendRedirect(backURL);
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}