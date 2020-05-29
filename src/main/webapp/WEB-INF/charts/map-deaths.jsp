<div class="row container-fluid">
	<div class="col-lg-6">
		<div id="container2"></div>
	</div>
	<div class="col-lg-6">
		<div id="deathsPerCap"></div>
	</div>
</div>

<script>
        window.addEventListener('resize', function() {
            map.resize();
        });
        
        $('.nav-tabs a').on('shown.bs.tab', function(event){
        	var series2 = [ ${stateData} ];
        	var dataset2 = {};
        	var onlyValues2 = series.map(function(obj) {
        		return obj[1];
        	});
        	var minValue2 = Math.min.apply(null, onlyValues2), maxValue2 = Math.max.apply(
        			null, onlyValues2);
        	var paletteScale2 = d3.scale.linear().domain([ minValue2, maxValue2 ]).range(
        			[ "#e7f3f8", "#107094" ]); // blue color

        	series2.forEach(function(item) { //
        		var iso2 = item[0], value2 = item[2];
        		dataset2[iso2] = {
        			numberOfThings : value2,
        			fillColor : paletteScale(value2)
        		};
        	});

        	var map = new Datamap({
        		element : document.getElementById('container2'),
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
        						'</strong>', '</div>' ].join('');
        			}
        		}
        	});           	});
</script>

<script>
    	var series2 = [ ${perCapData} ];
    	var dataset2 = {};
    	var onlyValues2 = series.map(function(obj) {
    		return obj[1];
    	});
    	var minValue2 = Math.min.apply(null, onlyValues2), maxValue2 = Math.max.apply(
    			null, onlyValues2);
    	var paletteScale2 = d3.scale.linear().domain([ minValue2, maxValue2 ]).range(
    			[ "#e7f3f8", "#107094" ]); // blue color

    	series2.forEach(function(item) { //
    		var iso2 = item[0], value2 = item[2];
    		dataset2[iso2] = {
    			numberOfThings : value2,
    			fillColor : paletteScale(value2)
    		};
    	});

    	var map = new Datamap({
    		element : document.getElementById('container2'),
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
    						'</strong>', '</div>' ].join('');
    			}
    		}
    	}); 
</script>