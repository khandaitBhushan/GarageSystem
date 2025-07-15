package Services;

import Config.DBConfig;
import Entity.Customer;
import Entity.Invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InvoiceService {

//    public InvoiceService(){}
    public void addInvoice(Invoice invoice)throws SQLException {
        Connection con = DBConfig.getConnection();
        PreparedStatement pt = con.prepareStatement("insert into invoice(cus_id,veh_id,ser_id) values (?,?,?)");
        pt.setInt(1,invoice.getCusId());
        pt.setInt(2,invoice.getVehId());
        pt.setInt(3,invoice.getSerId());
        pt.executeUpdate();
        pt.close();
        con.close();
    }
    public ArrayList<Invoice> getAllInvoice()throws SQLException {
        Connection con = DBConfig.getConnection();
        PreparedStatement pt = con.prepareStatement("select * from invoice");
        ResultSet rs = pt.executeQuery();
        ArrayList<Invoice>list = new ArrayList<>();
        while (rs.next()){
            list.add(new Invoice(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4)));
        }
        pt.close();
        con.close();
        rs.close();
        return list;
    }
    public ArrayList<Invoice> getInvoice(int cusId)throws SQLException{
        Connection con = DBConfig.getConnection();
        System.out.println("Customer Id : "+cusId);
        PreparedStatement st = con.prepareStatement("select *from invoice where cus_id = ?");
        st.setInt(1,cusId);
        ResultSet rs = st.executeQuery();
        ArrayList<Invoice>list = new ArrayList<>();
        while (rs.next()){
            list.add(new Invoice(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4)));
        }
        rs.close();
        st.close();
        con.close();
        return list;
    }

}
