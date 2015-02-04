<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="menu.prepaid.electricity"/></title>
    <script type="text/javascript" src="<c:url value='/scripts/added/jquery-1.11.2.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/added/jquery-ui-1.11.2.custom/jquery-ui.js'/>"></script>
    <script>
        $(function() {
            $( ".cdatepicker" ).datepicker();
        });
    </script>
</head>

<div class="col-sm-7">
    <h2><fmt:message key="menu.prepaid.electricity"/></h2>
    <hr />
    <br />
    <spring:bind path="electricityPurchase.*">
        <c:if test="${not empty status.errorMessages}">
            <div class="alert alert-danger alert-dismissable">
                <a href="#" data-dismiss="alert" class="close">&times;</a>
                <c:forEach var="error" items="${status.errorMessages}">
                    <c:out value="${error}" escapeXml="false"/><br />
                </c:forEach>
            </div>
        </c:if>
    </spring:bind>

    <form:form commandName="electricityPurchase" method="post" action="electricityPurchaseInput" id="electricityPurchaseInputForm" >
    <table class="table-striped" style="width: 100%">
        <tr style="vertical-align: middle">
            <td style="width: 200px;">
                <fmt:message key="purchase.accountNumber"/>
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
                <fmt:message key="electricityPurchase.meterNumber"/>
            </td>
            <td>
                <spring:bind path="electricityPurchase.meterNumber">
                    <form:input cssClass="form-control" path="meterNumber" id="meterNumber" />
                </spring:bind>
            </td>
        </tr>
        <tr style="vertical-align: middle">
            <td>
                <fmt:message key="purchase.amount"/>
            </td>
            <td>
                <select name="selectDenomination" class="cselect" id="selectDenomination" style="width: 150px;">
                    <option selected="selected">50.000</option>
                    <option>100.000</option>
                    <option>200.000</option>
                    <option>500.000</option>
                    <option>1.000.000</option>
                </select>
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

