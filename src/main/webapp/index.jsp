<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DevOps Example</title>
    </head>
    <body bgcolor="silver">
        <form action="ProcessLogin" method="post"> 
            <center>
            <table border="0" width="30%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">Login Page</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="username" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="action" value="Login"/></td>
                        <td> <input type="submit" name="action" value="Reset"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">New User <a href="register.jsp">Register Here</a></td>
                    </tr>
                    <tr>
                    	<br/>
                    	<br/>
                    	<br/>
                        <td colspan="2"><p><font size="2" color="blue">Default password is test, change Reset to change it!</font></p></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
    </body>
</html>