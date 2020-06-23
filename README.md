<h1>Cinema</h1>
<h1>Table of Contents</h1>
<ul>
<li><a href="#project_purpose">Project purpose</a></li>
<li><a href="#project_structure">Project structure</a></li>
<li><a href="#For_developer">For developer</a></li>
<li><a href="#authors">Authors</a></li>
</ul>
<a name="project_purpose"></a><h2>Project purpose</h2>
This is a template for creating an pure back end part of cinema web site.
<br><br>
There are following models implemented in this project:
<ul>
<li>CinemaHall</li>
<li>Movie</li>
<li>MovieSession</li>
<li>Order</li>
<li>Role</li>
<li>ShoppingCart</li>
<li>Ticket</li>
<li>User</li>
</ul>
And following controllers for communications with front-end part:
<ul>
<li>AuthenticationController - to register new user (by default user will have USER role)</li>
<li>InjectController - by running server inject ADMIN and USER roles and user with ADMIN role in to DB</li>
<li>UserController - responsive for get authorized user and get user by email</li>
<li>ShoppingCartController, OrderController, MovieSessionController, MovieController, CinemaHallController - to get all and create appropriate models</li>
</ul>
<a name="project_structure"></a><h2>Project Structure</h2>
<ul>
<li>java 14</li>
<li>Maven</li>
<li>log4j 1.2.17</li>
<li>maven-checkstyle-plugin</li>
<li>mysql-connector-java</li>
<li>Hibernate</li>
<li>Spring core</li>
<li>Spring web</li>
<li>Spring security</li>
</ul>

<a name="For_developer"></a><h1>For developer</h1>

Open the project in your IDE.

Add it as maven project.

Configure Tomcat:
<ul>
<li>add artifact;</li>
<li>add sdk 11.0.3</li>
</ul>

Add sdk 11.0.3 in project structure.

Create a schema "cinema" in any SQL database.

At cinema.src.main.java.internet.shop.util.ConnectionUtil class use username and password for your DB to create a Connection.

Change a path in cinema.src.main.java.resources.log4j.properties. It has to reach your logFile.

Run the project.

<a name="authors"></a><h1>Authors</h1>
<a href="https://github.com/Merkald">Yaroslav Vysochanskii</a>