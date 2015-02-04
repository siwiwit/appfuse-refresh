<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="menu.prepaid.handphone"/></title>
</head>

<div class="col-sm-7">
    <h2><fmt:message key="menu.prepaid.electricity"/></h2>
    <hr />
    <br />
    <spring:bind path="electricityPurchase.*">
        
    </spring:bind>
    <form:form commandName="electricityPurchase" method="post" action="electricityPurchaseConfirm" id="electricityPurchaseConfirmForm" >

        <table class="table-striped" style="width: 100%">

            <tr>
                    <th><fmt:message key="purchase.accountNumber"/></th>
                <td><c:out value="${electricityPurchase.accountNumber}"/></td>
            </tr>
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
                <th><fmt:message key="purchase.amount"/></th>
                <td><c:out value="${electricityPurchase.amount}"/></td>
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
                <td><form:password cssClass="form-control" path="${token}" id="token" showPassword="true" cssStyle="width: 150px;" maxlength="6"/></td>
            </tr>
        </table>

        <br />
        <button type="submit" name="view" class="btn btn-primary" onclick="bCancel=false">
            <i class="icon-upload icon-white"></i> <fmt:message key="next"/>
        </button>
    </form:form>

</div>


