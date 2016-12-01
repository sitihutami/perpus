/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dao;

import java.sql.SQLException;

/**
 *
 * @author ai
 */
public class DAODenda {
    public static void insert(entity.Denda b, util.Db d) throws SQLException{
        java.sql.PreparedStatement p=d.getPS("insert into denda values(?,?,?,?)");
        p.setString(1, b.getMember());
        p.setDate(2, b.getDari());
        p.setDate(3, b.getKe());
        p.setLong(4, b.getBayar());
        p.execute();
        p.close();
    }

    public static void delete(entity.Denda b, util.Db d) throws SQLException{
        java.sql.PreparedStatement p=d.getPS("delete from denda where member=? and dari=? and ke=? and bayar=?");
        p.setString(1, b.getMember());
        p.setDate(2, b.getDari());
        p.setDate(3, b.getKe());
        p.setLong(4, b.getBayar());
        p.execute();
        p.close();
    }

    public static void update(entity.Denda a, entity.Denda b, util.Db d) throws SQLException{
        java.sql.PreparedStatement p=d.getPS("update denda set member=?,dari=?,ke=?,bayar=? where member=? and dari=? and ke=? and bayar=?");
        p.setString(1, b.getMember());
        p.setDate(2, b.getDari());
        p.setDate(3, b.getKe());
        p.setLong(4, b.getBayar());
        p.setString(5, a.getMember());
        p.setDate(6, a.getDari());
        p.setDate(7, a.getKe());
        p.setLong(8, a.getBayar());
        p.execute();
        p.close();
    }

    public static java.util.List<entity.Denda>kabehDenda(util.Db d) throws SQLException{
        java.util.List<entity.Denda>l=new java.util.LinkedList<entity.Denda>();
        java.sql.ResultSet rs=d.getRS("select*from denda");
        while(rs.next()){
            entity.Denda b=new entity.Denda(rs.getString("member"), rs.getLong("bayar"));
            b.setDari(rs.getDate("dari"));
            b.setKe(rs.getDate("ke"));
            l.add(b);
        }rs.close();
        return l;
    }
}