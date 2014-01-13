<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<!-- <link rel="stylesheet" href="css/bootstrap.css"  type="text/css"/> -->
<link
	href="http://bootswatch.com/flatly/bootstrap.min.css"
	rel="stylesheet">
<body>
<div class="panel panel-primary">
              <div class="panel-heading">
                <h1 class="panel-title">${person.firstName}'s Bio</h1>
              </div>
              <div class="panel-body" style="font-size:large; ">
                ${person.userBio}
              </div>
            </div>
</body>
</html>