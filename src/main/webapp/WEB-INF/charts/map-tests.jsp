<div class="row container-fluid">
	<div class="col-lg-12">
		<div id="container3" style="position: relative"></div>
	</div>
</div>

<script>
	var series = [ ${stateData} ];
	var dataset = {};
	var onlyValues = series.map(function(obj) {
		return obj[3];
	});
	var minValue = Math.min.apply(null, onlyValues), maxValue = Math.max.apply(
			null, onlyValues);
	var paletteScale = d3.scale.linear().domain([ minValue, maxValue ]).range(
			[ "#9ed9f1", "#3a6575" ]); // blue color

	series.forEach(function(item) { //
		var iso = item[0], value = item[3];
		dataset[iso] = {
			numberOfThings : value,
			fillColor : paletteScale(value)
		};
	});

	var map = new Datamap({
		element : document.getElementById('container3'),
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
						'<br>Number of Tests: <strong>', data.numberOfThings,
						'</strong>', '</div>' ].join('');
			}
		}
	});
	map.legend();
</script>
</body>