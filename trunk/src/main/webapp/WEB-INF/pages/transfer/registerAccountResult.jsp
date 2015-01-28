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

    </spring:bind>
    <form:form commandName="transfer" method="post" action="registerAccountResult" id="transferForm" >

        <table class="table-striped" style="width: 100%">

            <tr>
                <th style="width: 200px"><fmt:message key="transactionDate"/></th>
                <td><c:out value="${transfer.strTransactionDate}"/></td>

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
                <th><fmt:message key="status"/></th>
                <td><c:out value="${transfer.status}"/></td>
            </tr>
        </table>

        <br />
        <hr />
        <div id="actions" class="form-group">
            <a class="btn btn-primary" href="<c:url value='/home'/>" >
                <i class="icon-ok icon-white"></i>
                <fmt:message key="button.done"/>
            </a>
        </div>
    </form:form>

</div>


