<div id="container-fluid">
	<%@ include file="/WEB-INF/layouts/navbar.jsp"%>

	<div class="container-fluid">
		<h1 class="mt-1 text-center">Coronavirus Dashboard - Home</h1>
		<%@ include file="/WEB-INF/views/stats.jsp"%>
		<hr class="my-1 d-sm-none d-md-block" />
	</div>
	<div class="row container-fluid">
		<div class="col-lg-6">
			<%@ include file="/WEB-INF/charts/us-daily.jsp"%>
		</div>
		<div class="col-lg-6">
			<%@ include file="/WEB-INF/charts/us-testing.jsp"%>

		</div>
	</div>

</div>
</body>