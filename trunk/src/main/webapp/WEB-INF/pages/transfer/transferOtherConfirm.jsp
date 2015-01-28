<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="menu.transfer.internal"/></title>
</head>

<%--<div class="col-sm-2">
    <h2><fmt:message key="signup.heading"/></h2>
    <p><fmt:message key="signup.message"/></p>
</div>--%>
<div class="col-sm-7">
    <h2><fmt:message key="menu.transfer.internal"/></h2>
    <hr />
    <br />
    <spring:bind path="transfer.*">
        <%--<c:if test="${not empty status.errorMessages}">
            <div class="alert alert-danger alert-dismissable">
                <a href="#" data-dismiss="alert" class="close">&times;</a>
                <c:forEach var="error" items="${status.errorMessages}">
                    <c:out value="${error}" escapeXml="false"/><br/>
                </c:forEach>
            </div>
        </c:if>--%>
    </spring:bind>
    <form:form commandName="transfer" method="post" action="transferOtherConfirm" id="transferForm" >

        <table class="table-striped" style="width: 100%">

            <%--<tr>
                <th><fmt:message key="transfer.destinationBankCode"/></th>
                <td><c:out value="${transfer.destinationBankCode}"/></td>

            </tr>--%>
            <tr>
                <th><fmt:message key="transfer.destinationBankName"/></th>
                <td><c:out value="${transfer.destinationBankName}"/></td>

            </tr>
            <tr>
                <th><fmt:message key="transfer.destinationAccountNumber"/></th>
                <td><c:out value="${transfer.destinationAccountNumber}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="transfer.destinationAccountName"/></th>
                <td><c:out value="${transfer.destinationAccountName}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="transfer.amount"/></th>
                <td><c:out value="${transfer.amount}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="transfer.transferTime"/></th>
                <td><c:out value="${transfer.transferTime}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="transfer.news"/></th>
                <td><c:out value="${transfer.news}"/></td>
            </tr>
        </table>

        <br />
        <hr />

        <table class="table-striped" style="width: 100%">
            <tr>
                <th colspan="2"><fmt:message key="token.please.input"/></th>
            </tr>
            <tr>
                <th style="width: 200px"><fmt:message key="token.response.appl1"/></th>
                <td><form:password cssClass="form-control" path="${token}" id="token" showPassword="true" cssStyle="width: 150px;"/></td>
            </tr>
        </table>

        <br />
        <button type="submit" name="view" class="btn btn-primary" onclick="bCancel=false">
            <i class="icon-upload icon-white"></i> <fmt:message key="next"/>
        </button>
    </form:form>

</div>


