package com.superior.test;

import com.other.Employee;
import com.other.MyDate;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class EmployeeTest {

    //使用Employee实现Comparable接口,并按name排序
    @Test
    public void test1() {

        TreeSet<Employee> set = new TreeSet<>();

        Employee e1 = new Employee("Tomi", 18, new MyDate(1998, 12, 21));
        Employee e2 = new Employee("Jerry", 23, new MyDate(1997, 6, 17));
        Employee e3 = new Employee("Andy", 21, new MyDate(1999, 3, 5));
        Employee e4 = new Employee("Jack", 27, new MyDate(1994, 5, 13));
        Employee e5 = new Employee("Loki", 22, new MyDate(1994, 8, 31));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        //遍历
        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
            Employee employee = iterator.next();
            System.out.println("姓名:" + employee.getName() + "\t\t年龄:" + employee.getAge() + "\t\t生日:" + employee.getBirthday());
        }

    }

    //创建TreeSet时传入Comparator对象,按生日日期排列
    @Test
    public void test2() {

        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {

                //在比较月份时12月与5月相比会出现问题
//                return o1.getBirthday().toString().compareTo(o2.getName().toString());

                //方式1:正确的写法
//                if (o1.getBirthday().getYear() != o2.getBirthday().getYear())
//                    return o1.getBirthday().getYear() - o2.getBirthday().getYear();
//                if (o1.getBirthday().getMonth() != o2.getBirthday().getMonth())
//                    return o1.getBirthday().getMonth() - o2.getBirthday().getMonth();
//
//                return o1.getBirthday().getDay() - o2.getBirthday().getDay();

                //方式2:将Comparator写入到MaDate中
                return o1.getBirthday().compareTo(o2.getBirthday());

            }
        };

        TreeSet<Employee> set = new TreeSet<>(comparator);

        Employee e1 = new Employee("Tomi", 18, new MyDate(1998, 12, 21));
        Employee e2 = new Employee("Jerry", 23, new MyDate(1997, 6, 17));
        Employee e3 = new Employee("Andy", 21, new MyDate(1998, 3, 5));
        Employee e4 = new Employee("Jack", 27, new MyDate(1998, 12, 13));
        Employee e5 = new Employee("Loki", 22, new MyDate(1997, 8, 31));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            System.out.println("姓名:" + employee.getName() + "\t\t年龄:" + employee.getAge() + "\t\t生日:" + employee.getBirthday());
        }

    }

}
