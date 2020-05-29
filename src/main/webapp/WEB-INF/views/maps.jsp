<%@ include file="/WEB-INF/layouts/navbar.jsp"%>

<div class="container-fluid">
	<h1 class="mt-1 text-center">Maps</h1>
	<%@ include file="/WEB-INF/views/stats.jsp"%>
	<hr class="my-1 d-sm-none d-md-block" />
</div>
<div class="row container-fluid">
	<div class="col-lg-12">
		<div class="bs-example">
			<ul class="nav nav-tabs">
				<li class="nav-item"><a class="nav-link active"
					data-toggle="tab" href="#sectionA">Case Maps</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#sectionB">Death Maps (coming soon)</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#sectionC">Testing Maps (coming soon)</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#sectionD">About Maps</a></li>
			</ul>
			<div class="tab-content">
				<div id="sectionA" class="tab-pane fade show active">
					<div class="row container-fluid">
						<div class="col-lg-6">
							<div id="casesPerState"></div>
						</div>
						<div class="col-lg-6">
							<div id="casesPerCap"></div>
						</div>
					</div>
				</div>
				<div id="sectionB" class="tab-pane fade">
					<div class="row container-fluid">
						<div class="col-lg-6">
							<div id="container2"></div>
						</div>
						<div class="col-lg-6">
							<div id="deathsPerCap"></div>
						</div>
					</div>
				</div>
				<div id="sectionC" class="tab-pane fade">
					<!-- <%@ include file="/WEB-INF/charts/map-deaths.jsp"%>-->
				</div>
				<div id="sectionD" class="tab-pane fade">Coming soon.</div>
			</div>
		</div>
	</div>
</div>

<script>
var series = [ ${stateData} ];
var dataset = {};
var onlyValues = series.map(function(obj) {
	return obj[1];
});
var minValue = Math.min.apply(null, onlyValues), maxValue = Math.max.apply(
		null, onlyValues);
var paletteScale = d3.scale.linear().domain([ minValue, maxValue ]).range(
		[ "#e7f3f8", "#107094" ]); // blue color

series.forEach(function(item) { //
	var iso = item[0], value = item[1], val2 = item[2], val3 = item[3];
	dataset[iso] = {
		numberOfThings : value,
		deaths: val2,
		tests: val3,
		fillColor : paletteScale(value)
	};
});

var map = new Datamap({
	element : document.getElementById('casesPerState'),
	scope : 'usa',
	responsive: true,
	fills : {
		defaultFill : '#F5F5F5'
	},
	data : dataset,
	geographyConfig : {
		borderColor : '#DEDEDE',
		highlightBorderWidth : 2,
		highlightFillColor : function(geo) {
			return geo['fillColor'] || '#F5F5F5';
		},
		highlightBorderColor : '#B7B7B7',
		popupTemplate : function(geo, data) {
			if (!data) {
				return;
			}
			return [ '<div class="hoverinfo">', '<strong>',
					geo.properties.name, '</strong>',
					'<br>Number of Cases: <strong>', data.numberOfThings,
					'</strong><br>Number of Deaths: <strong>', data.deaths, '</strong><br/>Number of Tests: <strong>', data.tests, '</div>' ].join('');
		}
	}
});
map.labels();
</script>
<script>
var series2 = [ ${perCapData} ];
var dataset2 = {};
var onlyValues2 = series2.map(function(obj) {
	return obj[1];
});
var minValue2 = Math.min.apply(null, onlyValues2), maxValue2 = Math.max.apply(
		null, onlyValues2);
var paletteScale2 = d3.scale.linear().domain([ minValue2, maxValue2 ]).range(
		[ "#e7f3f8", "#107094" ]); // blue color

series2.forEach(function(item) { //
	var iso2 = item[0], value2 = item[1], v2 = item[2], v3 = item[3];
	dataset2[iso2] = {
		numberOfThings : value2,
		deaths: v2,
		tests: v3,
		fillColor : paletteScale2(value2)
	};
});

var map2 = new Datamap({
	element : document.getElementById('casesPerCap'),
	scope : 'usa',
	responsive: true,
	fills : {
		defaultFill : '#F5F5F5'
	},
	data : dataset2,
	geographyConfig : {
		borderColor : '#DEDEDE',
		highlightBorderWidth : 2,
		highlightFillColor : function(geo) {
			return geo['fillColor'] || '#F5F5F5';
		},
		highlightBorderColor : '#B7B7B7',
		popupTemplate : function(geo, data) {
			if (!data) {
				return;
			}
			return [ '<div class="hoverinfo">', '<strong>',
				geo.properties.name, '</strong>',
				'<br>Number of Cases per 100k: <strong>', data.numberOfThings,
				'</strong><br>Number of Deaths per 100k: <strong>', data.deaths, '</strong><br/>Number of Tests per 100k: <strong>', data.tests, '</div>' ].join('');
		}
	}
});
map2.labels();
</script>












<script>
var series3 = [ ${stateData} ];
var dataset3 = {};
var onlyValues3 = series3.map(function(obj) {
	return obj[2];
});
var minValue3 = Math.min.apply(null, onlyValues3), maxValue3 = Math.max.apply(
		null, onlyValues3);
var paletteScale3 = d3.scale.linear().domain([ minValue3, maxValue3 ]).range(
		[ "#e7f3f8", "#107094" ]); // blue color

series3.forEach(function(item) { //
	var iso3 = item[0], value03 = item[1], val04 = item[2], val05 = item[2];
	dataset3[iso3] = {
		numberOfThings : val04,
		deaths: val04,
		tests: val05,
		fillColor : paletteScale3(val04)
	};
});

var mapDeaths = new Datamap({
	element : document.getElementById('container2'),
	scope : 'usa',
	responsive: true,
	height: 200,
	width: 200,
	fills : {
		defaultFill : '#F5F5F5'
	},
	data : dataset3,
	geographyConfig : {
		borderColor : '#DEDEDE',
		highlightBorderWidth : 2,
		highlightFillColor : function(geo) {
			return geo['fillColor'] || '#F5F5F5';
		},
		highlightBorderColor : '#B7B7B7',
		popupTemplate : function(geo, data) {
			if (!data) {
				return;
			}
			return [ '<div class="hoverinfo">', '<strong>',
					geo.properties.name, '</strong>',
					'<br>Number of Cases: <strong>', data.numberOfThings,
					'</strong><br>Number of Deaths: <strong>', data.deaths, '</strong><br/>Number of Tests: <strong>', data.tests, '</div>' ].join('');
		}
	}
});
map.labels();
$(window).on('resize', function() {
	mapDeaths.resize();
    datamap.svg.selectAll("g").attr("transform", "translate(" + d3.event.translate + ")scale(" + d3.event.scale + ")");
});
</script>
<script>
var series2 = [ ${perCapData} ];
var dataset2 = {};
var onlyValues2 = series2.map(function(obj) {
	return obj[1];
});
var minValue2 = Math.min.apply(null, onlyValues2), maxValue2 = Math.max.apply(
		null, onlyValues2);
var paletteScale2 = d3.scale.linear().domain([ minValue2, maxValue2 ]).range(
		[ "#e7f3f8", "#107094" ]); // blue color

series2.forEach(function(item) { //
	var iso2 = item[0], value2 = item[1], v2 = item[2], v3 = item[3];
	dataset2[iso2] = {
		numberOfThings : value2,
		deaths: v2,
		tests: v3,
		fillColor : paletteScale2(value2)
	};
});

var map2 = new Datamap({
	element : document.getElementById('deathsPerCap'),
	scope : 'usa',
	responsive: true,
	fills : {
		defaultFill : '#F5F5F5'
	},
	data : dataset2,
	geographyConfig : {
		borderColor : '#DEDEDE',
		highlightBorderWidth : 2,
		highlightFillColor : function(geo) {
			return geo['fillColor'] || '#F5F5F5';
		},
		highlightBorderColor : '#B7B7B7',
		popupTemplate : function(geo, data) {
			if (!data) {
				return;
			}
			return [ '<div class="hoverinfo">', '<strong>',
				geo.properties.name, '</strong>',
				'<br>Number of Cases per 100k: <strong>', data.numberOfThings,
				'</strong><br>Number of Deaths per 100k: <strong>', data.deaths, '</strong><br/>Number of Tests per 100k: <strong>', data.tests, '</div>' ].join('');
		}
	}
});
map2.labels();
</script>
</body>