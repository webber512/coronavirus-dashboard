<div class="chart-container">
	<canvas id="usdailychart"></canvas>
</div>

<script type="text/javascript">    moment().format();

var x = new Chart(document.getElementById("usdailychart"), {
	   type: 'scatter',
	   data: {
	      datasets: [{
	         label: "# of Confirmed Cases",
	         showLine: true,
	         data: ${dailyCaseIncrease},
	         borderColor: "#0073A1",
	         backgroundColor: "#158CBA",
	         borderWidth: 2,
	         fill: false
	      }, {	         
	      	label: "# of Confirmed Deaths",
	         showLine: true,
	         data: ${dailyDeathIncrease},
	         borderColor: "#E6281D",
	         backgroundColor: "#FF4136",
	         borderWidth: 2,
	         fill: false
	      }]
	   },
	   options: {
	      responsive: true,
	      title: {
	    	  display: true,
	    	  text: 'COVID Cases and Deaths, Daily',
	    	  fontSize: 30
	      },
	      scales: {
	          yAxes: [{
	            scaleLabel: {
	              display: true,
	              labelString: 'Number of People'
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