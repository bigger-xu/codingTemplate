package com.coding.temp.utils;

import com.coding.temp.entity.Column;
import com.coding.temp.entity.Connect;
import com.coding.temp.entity.DataBase;
import com.coding.temp.entity.Tables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * @author Zhang Yongwei
 * @version 1.0
 * @date 2019-03-23
 */
public class DBUtils {
    private Connection conn = null;

    public DBUtils() {
    }

    public List<Column> getColumns(Connect connect, String dataBaseName, String tableName) throws Exception {
        ArrayList columns = new ArrayList();

        try {
            Connection conn = this.getConnection(connect, dataBaseName);
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select COLUMN_NAME,COLUMN_COMMENT,DATA_TYPE,TABLE_SCHEMA,TABLE_NAME,CHARACTER_MAXIMUM_LENGTH from Information_schema.columns where table_schema='" + dataBaseName + "' and TABLE_NAME='" + tableName + "'");

            while(rs.next()) {
                Column column = new Column();
                column.setName(rs.getString(1));
                column.setColumnsDesc(rs.getString(2));
                column.setColumnsType(rs.getString(3));
                column.setAttrVariableName(StringUtil.javaStyle(column.getName()));
                column.setAttrName(StringUtil.capFirst(column.getAttrVariableName()));
                columns.add(column);
            }
            rs.close();
            stat.close();
            conn.close();
            return columns;
        } catch (Exception var9) {
            var9.printStackTrace();
            throw var9;
        }
    }

    public List<Tables> getTables(Connect connect, String dataBaseName) throws Exception {
        ArrayList tables = new ArrayList();

        try {
            Connection conn = this.getConnection(connect, dataBaseName);
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("SELECT table_name,substring_index(table_comment, ';', 1) as table_comment,table_schema from Information_schema.tables where table_schema='" + dataBaseName + "'");

            while(rs.next()) {
                Tables table = new Tables();
                table.setName(rs.getString(1));
                table.setCode(rs.getString(1));
                table.setTableDesc(rs.getString(2));
                tables.add(table);
            }

            rs.close();
            stat.close();
            conn.close();
            return tables;
        } catch (Exception var8) {
            var8.printStackTrace();
            throw var8;
        }
    }

    public List<DataBase> getDataBases(Connect connect) throws Exception {
        ArrayList dataBases = new ArrayList();

        try {
            Connection conn = this.getConnection(connect);
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("show databases");

            while(rs.next()) {
                DataBase dataBase = new DataBase();
                dataBase.setName(rs.getString(1));
                dataBases.add(dataBase);
            }

            rs.close();
            stat.close();
            conn.close();
            return dataBases;
        } catch (Exception var7) {
            var7.printStackTrace();
            throw var7;
        }
    }

//    public static void main(String[] args) {
//        Connect connect = new Connect();
//        connect.setDbTypeCode("mysql");
//        connect.setIp("172.16.117.250");
//        connect.setEncode("utf-8");
//        connect.setUserName("monitor");
//        connect.setPassword("sunland@2012");
//        connect.setPort("3306");
//        DBUtil dbUtil = new DBUtil();
//
//        try {
//            List<Column> columns = dbUtil.getColumns(connect, "ecode", "plat_connect");
//            Iterator i$ = columns.iterator();
//
//            while(i$.hasNext()) {
//                Column column = (Column)i$.next();
//                System.out.println(column.getName() + ":" + column.getColumnsDesc() + ":" + column.getColumnsType() + ":" + column.getAttrName() + ":" + column.getAttrVariableName());
//            }
//        } catch (Exception var6) {
//            var6.printStackTrace();
//        }
//
//    }

    public Connection getConnection(Connect connect, String dataBaseName) throws Exception {
        try {
            String driver = "";
            String url = "";
            if (connect.getDbType().equals("mysql")) {
                driver = "org.gjt.mm.mysql.Driver";
                url = "jdbc:mysql://" + connect.getIp() + ":" + connect.getPort() + "/" + dataBaseName + "?useUnicode=true&characterEncoding=" + connect.getEncode() + "&useSSL=false";

            }else{
                return null;
            }
            Class.forName(driver);
            this.conn = DriverManager.getConnection(url, connect.getUserName(), connect.getPassword());
        } catch (Exception var5) {
            throw var5;
        }

        return this.conn;
    }

    public Connection getConnection(Connect connect) throws Exception {
        try {
            String driver = "";
            String url = "";
            if (connect.getDbType().equals("mysql")) {
                driver = "org.gjt.mm.mysql.Driver";
                url = "jdbc:mysql://" + connect.getIp() + ":" + connect.getPort() + "/test" + "?useUnicode=true&characterEncoding=" + connect.getEncode();

            }else{
                return null;
            }

            Class.forName(driver);
            this.conn = DriverManager.getConnection(url, connect.getUserName(), connect.getPassword());
        } catch (Exception var4) {
            throw var4;
        }

        return this.conn;
    }

    public boolean validateConn(Connect connect) {
        boolean validate = false;

        try {
            this.conn = this.getConnection(connect);
            if (this.conn != null) {
                validate = true;
                this.conn.close();
            }
        } catch (Exception var12) {
            var12.printStackTrace();
        } finally {
            if (null != this.conn) {
                try {
                    this.conn.close();
                } catch (SQLException var11) {
                    var11.printStackTrace();
                }

                this.conn = null;
            }

        }

        return validate;
    }
}
