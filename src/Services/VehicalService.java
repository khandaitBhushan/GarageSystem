package Services;

import Config.DBConfig;
import Entity.Vehical;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicalService {
    public void addVehical(Vehical veh) throws SQLException {
        String query = "insert into vehical(cus_id,veh_num,veh_model) values(?,?,?)";
        Connection con = DBConfig.getConnection();
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, veh.getCusId());
        st.setString(2, veh.getNumberPlate());
        st.setString(3, veh.getModel());
        st.executeUpdate();
        st.close();
        con.close();
    }

    public ArrayList<Vehical> getAllVehical() throws SQLException {
        String query = "select *from vehical";
        Connection con = DBConfig.getConnection();
        PreparedStatement st = con.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        ArrayList<Vehical> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new Vehical(rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getString(4)));
        }
        rs.close();
        st.close();
        con.close();
        return list;
    }

}
