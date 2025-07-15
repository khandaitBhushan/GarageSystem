package Services;

import Config.DBConfig;
import Entity.Customer;
import Entity.Invoice;
import Entity.Vehical;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);
    InvoiceService invoiceService = new InvoiceService();
    VehicalService vehicalService = new VehicalService();
    CustomerService customerService = new CustomerService();

    public static void main(String[] args) {
        try {
            new App().start();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void start() throws SQLException {
        while (true) {
            Connection con = DBConfig.getConnection();
            ResultSet rs;
            PreparedStatement pt;
            System.out.print("1. Add Customer with Vehicle \n2. Generate Invoice\n3. Show All Invoice\n4. Available Services(101-104)\n5.exit : ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> {

                    System.out.print("Enter customer name : ");
                    sc.nextLine();
                    String cusName = sc.nextLine();
                    System.out.print("Customer Phone : ");
                    String phone = sc.nextLine();
                    customerService.addCustomer(new Customer(-1, cusName, phone));


                    System.out.print("Enter service Id :");
                    int serId = sc.nextInt();
                    System.out.print("Vehicle Number plate : ");
                    String vehicalNum = sc.next();
                    System.out.print("Vehical model : ");
                    String vehicalMod = sc.next();
                    pt = con.prepareStatement("select *from customer where cus_phone = ?");
                    pt.setString(1, phone);
                    rs = pt.executeQuery();
                    rs.next();
                    int cusId = rs.getInt(1);
                    vehicalService.addVehical(new Vehical(-1, cusId, vehicalNum, vehicalMod));


                    pt = con.prepareStatement("select *from vehical where veh_num = ?");
                    pt.setString(1, vehicalNum);
                    rs = pt.executeQuery();
                    rs.next();
                    invoiceService.addInvoice(new Invoice(-1, cusId, serId, rs.getInt(1)));
                    rs.close();
                    pt.close();
                }

                case 2 -> {
                    System.out.print("Customer phone : ");
                    String phone = sc.next();
                    pt = con.prepareStatement("select *from customer where cus_phone = ?");
                    pt.setString(1, phone);
                    rs = pt.executeQuery();
                    rs.next();          // dont forgive this
                    ArrayList<Invoice> list = invoiceService.getInvoice(rs.getInt("cus_id"));
                    if (list.isEmpty()) {
                        System.out.println("No user found...!");
                    } else {
                        System.out.println("List of All Invoices : ");
                        for (Invoice invoice : list)
                            System.out.println(invoice);
                    }
                    pt.close();
                    rs.close();
                }
                case 3 -> {
                    System.out.println("All invoices : ");
                    ArrayList<Invoice> list = invoiceService.getAllInvoice();
                    if (list.isEmpty()) {
                        System.out.println("No user found...!");
                    } else {
                        System.out.println("List of All Invoices : ");
                        for (Invoice invoice : list)
                            System.out.println(invoice);
                    }
                }
                case 4 -> {
                    System.out.println("Available services : ");
                    pt = con.prepareStatement("select *from service");
                    rs = pt.executeQuery();
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getInt(3));
                    }
                    pt.close();
                    rs.close();
                }
                case 5 -> {
                    con.close();
                    System.exit(0);
                }
                default -> System.out.println("Not a valid choice");
            }
        }
    }
}

