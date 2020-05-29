<%@ include file="/WEB-INF/layouts/include.jsp"%>

<div class="row container-fluid">
	<div class="col-lg-4">
		<div class="card text-white bg-primary mb-3">
			<h4 class="card-header">Cases</h4>
			<div class="card-body">
				<h5 class="card-title">
					Currently Confirmed:
					<fmt:formatNumber type="number" value="${confirmedCases}" />
				</h5>
				<p class="card-text">
					Daily Increase:
					<fmt:formatNumber type="number" value="${caseIncreaseDay}" />
					<br /> Last week (7 calendar days):
					<fmt:formatNumber type="number" value="${confirmedCases7d}" />
					<br />Increase of
					<fmt:formatNumber type="number" value="${caseIncrease7d}" />
					cases, or
					<fmt:formatNumber type="number" minFractionDigits="2"
						maxFractionDigits="2" value="${casePercentage}" />
					%
				</p>
			</div>
		</div>
	</div>
	<div class="col-lg-4">
		<div class="card text-white bg-danger mb-3">
			<h4 class="card-header">Deaths</h4>
			<div class="card-body">
				<h5 class="card-title">
					Current Deaths:
					<fmt:formatNumber type="number" value="${confirmedDeaths}" />
				</h5>
				<p class="card-text">
					Daily Increase:
					<fmt:formatNumber type="number" value="${deathIncreaseDay}" />
					<br /> Last week (7 calendar days):
					<fmt:formatNumber type="number" value="${confirmedDeaths7d}" />
					<br />Increase of
					<fmt:formatNumber type="number" value="${deathIncrease7d}" />
					deaths, or
					<fmt:formatNumber type="number" minFractionDigits="2"
						maxFractionDigits="2" value="${deathPercentage}" />
					%
				</p>
			</div>
		</div>
	</div>
	<div class="col-lg-4">
		<div class="card text-white bg-info mb-3">
			<h4 class="card-header">Tests</h4>
			<div class="card-body">
				<h5 class="card-title">
					Currently Tested:
					<fmt:formatNumber type="number" value="${confirmedTests}" />
				</h5>
				<p class="card-text">
					Daily Increase:
					<fmt:formatNumber type="number" value="${testIncreaseDay}" />
					<br />Last week (7 calendar days):
					<fmt:formatNumber type="number" value="${confirmedTests7d}" />
					<br />Increase of
					<fmt:formatNumber type="number" value="${testIncrease7d}" />
					tests, or
					<fmt:formatNumber type="number" minFractionDigits="2"
						maxFractionDigits="2" value="${testPercentage}" />
					%
				</p>
			</div>
		</div>
	</div>
</div>