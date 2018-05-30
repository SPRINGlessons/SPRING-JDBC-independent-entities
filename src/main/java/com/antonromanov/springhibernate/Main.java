package com.antonromanov.springhibernate;

import com.antonromanov.springhibernate.DAO.UserDAO;
import com.antonromanov.springhibernate.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        UserDAO personDAO = context.getBean(UserDAO.class);
        //ArrayList<Phone> personArrayList = new ArrayList<Phone>();
        //personArrayList.add(new Phone("80001112222"));
        User person = new User("Antoshka");
        personDAO.save(person);
        System.out.println("Person::"+person);
       // List<User> list = personDAO.getPersonList();
      //  for(User p : list){
     //       System.out.println("Person List::"+p);
    //    }
        //close resources
        context.close();
    }

}
