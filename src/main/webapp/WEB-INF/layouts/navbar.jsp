<%@ include file="/WEB-INF/layouts/head.jsp"%>
<body>

	<div class="container-responsive">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="/">Coronavirus Dashboard</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link ${active}"
						href="/">Home <span class="sr-only">(current)</span>
					</a>
					<li class="nav-item ${active}"><a class="nav-link"
						href="/maps">US Maps </a></li>
					<li class="nav-item"><a class="nav-link" href="/states">State
							Data</a></li>
					<li class="nav-item"><a class="nav-link" href="/data">About</a></li>

				</ul>
			</div>
		</nav>
	</div>