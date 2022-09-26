<!DOCTYPE web-app PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd" >
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
	request.setAttribute("contextName",request.getContextPath());
%>
<html>
<body>
	<p>Welcome to Spring MVC Tutorial</p>
	
	<form action="${contextName}/mhs" method="post">
	<input type="hidden" name="mode" value="tambah">
	ID <input type="text" name="id" value=""><br>
	NIM <input type="text" name="nim" value=""><br>
	Nama <input type="text" name="nama" value=""><br>
	Alamat <input type="text" name="alamat" value=""><br>
	<button type="submit">Simpan</button>
	</form>
	
	<ul>
	<c:forEach var="mhs" items="${mhslist}">
	<li>${mhs.nim} - ${mhs.nama} - <a href="${contextName}/mhs/edit?id=${mhs.id}">Edit</a></li>
	</c:forEach>
	</ul>
</body>
</html>
