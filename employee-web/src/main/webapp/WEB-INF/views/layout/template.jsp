<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width" />
<script type="text/javascript">
</script>
<c:set var="titleKey">
  <tiles:insertAttribute name="title" ignore="true" />
</c:set>
<title><spring:message code="${titleKey}" text="employee" /></title>
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/app/css/styles.css">
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/vendor/bootstrap-3.0.0/css/bootstrap.css"
    type="text/css" media="screen, projection">    
<style>
button {
	border-radius: 12px;
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	margin: 4px 2px;
	cursor: pointer;
	height: 40px;
	width: 100px;
}
.pagination li {
    display: inline;
}

.pagination li>a {
    margin-left: 10px;
}

</style>    
</head>
<body>
<div class="container">
  <tiles:insertAttribute name="header" />
  	<br>
  	<br>
  	<hr>
    <tiles:insertAttribute name="body" />
    <br>
    <br>
    <hr>
    <p style="text-align: center; background: #e5eCf9;">Copyright
      &copy; Thu Thu Soe</p>
  </div>
</body>
</html>