<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><fmt:message key="heading"/></h1><br/>
    <b><fmt:message key="accInfo"/></b><br/><br/><br/>
    
    <p>Modalidad de la cuenta:
    <c:out value="${model.account.getAdminFee().getModality()}"/></p>
    <p>Comisión de mantenimiento anual fija:
    <c:out value="${model.account.getAdminFee().getANUAL_ADMIN_FEE()}"/><i> Euros</i></p>
    <p>Comisión de mantenimiento por modalidad:
    <c:out value="${model.account.getAdminFee().getModalityFee()}"/><i> Euros</i></p>
    <p>Periodicidad de cobro de la comisión de mantenimiento por modalidad:
    <c:out value="${model.account.getAdminFee().getFeePeriod()}"/></p>
    
    <br>
    <a href="<c:url value="setModality.htm"/>"><fmt:message key="Seleccionar modalidad cuenta"/></a>
    <br>
  </body>
</html>