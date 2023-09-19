<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body >
    <h3>Enter Employee Details :</h3>
  
    <form action="saveEmployee" method="post">
        <table>
  
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" /></td>
            </tr>  
            <tr>
                <td>Address:</td>
                <td><input type="text" name="address" /></td>
            </tr>  
            <tr>
                <td>Salary:</td>
                <td><input type="text" name="salary" /></td>
            </tr>  
        </table>
  
        <input type="submit" value="Submit Details">
  
    </form>
    <h3>View All Employee Details :</h3>

  <form action="viewAllEmployees" method="get">
          <table>
               <input type="submit" value="View All Employee Details">
  		  </table>
  </form>
</body>
</html>