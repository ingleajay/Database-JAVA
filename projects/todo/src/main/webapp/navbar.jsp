<nav
						class="navbar navbar-light  navbar-expand-lg p-2 justify-content-between"
						style="background-color: #e3f2fd;"> <a class="navbar-brand"
						href="#"><strong>Welcome to Dashboard</strong> </a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarNav" aria-controls="navbarNav"
						aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse " id="navbarNav">
						<ul class="navbar-nav ms-auto">
							<li class="nav-item active p-1">
								<a href="welcome-page.jsp"><button type="submit" class="btn btn-success">Home</button></a>
							</li>
							<li class="nav-item p-1">
								<button type="submit" class="btn btn-primary"
									data-toggle="modal" data-target="#exampleModal">Profile</button>
							</li>
							<li class="nav-item p-1">
								<button type="submit" class="btn btn-secondary"
									data-toggle="modal" data-target="#exampleModal2">History</button>

							</li>
							<li class="nav-item p-1">
								<form action="login.jsp">
									<button type="submit" class="btn btn-warning"
										onclick="signOut();">Logout</button>
								</form>
							</li>
						</ul>
					</div>
					</nav>