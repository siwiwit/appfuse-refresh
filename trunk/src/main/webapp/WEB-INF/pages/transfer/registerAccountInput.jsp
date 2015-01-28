<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="menu.register.account"/></title>
</head>

<%--<div class="col-sm-2">
    <h2><fmt:message key="signup.heading"/></h2>
    <p><fmt:message key="signup.message"/></p>
</div>--%>
<div class="col-sm-7">
    <h2><fmt:message key="menu.register.account"/></h2>
    <hr />
    <br />
    <spring:bind path="transfer.*">
<%--
        <c:if test="${not empty status.errorMessages}">
            <div class="alert alert-danger alert-dismissable">
                <a href="#" data-dismiss="alert" class="close">&times;</a>
                <c:forEach var="error" items="${status.errorMessages}">
                    <c:out value="${error}" escapeXml="false"/><br/>
                </c:forEach>
            </div>
        </c:if>
--%>
    </spring:bind>
    <form:form commandName="transfer" method="post" action="registerAccountInput" id="transferForm" >

        <div class="row">
            <div class="col-sm-6 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">

                <spring:bind path="transfer.destinationAccountNumber">
                    <appfuse:label styleClass="control-label" key="transfer.destinationAccountNumber"/>
                    <form:input cssClass="form-control" path="destinationAccountNumber" id="destinationAccountNumber" />
                    <%--<form:errors path="destinationAccountNumber" cssClass="help-block"/>--%>
                </spring:bind>
            </div>
        </div>

        <br />
        <hr />
        <button type="submit" name="view" class="btn btn-primary" onclick="bCancel=false">
            <i class="icon-upload icon-white"></i> <fmt:message key="next"/>
        </button>
    </form:form>

</div>

