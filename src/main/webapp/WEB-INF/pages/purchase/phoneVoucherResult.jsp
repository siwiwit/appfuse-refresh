<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="menu.prepaid.handphone"/></title>
</head>

<%--<div class="col-sm-2">
    <h2><fmt:message key="signup.heading"/></h2>
    <p><fmt:message key="signup.message"/></p>
</div>--%>
<div class="col-sm-7">
    <h2><fmt:message key="menu.prepaid.handphone"/></h2>
    <hr />
    <br />
    <spring:bind path="voucherPurchase.*">

    </spring:bind>
    <form:form commandName="voucherPurchase" method="post" action="voucherPurchaseResult" id="voucherPurchaseForm" >

        <table class="table-striped" style="width: 100%">

            <tr>
                <th style="width: 200px"><fmt:message key="transactionDate"/></th>
                <td><c:out value="${voucherPurchase.strTransactionDate}"/></td>

            </tr>
            <tr>
                <th><fmt:message key="voucherPurchase.operator"/></th>
                <td><c:out value="${voucherPurchase.operator}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="voucherPurchase.phoneNumber"/></th>
                <td><c:out value="${voucherPurchase.phoneNumber}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="voucherPurchase.denomination"/></th>
                <td><c:out value="${voucherPurchase.denomination}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="voucherPurchase.amount"/></th>
                <td><c:out value="${voucherPurchase.amount}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="status"/></th>
                <td><c:out value="${voucherPurchase.status}"/></td>
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


