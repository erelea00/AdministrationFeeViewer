<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title><fmt:message key="title"/></title>
  <style>
    .error { color: red; }
  </style>  
</head>
<body>
<h1><fmt:message key="heading.selection"/></h1><br/><br/>
<form:form method="post" commandName="newAdministrationFee">
  <form:select path="modality" id="modality">
       	<form:option value=""><fmt:message key="selection.comboBox"/></form:option>
      	<form:option value="Cuenta Personal"><fmt:message key="selection.personal"/></form:option>
       	<form:option value="Cuenta Plus"><fmt:message key="selection.plus"/></form:option>
       	<form:option value="Cuenta Empresa"><fmt:message key="selection.company"/></form:option>
  </form:select><br/>
  <form:errors path="modality" cssClass="error"/><br/><br/>
  <input type="submit" value="Continuar">
  <br/><br/><br/><br/><br/><br/><br/>
</form:form>
<a href="<c:url value="mainPage.htm"/>">Home</a>
</body>
</html>