<%@ include file="/WEB-INF/layouts/include.jsp"%>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<c:if test="${empty title}">
	<title>Spring Boot w/ Bootstrap</title>
</c:if>
<c:if test="${not empty title}">
	<title>${title}</title>
</c:if>

<!-- Bootstrap CSS Import -->
<link type="text/css" rel="stylesheet"
	href="<c:url value='/resources/css/vendor/bootstrap/bootstrap.min.css'/>">

<!-- Project CSS Import -->
<link type="text/css" rel="stylesheet"
	href="<c:url value='/resources/css/master.css' />" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/resources/css/custom-css.css' />" />

<!--Fontawesome - Load All Styles -->
<link type="text/css" rel="stylesheet"
	href="<c:url value='/resources/fonts/fontawesome/css/all.min.css' />" />
<link rel="canonical" href="https://fontawesome.com/icons?s=light">

<!--Fontawesome - JavaScript -->
<script defer
	src="<c:url value='/resources/fonts/fontawesome/js/all.min.js'/>"></script>

<!-- JQuery Import -->
<script src="<c:url value='/resources/js/vendor/jquery/jquery.js'/>"></script>

<!-- Popper -->
<script src="<c:url value='/resources/js/popper.min.js'/>"></script>

<!-- Bootstrap JS Import -->
<script
	src="<c:url value='/resources/js/vendor/bootstrap.bundle.min.js'/>"></script>

<script src="<c:url value='/resources/js/moment.min.js'/>"></script>
<script src="<c:url value='/resources/js/Chart.min.js'/>"></script>


<!-- Project JS Import -->
<script src="<c:url value='/resources/js/master.js' />"></script>


<!-- Datatables -->
<link type="text/css" rel="stylesheet"
	href="<c:url value='/resources/css/vendor/datatables/datatables.min.css'/>">
<script
	src="<c:url value='/resources/js/vendor/datatables/pdfmake.min.js'/>"></script>
<script
	src="<c:url value='/resources/js/vendor/datatables/vfs_fonts.js'/>"></script>
<script
	src="<c:url value='/resources/js/vendor/datatables/datatables.min.js'/>"></script>

<!-- Other -->
<script src="<c:url value='/resources/js/vendor/popper/popper.min.js'/>"></script>
<script src="<c:url value='/resources/js/vendor/datamaps/d3.min.js'/>"></script>
<script
	src="<c:url value='/resources/js/vendor/datamaps/topojson.min.js'/>"></script>
<script
	src="<c:url value='/resources/js/vendor/datamaps/datamaps.usa.min.js'/>"></script>

</head>