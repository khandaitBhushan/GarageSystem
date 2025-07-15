package Services;

import Config.DBConfig;
import Entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerService {

    public void addCustomer(Customer customer) throws SQLException {
        String query = "insert into customer(cus_name,cus_phone) values(?,?)";
        Connection con = DBConfig.getConnection();
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1,customer.getName());
        st.setString(2,customer.getCusPhone());
        st.executeUpdate();
        System.out.println("done ....!");
        st.close();
        con.close();
    }

    public ArrayList<Customer> getAllCustomer() throws SQLException{
        String query = "select *from customer";
        Connection con = DBConfig.getConnection();
        PreparedStatement st = con.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        ArrayList<Customer>list = new ArrayList<>();
        while (rs.next()){
            list.add(new Customer(rs.getInt(1),rs.getString(2),rs.getString(3)));
        }
        rs.close();
        st.close();
        con.close();
        return list;
    }

    // A customer can have multiple services
    // there can multiple phone can possible

    public ArrayList<Customer> getCustomer(String phone)throws SQLException{
        Connection con = DBConfig.getConnection();
        PreparedStatement st = con.prepareStatement("select *from customer where cus_phone = ?");
        st.setString(1,phone);
        ResultSet rs = st.executeQuery();
        ArrayList<Customer>list = new ArrayList<>();
        while (rs.next()){
            list.add(new Customer(rs.getInt(1),rs.getString(2),rs.getString(3)));
        }
        rs.close();
        st.close();
        con.close();
        return list;
    }

}
