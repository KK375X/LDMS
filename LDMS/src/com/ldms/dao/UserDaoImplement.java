package com.ldms.dao;

import com.ldms.pojo.Admin;
import com.ldms.pojo.Student;
import com.ldms.pojo.Teacher;
import com.ldms.utils.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImplement implements UserDao {

    DBUtil dbUtil = new DBUtil();//获取工具类对象


    // 查询用户的ID和密码，用于登录

    /**
     * @param id
     * @param password
     * @return
     */
    @Override
    public Admin selectAdmin(String id, String password) {
        try {
            String sql = "select * from t_admin where id=? and password=?";//查询语句
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            ps.setString(1, id);//定义 ？ 的属性
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            Admin admin = new Admin();//创建管理员类的对象，实现其方法
            while (rs.next()) {//循环找到符合的用户ID和密码
                admin.setId(rs.getString("id"));
                admin.setName(rs.getString("name"));
                admin.setPassword(rs.getString("password"));
                admin.setPhone(rs.getString("phone"));
                admin.setCreateDate(rs.getString("createDate"));
                return admin;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;//找不到返回空
    }

    /**
     * @param id
     * @param password
     * @return
     */
    @Override
    public Teacher selectTeacher(String id, String password) {
        try {
            String sql = "select * from t_teacher where id=? and password=?";//查询语句
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            ps.setString(1, id);//定义 ？ 的属性
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            Teacher teacher = new Teacher();//创建教师类的对象，实现其方法
            while (rs.next()) {//循环找到符合的用户ID和密码
                teacher.setId(rs.getString("id"));
                teacher.setTeacherId(rs.getString("teacherId"));
                teacher.setName(rs.getString("name"));
                teacher.setPassword(rs.getString("password"));
                teacher.setAge(rs.getString("age"));
                teacher.setSex(rs.getString("sex"));
                teacher.setCollege(rs.getString("college"));
                teacher.setPosition(rs.getString("position"));
                teacher.setPhone(rs.getString("phone"));
                teacher.setCreateDate(rs.getString("createDate"));
                return teacher;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;//找不到返回空
    }

    /**
     * @param id
     * @param password
     * @return
     */
    @Override
    public Student selectStudent(String id, String password) {
        try {
            String sql = "select * from t_student where id=? and password=?";//查询语句
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            ps.setString(1, id);//定义 ？ 的属性
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            Student student = new Student();//创建学生类的对象，实现其方法
            while (rs.next()) {//循环找到符合的用户ID和密码
                student.setId(rs.getString("id"));
                student.setStudentId(rs.getString("studentId"));
                student.setName(rs.getString("name"));
                student.setPassword(rs.getString("password"));
                student.setAge(rs.getString("age"));
                student.setSex(rs.getString("sex"));
                student.setPhone(rs.getString("phone"));
                student.setTeacherId(rs.getString("teacherId"));
                student.setClasses(rs.getString("classes"));
                student.setCollege(rs.getString("college"));
                student.setCreateDate(rs.getString("createDate"));
                return student;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;//找不到返回空
    }


    // 查询用户信息（已淘汰）

    /**
     * @return
     */
    @Override
    public List<Object> selectTeacherList() {
        try {
            String sql = "select * from t_teacher";//查询教师表
            Statement st = dbUtil.getStatement();//获取查询语句
            ResultSet rs = st.executeQuery(sql);//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {//循环找到符合的用户ID和密码
                Teacher teacher = new Teacher();
                teacher.setId(rs.getString("id"));
                teacher.setTeacherId(rs.getString("teacherId"));
                teacher.setName(rs.getString("name"));
                teacher.setPassword(rs.getString("password"));
                teacher.setAge(rs.getString("age"));
                teacher.setSex(rs.getString("sex"));
                teacher.setCollege(rs.getString("college"));
                teacher.setPosition(rs.getString("position"));
                teacher.setPhone(rs.getString("phone"));
                teacher.setCreateDate(rs.getString("createDate"));
                list.add(teacher);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<Object> selectStudentList() {
        try {
            String sql = "select * from t_student";//查询教师表
            Statement st = dbUtil.getStatement();//获取查询语句
            ResultSet rs = st.executeQuery(sql);//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {//循环找到符合的用户ID和密码
                Student student = new Student();
                student.setId(rs.getString("id"));
                student.setStudentId(rs.getString("studentId"));
                student.setName(rs.getString("name"));
                student.setPassword(rs.getString("password"));
                student.setAge(rs.getString("age"));
                student.setSex(rs.getString("sex"));
                student.setPhone(rs.getString("phone"));
                student.setTeacherId(rs.getString("teacherId"));
                student.setClasses(rs.getString("classes"));
                student.setCollege(rs.getString("college"));
                student.setCreateDate(rs.getString("createDate"));
                list.add(student);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<Object> selectAdminList() {
        try {
            String sql = "select * from t_admin";//查询教师表
            Statement st = dbUtil.getStatement();//获取查询语句
            ResultSet rs = st.executeQuery(sql);//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {//循环找到符合的用户ID和密码
                Admin admin = new Admin();
                admin.setId(rs.getString("id"));
                admin.setName(rs.getString("name"));
                admin.setPassword(rs.getString("password"));
                admin.setPhone(rs.getString("phone"));
                admin.setCreateDate(rs.getString("createDate"));
                list.add(admin);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // 查询数据库，实现信息表显示和分页功能
    // 查询用户信息
    /**
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Object> selectTeacherList(String page, String limit) {
        try {
            String sql = "select * from t_teacher limit ?,?";//查询教师表
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            int page1 = Integer.parseInt(page);
            int limit1 = Integer.parseInt(limit);
            ps.setInt(1, (page1 - 1) * limit1);//定义 ？ 的属性
            ps.setInt(2, limit1);
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {//循环找到符合的用户ID和密码
                Teacher teacher = new Teacher();
                teacher.setId(rs.getString("id"));
                teacher.setTeacherId(rs.getString("teacherId"));
                teacher.setName(rs.getString("name"));
                teacher.setPassword(rs.getString("password"));
                teacher.setAge(rs.getString("age"));
                teacher.setSex(rs.getString("sex"));
                teacher.setCollege(rs.getString("college"));
                teacher.setPosition(rs.getString("position"));
                teacher.setPhone(rs.getString("phone"));
                teacher.setCreateDate(rs.getString("createDate"));
                list.add(teacher);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return
     */
    @Override
    public int countTeacherInfo() {
        try {
            String sql = "select count(*) as countTeacher from t_teacher";//查询教师表
            Statement st = dbUtil.getStatement();//获取查询语句
            ResultSet rs = st.executeQuery(sql);//定义查询结果的返回值
            while (rs.next()) {//循环找到符合的用户ID和密码
                return rs.getInt("countTeacher");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Object> selectAdminList(String page, String limit) {
        try {
            String sql = "select * from t_admin limit ?,?";//查询教师表
            PreparedStatement ps = dbUtil.getPreparedStatement(sql); //获取查询语句
            int page1 = Integer.parseInt(page);
            int limit1 = Integer.parseInt(limit);
            ps.setInt(1, (page1 - 1) * limit1);//定义 ？ 的属性
            ps.setInt(2, limit1);
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {//循环找到符合的用户ID和密码
                Admin admin = new Admin();
                admin.setId(rs.getString("id"));
                admin.setName(rs.getString("name"));
                admin.setPassword(rs.getString("password"));
                admin.setPhone(rs.getString("phone"));
                admin.setCreateDate(rs.getString("createDate"));
                list.add(admin);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return
     */
    @Override
    public int countAdminInfo() {
        try {
            String sql = "select count(*) as countAdmin from t_admin";//查询教师表
            Statement st = dbUtil.getStatement();//获取查询语句
            ResultSet rs = st.executeQuery(sql);//定义查询结果的返回值
            while (rs.next()) {//循环找到符合的用户ID和密码
                return rs.getInt("countAdmin");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Object> selectStudentList(String page, String limit) {
        try {
            String sql = "select * from t_student limit ?,?";//查询教师表
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            int page1 = Integer.parseInt(page);
            int limit1 = Integer.parseInt(limit);
            ps.setInt(1, (page1 - 1) * limit1);//定义 ？ 的属性
            ps.setInt(2, limit1);
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {//循环找到符合的用户ID和密码
                Student student = new Student();
                student.setId(rs.getString("id"));
                student.setStudentId(rs.getString("studentId"));
                student.setName(rs.getString("name"));
                student.setPassword(rs.getString("password"));
                student.setAge(rs.getString("age"));
                student.setSex(rs.getString("sex"));
                student.setPhone(rs.getString("phone"));
                student.setTeacherId(rs.getString("teacherId"));
                student.setClasses(rs.getString("classes"));
                student.setCollege(rs.getString("college"));
                student.setCreateDate(rs.getString("createDate"));
                list.add(student);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return
     */
    @Override
    public int countStudentInfo() {
        try {
            String sql = "select count(*) as countStudent from t_student";//查询教师表
            Statement st = dbUtil.getStatement();//获取查询语句
            ResultSet rs = st.executeQuery(sql);//定义查询结果的返回值
            while (rs.next()) {//循环找到符合的用户ID和密码
                return rs.getInt("countStudent");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    // 查询数据库中是否存在该用户
    /**
     * @param id
     * @return
     */
    @Override
    public Admin selectAdmin(String id) {
        try {
            String sql = "select * from t_admin where id=?";//查询语句
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            ps.setString(1, id);//定义 ？ 的属性
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            Admin admin = new Admin();
            while (rs.next()) {//循环找到符合的用户ID和密码
                admin.setId(rs.getString("id"));
                return admin;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;//找不到返回空
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Teacher selectTeacher(String id) {
        try {
            String sql = "select * from t_student where id=?";//查询语句
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            ps.setString(1, id);//定义 ？ 的属性
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            Teacher teacher = new Teacher();
            while (rs.next()) {//循环找到符合的用户ID和密码
                teacher.setId(rs.getString("id"));
                return teacher;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;//找不到返回空
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Student selectStudent(String id) {
        try {
            String sql = "select * from t_student where id=?";//查询语句
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            ps.setString(1, id);//定义 ？ 的属性
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            Student student = new Student();
            while (rs.next()) {//循环找到符合的用户ID和密码
                student.setId(rs.getString("id"));
                return student;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;//找不到返回空
    }


    // 功能一：添加用户信息，实现注册功能
    // 功能二：添加用户（管理员、教师、学生）

    /**
     * @param admin
     * @return
     */
    @Override
    public int addAdmin(Admin admin) {
        try {
            String sql = "insert into t_admin(id,name,password,phone,createDate) values(?,?,?,?,?)";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, admin.getId());
            ps.setString(2, admin.getName());
            ps.setString(3, admin.getPassword());
            ps.setString(4, admin.getPhone());
            ps.setString(5, admin.getCreateDate());
            int rs = ps.executeUpdate();
            if (rs == 1) {
                dbUtil.commit();
                return 1;
            } else {
                dbUtil.connectionRollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @param teacher
     * @return
     */
    @Override
    public int addTeacher(Teacher teacher) {
        try {
            String sql = "insert into t_teacher(id,teacherId,name,password,age,sex,college,position,phone,createDate) values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, teacher.getId());
            ps.setString(2, teacher.getTeacherId());
            ps.setString(3, teacher.getName());
            ps.setString(4, teacher.getPassword());
            ps.setString(5, teacher.getAge());
            ps.setString(6, teacher.getSex());
            ps.setString(7, teacher.getCollege());
            ps.setString(8, teacher.getPosition());
            ps.setString(9, teacher.getPhone());
            ps.setString(10, teacher.getCreateDate());
            int rs = ps.executeUpdate();
            if (rs == 1) {
                dbUtil.commit();
                return 1;
            } else {
                dbUtil.connectionRollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @param student
     * @return
     */
    @Override
    public int addStudent(Student student) {
        try {
            String sql = "insert into t_student(id,studentId,name,password,age,sex,phone,teacherId,classes,college,createDate) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, student.getId());
            ps.setString(2, student.getStudentId());
            ps.setString(3, student.getName());
            ps.setString(4, student.getPassword());
            ps.setString(5, student.getAge());
            ps.setString(6, student.getSex());
            ps.setString(7, student.getPhone());
            ps.setString(8, student.getTeacherId());
            ps.setString(9, student.getClasses());
            ps.setString(10, student.getCollege());
            ps.setString(11, student.getCreateDate());
            int rs = ps.executeUpdate();
            if (rs == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    // 搜索功能
    /**
     * @param name
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Object> searchAdminList(String name, String page, String limit) {
        try {
            String sql = "select * from t_admin where name like '%" + name + "%' limit ?,?";//查询教师表
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            int page1 = Integer.parseInt(page);
            int limit1 = Integer.parseInt(limit);
            ps.setInt(1, (page1 - 1) * limit1);//定义 ？ 的属性
            ps.setInt(2, limit1);
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getString("id"));
                admin.setName(rs.getString("name"));
                admin.setPassword(rs.getString("password"));
                admin.setPhone(rs.getString("phone"));
                admin.setCreateDate(rs.getString("createDate"));
                list.add(admin);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param name
     * @param classes
     * @param college
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Object> searchStudentList(String name, String classes, String college, String page, String limit) {
        try {
            String sql = "select * from t_student where name like '%" + name + "%' and classes like '%" + classes + "%' and college like '%" + college + "%' limit ?,?";//查询教师表
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            int page1 = Integer.parseInt(page);
            int limit1 = Integer.parseInt(limit);
            ps.setInt(1, (page1 - 1) * limit1);//定义 ？ 的属性
            ps.setInt(2, limit1);
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getString("id"));
                student.setStudentId(rs.getString("studentId"));
                student.setName(rs.getString("name"));
                student.setPassword(rs.getString("password"));
                student.setAge(rs.getString("age"));
                student.setSex(rs.getString("sex"));
                student.setPhone(rs.getString("phone"));
                student.setTeacherId(rs.getString("teacherId"));
                student.setClasses(rs.getString("classes"));
                student.setCollege(rs.getString("college"));
                student.setCreateDate(rs.getString("createDate"));
                list.add(student);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param name
     * @param college
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Object> searchTeacherList(String name, String college, String page, String limit) {
        try {
            String sql = "select * from t_teacher where name like '%" + name + "%' and college like '%" + college + "%' limit ?,?";//查询教师表
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);//获取查询语句
            int page1 = Integer.parseInt(page);
            int limit1 = Integer.parseInt(limit);
            ps.setInt(1, (page1 - 1) * limit1);//定义 ？ 的属性
            ps.setInt(2, limit1);
            ResultSet rs = ps.executeQuery();//定义查询结果的返回值
            List<Object> list = new ArrayList<Object>();
            while (rs.next()) {//循环找到符合的用户ID和密码
                Teacher teacher = new Teacher();
                teacher.setId(rs.getString("id"));
                teacher.setTeacherId(rs.getString("teacherId"));
                teacher.setName(rs.getString("name"));
                teacher.setPassword(rs.getString("password"));
                teacher.setAge(rs.getString("age"));
                teacher.setSex(rs.getString("sex"));
                teacher.setCollege(rs.getString("college"));
                teacher.setPosition(rs.getString("position"));
                teacher.setPhone(rs.getString("phone"));
                teacher.setCreateDate(rs.getString("createDate"));
                list.add(teacher);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    // 删除功能
    /**
     * @param id
     */
    @Override
    public void deleteAdmin(String id) {
        try {
            String sql = "delete from t_admin where id=?";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param id
     */
    @Override
    public void deleteTeacher(String id) {
        try {
            String sql = "delete from t_teacher where id=?";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param id
     */
    @Override
    public void deleteStudent(String id) {
        try {
            String sql = "delete from t_student where id=?";
            PreparedStatement ps = dbUtil.getPreparedStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
