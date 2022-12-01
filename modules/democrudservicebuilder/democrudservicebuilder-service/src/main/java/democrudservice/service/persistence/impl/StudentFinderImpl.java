package democrudservice.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.SystemException;
import democrudservice.model.Student;
import democrudservice.model.impl.StudentImpl;
import democrudservice.service.StudentLocalService;
import democrudservice.service.StudentLocalServiceUtil;
import democrudservice.service.persistence.StudentFinder;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Collections;
import java.util.List;

@Component(service = StudentFinder.class)
public class StudentFinderImpl extends StudentFinderBaseImpl implements StudentFinder {

    @Reference
    CustomSQL customSQLUtil;


    //Using Custom SQL
    public List<Student> getStudentsByFirstName(String firstName){
        Session session=null;
        List<Student> studentList= Collections.EMPTY_LIST;
        try
        {
            session=openSession();

            String sql=customSQLUtil.get(getClass(),"getStudentFirstName");
            SQLQuery sqlQuery=session.createSQLQuery(sql);
            sqlQuery.setCacheable(false);
            sqlQuery.addEntity("Student", StudentImpl.class);
            QueryPos queryPos=QueryPos.getInstance(sqlQuery);
            queryPos.add(firstName);
            studentList= sqlQuery.list();
            System.out.println("student list :"+ studentList);
            return studentList;

        }catch (Exception e){
            System.out.println("Exception is :"+ e);
        }finally {
            closeSession(session);
        }
        return studentList;
    }


    public List<Student> getForPagination(int start,int end){
        Session session=null;
        List<Student> studentList= Collections.EMPTY_LIST;
        try
        {
            session=openSession();

            String sql=customSQLUtil.get(getClass(),"getForPagination");
            SQLQuery sqlQuery=session.createSQLQuery(sql);
            sqlQuery.setCacheable(false);
            sqlQuery.addEntity("Student", StudentImpl.class);
            QueryPos queryPos=QueryPos.getInstance(sqlQuery);
            queryPos.add(start);
            queryPos.add(end);
            studentList= sqlQuery.list();
            System.out.println("student list :"+ studentList);
            return studentList;

        }catch (Exception e){
            System.out.println("Exception is :"+ e);
        }finally {
            closeSession(session);
        }
        return studentList;
    }


    //Using Dynamic Query
    public List<Student> findByFName(long empId) {

        List<Student> entries = null;
        Session session = null;
        try {
            session = openSession();

            ClassLoader classLoader = getClass().getClassLoader();

            //select empName from emp where empId=1
//            DynamicQuery empQuery = DynamicQueryFactoryUtil.forClass(Student.class, classLoader)
//                    .add(RestrictionsFactoryUtil.eq("studentId", 1l))
//                    .setProjection(ProjectionFactoryUtil.property("firstName"));

//            Order order = OrderFactoryUtil.desc("firstName");

//            DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(Student.class, classLoader)
//                    .add(RestrictionsFactoryUtil.eq("studentId", empId))
//                    .add(PropertyFactoryUtil.forName("firstName").in(empQuery))
//                    .addOrder(order);

            //Like Operation
//            DynamicQuery q= DynamicQueryFactoryUtil.forClass(Student.class,classLoader)
//                    .add(RestrictionsFactoryUtil.like("firstName","U%"));
//            entries = StudentLocalServiceUtil.dynamicQuery(q);

            //In Operation
//            List<Student> studentList = studentLocalService.getStudents(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
//            DynamicQuery q2= DynamicQueryFactoryUtil.forClass(Student.class,classLoader)
//                    .add(RestrictionsFactoryUtil.in("firstName",studentList));
//            entries = StudentLocalServiceUtil.dynamicQuery(q2);



//            entries = StudentLocalServiceUtil.dynamicQuery(entryQuery);
//            System.out.println("Entires is here:"+ entries);
            return entries;
        } catch (Exception e) {
            try {
                throw new SystemException(e);
            } catch (SystemException se) {
                se.printStackTrace();
            }
        } finally {
            closeSession(session);
        }
        return entries;
    }

}
