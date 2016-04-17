package cn.longyt.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.longyt.dao.IUserDao;
import cn.longyt.util.PAClassPathXMLApplicationContext;

public class IbatisTest {

    public static int createRandomNumber() {
        return 100000 + (int) (Math.random() * 900000);
    }
    
    public static String formatSysdate(){
    	Date date = new Date();
    	SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd"); 
    	String sysdate = format.format(date);
    	format=new SimpleDateFormat("HHmmss");
    	String systime = format.format(date);
    	return sysdate+systime;
    }

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        
        //PAClassPathXMLApplicationContext ctx = new PAClassPathXMLApplicationContext("config/applicationContext.xml");
        
        IUserDao userDao = (IUserDao) context.getBean("userDao");
        
        IUserDao userDao2 = (IUserDao) context.getBean("userDao");
        
        //IUserDao userDao3 = (IUserDao) ctx.getBean("userDao");
        
        System.out.println(userDao==userDao2);
        
        //userDao3.test();

//        for (int i = 0; i < 100; i++) {
//            Map<String, Object> param = new HashMap<String, Object>();
//            param.put("userId", formatSysdate()+createRandomNumber());
//            param.put("userName", "longyuntang" + i);
//            param.put("password", createRandomNumber());
//            param.put("age", 29);
//            param.put("sex", "0");
//            param.put("createBy", "longyuntang");
//            param.put("updateBy", "longyuntang");
//            userDao.insert(param);
//        }

        /*
         * dao.insert(new Ibatis("3","new3")); Ibatis ibatis3 =
         * dao.getById("2"); ibatis3.setName("new7"); dao.update(ibatis3);
         */
        // testDAOImpl.delete("3");
        System.out.println("获得全查询列表");
//        List<Map<String, Object>> userList = userDao.queryAllUsers();
//        for (Map<String, Object> user : userList) {
//            System.out.println(user.get("userId") + "---"+ user.get("userName"));
//        }
    }
}
