<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1>Transactions page</h1>

<ul>
<c:forEach items="${transactions}" var="transaction">
   <li>${transaction}</li>
</c:forEach>
</ul>