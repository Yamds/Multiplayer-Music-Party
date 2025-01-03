package cafe.yamds.multiplayermusicparty.utils;

import java.sql.*;
import java.util.*;

/**
 * 数据库工具类
 * 注意:一般情况下封装的工具类中都是一些常量和静态方法
 * 堆、栈、方法区
 */

public class Jdbc {
//    声明连接数据库必须的字符串常量
    public static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/multiplayer_music_party?useSSL=false&serverTimezone=Asia/Shanghai";
    public static final String USER = "root";
    public static final String PASSWORD = "114514";

//    1. 加载数据库驱动
//        static静态块 只在类加载时加载一次
    static {
        try {
            Class.forName(DRIVER_CLASS);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//    2. 获取连接
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    3. 执行sql操作(可以封装成各种方法)
    public static List<Map<String, Object>> queryAll(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement preStat = null;
        ResultSet result = null;
        try {
            // 获取连接
            conn = getConnection();
            preStat = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preStat.setObject(i + 1, params[i]);  // 设置SQL参数
            }
            result = preStat.executeQuery(); // 获取结果集
            return resultSetToMapList(result);  // 将结果集转为一个List集合
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeObj(result, preStat, conn);
        }
        // 返回一个空集合
        return null;
    }

    // 执行 update 操作 返回结果是否成功
    public static boolean updateSQL(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement preStat = null;
        try {
            // 获取连接
            conn = getConnection();
            preStat = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preStat.setObject(i + 1, params[i]);  // 设置SQL参数
            }
            return preStat.executeUpdate()>0;  // 返回执行是否成功
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeObj(null, preStat, conn);
        }
        return false;
    }

//    // 搜索全部用户
//    public static List<Map<String,Object>> queryAll(String sql, Object... params) {
//        ResultSet result = executeSQL(sql, params);
//
//        if (result != null) {
//            return resultSetToMapList(result);
//        }
//        // 返回一个空集合
//        return new ArrayList<>();
//    }

    // 只返回数据的第一条，适合查找具体用户
    public static Map<String,Object> queryOne(String sql, Object... params) {
        List<Map<String, Object>> list = queryAll(sql, params);
        if(list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    // 插入数据
    public static boolean insert(String sql, Object... params) {
        return updateSQL(sql, params);
    }


    // 将 ResultSet 转换成列表对象 List<Map<String,Object>> 的方法，并返回
    public static List<Map<String, Object>> resultSetToMapList(ResultSet result) {
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            //获取结果集元数据
            ResultSetMetaData metaData = result.getMetaData();
            //通过元数据获取查询列的总数
            int columnCount = metaData.getColumnCount();
            while (result.next()){
                //结果集中的每一行数据都可以表示为一个Map对象(Java Bean)
                Map<String,Object> map = new HashMap<>();
                for (int i = 1; i <= columnCount ; i++) {
                    //获取当前列标签名称
                    String key = metaData.getColumnLabel(i);
                    //获取当前列的值
                    Object value = result.getObject(key);
                    //将一个列的名称作为键，对应的值作为值存储到Map中
                    map.put(key,value);
                }
                //将一行数据的map装入list集合
                list.add(map);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 返回一个空集合
        return new ArrayList<>();
    }


    // 三个对象创建，执行sql语句结束后，关闭三个对象
    public static void closeObj(ResultSet result, PreparedStatement preStat, Connection conn) {
        try {
            if(result != null) {
                result.close();
            }
            if(preStat != null) {
                preStat.close();
            }
            if(conn != null) {
                conn.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
