package org.example.service;

import org.example.dao.StudentDao;
import org.example.entity.Student;

import java.util.List;
import java.util.Random;

public class StudentService {
    public List<Student> queryList() {
        return new StudentDao().queryList();
    }

    public boolean addStudent(Student student) {
        String[] avatars = {
                "https://oademo.oss-cn-qingdao.aliyuncs.com/avatar/2022/09/04/70737d94f40243cba135239bc69ce2f9.jpg",
                "https://oademo.oss-cn-qingdao.aliyuncs.com/avatar/2022/09/04/91a1c791dd464227882e0b4192100bf5.jpg",
                "https://oademo.oss-cn-qingdao.aliyuncs.com/avatar/2022/09/04/QQ%E5%9B%BE%E7%89%8720220904235054.gif",
                "https://oademo.oss-cn-qingdao.aliyuncs.com/avatar/2022/09/05/c85e009cf15f496289b2e5eabc3fc1a0.jpg",
                "https://oademo.oss-cn-qingdao.aliyuncs.com/avatar/2022/09/14/177ce7b2afa8452a95481ac34b501e03.jpg",
                "https://oademo.oss-cn-qingdao.aliyuncs.com/avatar/2022/09/14/291f2ff107df43bab560794e253832ab.jpg",
                "https://oademo.oss-cn-qingdao.aliyuncs.com/avatar/2022/09/30/6ccc9f154533482582e59333815dc12a.jpg",
                "https://oademo.oss-cn-qingdao.aliyuncs.com/avatar/2022/09/03/079c498d806446ef887688e8aadccdcf.jpg",
                "https://oademo.oss-cn-qingdao.aliyuncs.com/avatar/2022/09/03/0dda0053cb9d42699bcc162d7cf801c6.jpg",
                "https://oademo.oss-cn-qingdao.aliyuncs.com/avatar/2022/09/03/dba8be44631d433aa8f2399864841e79.jpg"
        };
        Random random = new Random();
        int s = random.nextInt(10);
        student.setAvatar(avatars[s]);
        return new StudentDao().addStudent(student);
    }

    public boolean deleteById(int id) {
        return new StudentDao().deleteById(id);
    }

    public Student selectById(int id) {
        return new StudentDao().selectById(id);
    }

    public boolean putStu(Student stu) {
        return new StudentDao().putStu(stu);
    }
}
