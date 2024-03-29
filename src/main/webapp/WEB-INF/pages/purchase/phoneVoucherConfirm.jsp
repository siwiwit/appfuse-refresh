<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="menu.prepaid.handphone"/></title>
</head>

<div class="col-sm-7">
    <h2><fmt:message key="menu.prepaid.handphone"/></h2>
    <hr />
    <br />
    <spring:bind path="voucherPurchase.*">
        
    </spring:bind>
    <form:form commandName="voucherPurchase" method="post" action="phoneVoucherConfirm" id="phoneVoucherConfirmForm" >

        <table class="table-striped" style="width: 100%">

            <tr>
                    <th><fmt:message key="voucherPurchase.accountNumber"/></th>
                <td><c:out value="${voucherPurchase.accountNumber}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="voucherPurchase.operator"/></th>
                <td><c:out value="${voucherPurchase.operator}"/></td>
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
                <th><fmt:message key="voucherPurchase.phoneNumber"/></th>
                <td><c:out value="${voucherPurchase.phoneNumber}"/></td>
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


