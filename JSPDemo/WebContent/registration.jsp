<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="registration.css" rel="stylesheet"/>
<title>Insert title here</title>
</head>
<body>
<form action="Register" method="post" name="register" onsubmit="return validate()">
<div class="register-box">
<h2>Register Here</h2>
<div class="input-container">
<input class="input-field" type="text" placeholder="Username" name="name" id="nm">

</div>

<div class="input-container">
<input class="input-field" type="text" placeholder="Mail" name="mail">
</div>

<div class="input-container">
<input class="input-field" type="text" placeholder="Mobile" name="mob">
</div>

<div class="input-container">
<input class="input-field" type="password" placeholder="Password" name="pass">
</div>

<div class="input-container">
<input class="input-field" type="password" placeholder="Confirm Password" name="confpass">
</div>

<div class="input-container">
<select class="form-control" onchange="mycoursefun(this.value)" name="course">
<option>Select Course</option>
<sql:setDataSource
        var="myDS"
        url="jdbc:mysql://localhost:3306/Student"
        user="root" password=""
    />
     <sql:query var="courses"   dataSource="${myDS}">
        SELECT * FROM course;
    </sql:query>
     <c:forEach var="course" items="${courses.rows}">
     
    <option value="${course.cid}">${course.cname}</option>
         </c:forEach>
         </select>
</div>
<div class="input-container">
<select class="form-control" id="getyear" name="year">
<option>Select Year</option>

</select> 
   
</div>

<button type="submit">Register</button>

</div>
</form>
<div class="container" id='fom'>
<h2>Get Help</h2>
</div>
<button onclick="fun()">Help</button>
<script type="text/javascript">
function validate()
{
	var valid=true;
	if(document.register.name.value==""&&document.register.mob.value==""&&document.register.mail.value==""&&document.register.pass.value==""&&document.register.confpass.value=="")
	{
	alert( "Please fill all the fields!" );
	document.register.name.focus() ;
    valid= false;
	}
	else if(document.register.name.value=="")
		{
		alert( "Please provide your name!" );
		document.register.name.focus() ;
        valid= false;
		}
	else if(document.register.mob.value=="")
	{
	alert( "Please provide your mobile!" );
	document.register.mob.focus() ;
    valid= false;
	}
	else if(document.register.mail.value=="")
	{
	alert( "Please provide your mail!" );
	document.register.mail.focus() ;
    valid= false;
	}
	else if(document.register.pass.value=="")
	{
	alert( "Please provide your password!" );
	document.register.pass.focus() ;
    valid= false;
	}
	
	else if(document.register.confpass.value=="")
	{
	alert( "Please confirm your password!" );
	document.register.confpass.focus() ;
    valid= false;
	}
	if(document.register.confpass.value!=document.register.pass.value)
		{
		alert( "Password doesn't match!" );
		document.register.pass.focus() ;
	    valid= false;
		}
	 var email=0;
	 if (/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(document.register.mail.value))
	  {
		 
	  var email=1
	    
	  }
	 if(email==0)
		 {
	    alert("You have entered an invalid email address!")
	    valid=false;
		 }
	var phn=1;
	  var phoneno = /^\d{10}$/;
	  if((document.register.mob.value.match(phoneno)))
	        {
		  phn=0;
	        }
	      else if(phn==1)
	        {
	    	  document.register.mob.focus() ;
	        alert("Incorrect phone!");
	        valid= false;
	        }
	
	return valid;
		}
		
		
function mycoursefun(datavalue)
{
	$.ajax({
		url:'GetYear',
		type: 'POST',
		data: {datapost : datavalue},
		success: function(result){
			$('#getyear').html(result);
		}
	});
}

function fun()
{
	var req=new XMLHttpRequest();
	req.open('GET','help.html',true);
	req.send();
	req.onreadystatechange=function(){
		if(req.readyState==4 && req.status==200){
			document.getElementById('fom').innerHTML=req.responseText;
		}
	}
	
}
</script>
</body>
</html>