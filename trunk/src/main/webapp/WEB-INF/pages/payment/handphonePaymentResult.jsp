<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="menu.prepaid.electricity"/></title>
</head>

<%--<div class="col-sm-2">
    <h2><fmt:message key="signup.heading"/></h2>
    <p><fmt:message key="signup.message"/></p>
</div>--%>
<div class="col-sm-7">
    <h2><fmt:message key="menu.prepaid.electricity"/></h2>
    <hr />
    <br />
    <spring:bind path="electricityPurchase.*">

    </spring:bind>
    <form:form commandName="electricityPurchase" method="post" action="electricityPurchaseResult" id="electricityPurchaseForm" >

        <table class="table-striped" style="width: 100%">

            <tr>
                <th style="width: 200px"><fmt:message key="transactionDate"/></th>
                <td><c:out value="${electricityPurchase.strTransactionDate}"/></td>
            </tr>
            <%--<tr>
                <th><fmt:message key="purchase.accountNumber"/></th>
                <td><c:out value="${electricityPurchase.accountNumber}"/></td>

            </tr>--%>
            <tr>
                <th><fmt:message key="electricityPurchase.meterNumber"/></th>
                <td><c:out value="${electricityPurchase.meterNumber}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="electricityPurchase.idPel"/></th>
                <td><c:out value="${electricityPurchase.idPel}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="electricityPurchase.customerName"/></th>
                <td><c:out value="${electricityPurchase.customerName}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="electricityPurchase.tarifDaya"/></th>
                <td><c:out value="${electricityPurchase.tarifDaya}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="electricityPurchase.mlpo"/></th>
                <td><c:out value="${electricityPurchase.mlpo}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="purchase.amount"/></th>
                <td><c:out value="${electricityPurchase.amount}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="electricityPurchase.adminBank"/></th>
                <td><c:out value="${electricityPurchase.adminBank}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="electricityPurchase.materai"/></th>
                <td><c:out value="${electricityPurchase.materai}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="electricityPurchase.ppn"/></th>
                <td><c:out value="${electricityPurchase.ppn}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="electricityPurchase.ppj"/></th>
                <td><c:out value="${electricityPurchase.ppj}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="electricityPurchase.angsuran"/></th>
                <td><c:out value="${electricityPurchase.angsuran}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="electricityPurchase.rpStroomToken"/></th>
                <td><c:out value="${electricityPurchase.rpStroomToken}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="electricityPurchase.jumlahKwh"/></th>
                <td><c:out value="${electricityPurchase.jumlahKwh}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="electricityPurchase.stroomToken"/></th>
                <td><c:out value="${electricityPurchase.stroomToken}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="status"/></th>
                <td><c:out value="${electricityPurchase.status}"/></td>
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
