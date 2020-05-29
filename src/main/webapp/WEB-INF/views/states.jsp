<%@ include file="/WEB-INF/layouts/navbar.jsp"%>

<div class="container-fluid">
	<h1 class="mt-1 text-center">State Data</h1>
	<hr class="my-1 d-sm-none d-md-block" />
</div>
<div class="row container-fluid">
	<div class="col-lg-12">
		<div class="table-responsive">
			<table class="table table-striped" id="states">
				<thead>
					<tr>
						<th>State</th>
						<th>Total Cases</th>
						<th>Cases per Cap</th>
						<th>Total Deaths</th>
						<th>Deaths per Cap</th>
						<th>Total Tests</th>
						<th>Tests per Cap</th>
						<th>Grade</th>
						<th>Last Updated (Eastern)</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>

<script>
	$(document).ready(
			function() {
				var table = $('#states').DataTable(
						{
							dom : 'Bfrtip',
							lengthChange : true,
							"pagingType" : "full_numbers",
							"ajax" : {
								"url" : "api/states/all",
								"contentType" : "application/json",
								"type" : "GET",
								cache : true
							},
							"columns" : [ {
								"data" : "name"
							}, {
								"data" : "positive"
							}, {
								"data" : "positivePerCap"
							}, {
								"data" : "deaths"
							}, {
								"data" : "deathPerCap"
							}, {
								"data" : "tests"
							}, {
								"data" : "testPerCap"
							}, {
								"data" : "grade"
							}, {
								"data" : "lastUpdate"
							} ],
							scrollY : '55vh',
							scrollCollapse : true,
							fixedHeader : true,
							"lengthMenu" : [ [ 10, 15, 50, 100, -1 ],
									[ 10, 15, 50, 100, "All" ] ],
							"pageLength" : 20
						});
			});
</script>