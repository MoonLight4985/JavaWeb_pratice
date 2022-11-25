package org.example.entity;

public class Student {
    private Integer id;
    private String sid;
    private String name;
    private Integer age;
    private String sex;
    private Integer grade;

    public Student() {
    }

    public Student(Integer id, String sid, String name, Integer age, String sex, Integer grade) {
        this.id = id;
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", grade=" + grade +
                '}';
    }
}
