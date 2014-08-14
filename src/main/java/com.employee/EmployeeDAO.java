package com.employee;

import com.employee.EmployeePOJO;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;



/**
 * Created by rajan on 13/8/14.
 */
public class EmployeeDAO {

    private static DB db = null;

    static {
        try{
            db = new MongoClient( "localhost" , 27017 ).getDB( "EmployeeAppDB" );

        }catch(Exception e){

        }
    }

    public static void addEmployee(EmployeePOJO emp){
        DBCollection employee = db.getCollection("employee");
        BasicDBObject doc = new BasicDBObject("id", emp.getId()).append("name", emp.getName()).append("role", emp.getRole());
        employee.insert(doc);
    }

    public static List<EmployeePOJO> getAllEmployee(){
        List<EmployeePOJO> empList = new ArrayList<EmployeePOJO>();
        DBCollection employee = db.getCollection("employee");
        DBCursor cursor = employee.find();
        try {
            while(cursor.hasNext()) {
                DBObject object = cursor.next();
                EmployeePOJO emp = new EmployeePOJO();
                emp.setId(object.get("id").toString());
                emp.setName(object.get("name").toString());
                emp.setRole(object.get("role").toString());
                empList.add(emp);
            }
        } finally {
            cursor.close();
        }
        return empList;
    }
}
