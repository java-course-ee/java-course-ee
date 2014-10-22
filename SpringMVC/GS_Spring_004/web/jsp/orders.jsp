<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link type="text/css" href="css/ui-lightness/jquery-ui-1.7.2.custom.css" rel="stylesheet"/>
<link type="text/css" href="css/newOrder.css" rel="stylesheet"/>
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.7.2.custom.min.js"></script>
<script type="text/javascript" src="js/ui.datetimepicker.js"></script>
<script type="text/javascript">

    $(function () {

        // dateTimePicker
        $('.datetimepicker').datetimepicker({ dateFormat: 'dd-mm-yy', timeFormat: ' hh:ii:ss' });

        $("#add_application").click(function () {
            $("#applications").show()
            $("#applications option[value=default]").show()
            $("#applications option[value=default]").attr('selected', 'selected')
            return false;
        });


        $("#applications").change(function () {
            $("#applications option[value=default]").hide();
            $("#add").show()
        });

        $("#add").click(function () {
            var application = $("#applications option:selected").text();
            var applicationId = $("#applications").val();
            var text = $("#results").find("option:eq(" + applicationId + ")").text();
            if ($('#results option[value=' + applicationId + ']').length > 0) {
                alert('Element already exists');
                return false;
            } else {
                $("#results").append("<option value='" + applicationId + "'>" + application + "</option>")
                return false;
            }

        });


        $("#delete").click(function () {
            if (typeof $("#results option:selected").val() === "undefined") {
                alert('Выберите элемент!')
                return false;
            }
            $("#results option:selected").remove()
            return false;


        });


        $("#submit").click(function () {
            $("#results option").attr('selected', 'yes');
        });


    });


</script>


<div class="title">Управление заявками</div>
<br>

<div class="grid">


    <table>
        <tr class="table_head">
            <td width="7%">CPU</td>
            <td width="7%">HDD</td>
            <td width="7%">RAM</td>
            <td width="30%">Период</td>
            <td width="20%">Описание</td>
            <td width="5%">Статус</td>
            <td width="3%"></td>
            <td width="3%"></td>

        </tr>
        <c:set var="count" value="0" scope="page"/>


        <c:forEach items="${orders}" var="o">

            <c:set var="count" value="${count + 1}" scope="page"/>

            <tr <c:if test="${(count % 2) == 0}"><c:out value="class=table_row_1"/></c:if> >

                <td><c:out value="${o.cpu}"/> GHz</td>
                <td><c:out value="${o.hdd}"/> Gb</td>
                <td><c:out value="${o.ram}"/> Gb</td>
                <td><c:out value="${o.startDate}"/> - <c:out value="${o.finishDate}"/></td>
                <td><c:out value="${o.description}"/></td>
                <c:set var="statusName" value="${o.status.statusName}"/>
                <td
                        <c:if test="${statusName eq 'submitted'}"><c:out value="class=submitted"/></c:if>
                        <c:if test="${statusName eq 'in_progress'}"><c:out value="class=in_progress"/></c:if>
                        <c:if test="${statusName eq 'approved'}"><c:out value="class=approved"/></c:if>
                        <c:if test="${statusName eq 'declined'}"><c:out value="class=declined"/></c:if>
                        >
                    <c:out value="${o.status.alias}"/></td>


                <c:set var="editValue" value="/orders.htm"/>
                <c:set var="deleteValue" value="/orders.htm"/>

                <c:url var="editUrl" value="${editValue}">
                    <c:param name="action" value="edit"/>
                    <c:param name="orderId" value="${o.orderId}"/>
                </c:url>
                <c:url var="deleteUrl" value="${deleteValue}">
                    <c:param name="action" value="delete"/>
                    <c:param name="orderId" value="${o.orderId}"/>
                </c:url>
                <td><a href="${editUrl}">Edit</a></td>
                <td><a href="${deleteUrl}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

</div>

<div class="messages">

    <c:if test="${requestScope.errorMessage ne null}">
        <c:out value="${requestScope.errorMessage}"/>
    </c:if>

</div>

<br>

<div class="form">
    <form:form commandName="newOrder">
        <fieldset>
            <table>
                <tr>
                    <td>CPU, GHz <span class="required">*</span></td>
                    <td><form:select path="cpu">
                        <c:forEach items="${cpuList}" var="cpu">
                            <form:option value="${cpu}" label="${cpu} GHz"/>
                        </c:forEach>
                    </form:select>
                    </td>
                    <td><form:errors path="cpu" cssStyle="color:red"/></td>
                </tr>
                <tr>
                    <td>HDD, Gb <span class="required">*</span></td>
                    <td><form:select path="hdd">
                        <c:forEach items="${hddList}" var="hdd">
                            <form:option value="${hdd}" label="${hdd} Gb"/>
                        </c:forEach>
                    </form:select>

                    </td>
                    <td><form:errors path="hdd" cssStyle="color:red"/></td>
                </tr>
                <tr>
                    <td>RAM, Gb <span class="required">*</span></td>
                    <td><form:select path="ram">
                        <c:forEach items="${ramList}" var="ram">
                            <form:option value="${ram}" label="${ram} Gb"/>
                        </c:forEach>
                    </form:select>
                    </td>
                    <td><form:errors path="ram" cssStyle="color:red"/></td>
                </tr>
                <tr>
                    <td>Start Date <span class="required">*</span></td>
                    <td><form:input path="startDate" cssClass="datetimepicker"/></td>
                    <td><form:errors path="startDate" cssStyle="color:red"/></td>
                </tr>
                <tr>
                    <td>Finish Date <span class="required">*</span></td>
                    <td><form:input path="finishDate" cssClass="datetimepicker"/></td>
                    <td><form:errors path="finishDate" cssStyle="color:red"/></td>
                </tr>

                <tr>
                    <td>Applications</td>
                    <td>
                        <form:select path="applications" multiple="multiple" size="7" id="results">
                            <c:if test="${editedOrder ne null}">
                                <c:forEach items="${editedOrder.applications}" var="a">
                                    <option value="${a.applicationId}"><c:out value="${a.applicationName}"/></option>
                                </c:forEach>
                            </c:if>
                        </form:select>

                        <div>
                            <a href="#" id="add_application">Add</a>&nbsp;
                            <a href="#" id="delete">Remove</a>
                        </div>

                    </td>
                    <td>
                        <select id="applications" style="display:none;">
                            <option selected="selected" value="default">Выберите приложение</option>
                            <c:forEach items="${applications}" var="a">
                                <option value="${a.applicationId}"><c:out value="${a.applicationName}"/></option>
                            </c:forEach>
                        </select>
                        <a href="#" id="add" style="display:none;">Add</a>
                        <br/>

                        <form:errors path="applications" cssStyle="color:red"/>
                    </td>

                </tr>


                <tr>
                    <td>Description</td>
                    <td><form:textarea cols="35" rows="5" path="description"/></td>
                    <td><form:errors path="description" cssStyle="color:red"/></td>
                </tr>


                <c:if test="${statuces ne null}">
                    <tr>
                        <td>Status <span class="required">*</span></td>
                        <td><form:select path="status">
                            <form:options items="${statuces}" itemValue="statusId" itemLabel="alias"/>
                        </form:select>

                        </td>
                        <td><form:errors path="status" cssStyle="color:red"/></td>
                    </tr>
                </c:if>


                <tr>
                    <td></td>
                    <td align="right"><input type="submit" value="submit" class="button" id="submit"></td>
                    <td></td>
                </tr>


            </table>
        </fieldset>
    </form:form>
</div>

