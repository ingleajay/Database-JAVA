<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<!--  forward to index page for login if user info is not in session  -->
	<%
	String name = session.getAttribute("userName").toString();
	String email = session.getAttribute("userEmail").toString();
	String pic = session.getAttribute("pic").toString();
	String id =  session.getAttribute("hash").toString();

	if (session.getAttribute("userName") == null) {
	%>
	<jsp:forward page="/index.jsp" />
	<%
	}
	%>
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">
						Profile :
						<%=name%></h5>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-4">
							<img alt="profile" src=<%=pic%> >
						</div>
						<div class="col-8">
						<h6 class="mt-2">
								User Id :
								<%=id%></h6>
							<h6 class="mt-2">
								Name :
								<%=name%></h6>
							<h6 class="mt-2">
								Email :
								<%=email%></h6>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>