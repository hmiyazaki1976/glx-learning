<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<c:import url="./template/layout.jsp">
  <c:param name="title" value="Portal"/>
  <c:param name="content">
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper" id="mainContent">
        <!-- Main content -->
        <section class="content">
        
        <jsp:include page="" flush="true" name="redirectName"/>
        </section>
        <!-- /.content -->
      </div>
      <!-- /.content-wrapper -->
  </c:param>
</c:import>

