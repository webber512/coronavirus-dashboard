<div id="container-fluid">
	<%@ include file="/WEB-INF/layouts/navbar.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-10">
				<h1 class="pt-1 text-center">Coronavirus in ${state}</h1>
			</div>
			<div class="col-lg-2 pt-1">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="../states">States</a></li>
					<li class="breadcrumb-item active">${state}</li>
				</ol>
			</div>
		</div>
		<div class="row">
			<%@ include file="/WEB-INF/views/stats.jsp"%>
			<hr class="my-1 d-sm-none d-md-block" />
		</div>
	</div>
	<div class="row container-fluid">
		<div class="col-lg-6">
			<%@ include file="/WEB-INF/charts/state-daily.jsp"%>
		</div>
		<div class="col-lg-6">
			<%@ include file="/WEB-INF/charts/state-testing.jsp"%>
		</div>
	</div>
	<div class="row container-fluid">
		<div class="col-lg-12">
			<div class="alert alert-dismissible alert-light">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				If ${state} is reporting a negative number of cases, deaths, or
				tests, this is likely because of a change in how they are counted.
				As guidance from the Centers for Disease Control has evolved, so has
				the way that states have reported data. Deaths could be slighly
				lower due to deaths being miscounted. The number of tests could
				appear negative on a graph due to the way they are counted. For
				example, antibody tests were originally counted in some states, eg.
				Missouri, however, are now no longer included in states results.
				Data is pulled from The Covid Tracking Project.
			</div>
		</div>
	</div>

</div>
</body>