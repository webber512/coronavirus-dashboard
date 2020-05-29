<div class="chart-container">
	<canvas id="uscumulativechart"></canvas>
</div>

<script type="text/javascript">    moment().format();

var x = new Chart(document.getElementById("uscumulativechart"), {
	   type: 'scatter',
	   data: {
	      datasets: [{
	         label: "# of Tests Administered",
	         showLine: true,
	         data: ${totalTests},
	         borderColor: "#5CB1D2",
	         backgroundColor: "#75CAEB",
	         borderWidth: 2,
	         fill: false
	      }]
	   },
	   options: {
	      responsive: true,
	      title: {
	    	  display: true,
	    	  text: 'COVID Tests Administered, Daily',
	    	  fontSize: 30
	      },
	      scales: {
	          yAxes: [{
	            scaleLabel: {
	              display: true,
	              labelString: 'Number of Tests'
	            }
	          }],
	          xAxes: [{
	        	  ticks: {
	                  userCallback: function(label, index, labels) {
	                      return moment(label).format("MM/DD/YY");
	                  }
	               },
	               type: 'time',
	               time: {
	            	   tooltipFormat: 'MM-DD-YYYY'
	               },
	            scaleLabel: {
	              display: true,
	              labelString: 'Date'	            
	            }
	          }]
	        },
	   },
	});
moment().format();
</script>