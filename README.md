<h1>Garage Management System (Java + JDBC)</h1>

<p>
A simple CLI-based project to manage customers, their vehicles, services, and invoices using Java, JDBC, and MySQL.
</p>

<h2>📌 Features</h2>
<ul>
  <li>Add customer with vehicle details</li>
  <li>Generate and view service invoices</li>
  <li>View available garage services</li>
  <li>Database relations with foreign keys</li>
</ul>

<h2>🛠 Tech Stack</h2>
<ul>
  <li>Java</li>
  <li>MySQL</li>
  <li>JDBC</li>
</ul>

<h2>📋 Database Tables</h2>
<ul>
  <li><code>customer</code>: Customer info</li>
  <li><code>vehical</code>: Vehicle info (linked to customer)</li>
  <li><code>service</code>: Predefined service list</li>
  <li><code>invoice</code>: Invoice info (linked to all above)</li>
</ul>

<h2>🚀 How to Run</h2>
<ol>
  <li>Start MySQL and run SQL script to create DB</li>
  <li>Update MySQL username/password in <code>DBConfig.java</code></li>
  <li>Run <code>App.java</code></li>
</ol>

<h2>⚠ Limitations</h2>
<ul>
  <li>No duplicate phone check</li>
  <li>Console-based, no GUI</li>
  <li>Invoice does not show joined details</li>
</ul>

<h2>👨‍💻 Author</h2>
<p>Bhushan Khandait | Final Year | Java Developer</p>
