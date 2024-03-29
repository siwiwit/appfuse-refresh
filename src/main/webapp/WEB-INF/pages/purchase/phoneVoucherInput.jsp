<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="menu.prepaid.handphone"/></title>
    <script type="text/javascript" src="<c:url value='/scripts/added/jquery-1.11.2.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/added/jquery-ui-1.11.2.custom/jquery-ui.js'/>"></script>
    <script>
        $(function() {
            $( ".cdatepicker" ).datepicker();
        });
    </script>
</head>

<div class="col-sm-7">
    <h2><fmt:message key="menu.prepaid.handphone"/></h2>
    <hr />
    <br />
    <spring:bind path="voucherPurchase.*">
        <c:if test="${not empty status.errorMessages}">
            <div class="alert alert-danger alert-dismissable">
                <a href="#" data-dismiss="alert" class="close">&times;</a>
                <c:forEach var="error" items="${status.errorMessages}">
                    <c:out value="${error}" escapeXml="false"/><br />
                </c:forEach>
            </div>
        </c:if>
    </spring:bind>

    <form:form commandName="voucherPurchase" method="post" action="phoneVoucherInput" id="phoneVoucherInputForm" >
    <table class="table-striped" style="width: 100%">
        <tr style="vertical-align: middle">
            <td style="width: 200px;">
                <fmt:message key="voucherPurchase.accountNumber"/>
            </td>
            <td>
                <select name="accNo" class="cselect" id="accNo" style="width: 150px;">
                    <option selected="selected">6022233375</option>
                    <option>6077666001</option>
                    <option>6095553200</option>
                </select>
            </td>
        </tr>
        <tr style="vertical-align: middle">
            <td>
                <fmt:message key="voucherPurchase.operator"/>
            </td>
            <td>
                <select name="selectOperator" class="cselect" id="selectOperator" style="width: 150px;">
                    <option selected="selected">Simpati</option>
                    <option>XL</option>
                    <option>Kartu As</option>
                    <option>Three</option>
                </select>
            </td>
        </tr>
        <tr style="vertical-align: middle">
            <td>
                <fmt:message key="voucherPurchase.denomination"/>
            </td>
            <td>
                <select name="selectDenomination" class="cselect" id="selectDenomination" style="width: 150px;">
                    <option selected="selected">5.000</option>
                    <option>10.000</option>
                    <option>20.000</option>
                    <option>50.000</option>
                    <option>100.000</option>
                </select>
            </td>
        </tr>
        <tr style="vertical-align: middle">
            <td>
                <fmt:message key="voucherPurchase.phoneNumber"/>
            </td>
            <td>
                <spring:bind path="voucherPurchase.phoneNumber">
                    <form:input cssClass="form-control" path="phoneNumber" id="phoneNumber" />
                </spring:bind>
            </td>
        </tr>
    </table>

    <br />
    <hr />
    <button type="submit" name="view" class="btn btn-primary" onclick="bCancel=false">
        <i class="icon-upload icon-white"></i> <fmt:message key="next"/>
    </button>
    </form:form>

</div>

