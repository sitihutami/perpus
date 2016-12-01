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
public class DAOPinjam {
    public static void insert(entity.Pinjam b, util.Db d) throws SQLException{
        java.sql.PreparedStatement p=d.getPS("insert into pinjam values(?,?,?,?,?,?)");
        p.setString(1, b.getMember());
        p.setString(2, b.getBuku());
        p.setString(3, b.getKet());
        p.setDate(4, b.getPinjam());
        p.setDate(5, b.getKembali());
        p.setDate(6, b.getTarget());
        p.execute();
        p.close();
    }

    public static void delete(entity.Pinjam b, util.Db d) throws SQLException{
        java.sql.PreparedStatement p=d.getPS("delete from pinjam where member=? and buku=? and ket=? and pinjam=? and kembali=? and target=?");
        p.setString(1, b.getMember());
        p.setString(2, b.getBuku());
        p.setString(3, b.getKet());
        p.setDate(4, b.getPinjam());
        p.setDate(5, b.getKembali());
        p.setDate(6, b.getTarget());
        p.execute();
        p.close();
    }

    public static void update(entity.Pinjam a,entity.Pinjam b, util.Db d) throws SQLException{
        java.sql.PreparedStatement p=d.getPS("update pinjam set member=?,buku=?,ket=?,pinjam=?,kembali=?,target=? where "
                + "member=? and buku=? and ket=? and pinjam=? and kembali=? and target=?");
        p.setString(1, b.getMember());
        p.setString(2, b.getBuku());
        p.setString(3, b.getKet());
        p.setDate(4, b.getPinjam());
        p.setDate(5, b.getKembali());
        p.setDate(6, b.getTarget());
        p.setString(7, a.getMember());
        p.setString(8, a.getBuku());
        p.setString(9, a.getKet());
        p.setDate(10, a.getPinjam());
        p.setDate(11, a.getKembali());
        p.setDate(12, a.getTarget());
        p.execute();
        p.close();
    }

    public static java.util.List<entity.Pinjam>kabehPinjam(util.Db d) throws SQLException{
        java.util.List<entity.Pinjam>l=new java.util.LinkedList<entity.Pinjam>();
        java.sql.ResultSet r=d.getRS("select*from pinjam");
        while(r.next()){
            entity.Pinjam p=new entity.Pinjam();
            p.setBuku(r.getString("buku"));
            p.setKembali(r.getDate("kembali"));
            p.setKet(r.getString("ket"));
            p.setMember(r.getString("member"));
            p.setPinjam(r.getDate("pinjam"));
            p.setTarget(r.getDate("target"));
            l.add(p);
        }r.close();
        return l;
    }
}