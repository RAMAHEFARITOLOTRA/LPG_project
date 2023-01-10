<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@ page import="java.util.*,classe.*"%>
<jsp:useBean id="classe" scope="page" class="classe.Classe"/>
<jsp:useBean id="listeView" scope="page" class="java.util.LinkedList"/>
<%! 
private String getGUIId(HttpServletRequest request)
{
	if(null != request.getParameter("id"))
		return request.getParameter("id");
	else
		return "";
}
private String getGUIName(HttpServletRequest request)
{
	if(null != request.getParameter("name"))
		return request.getParameter("name");
	else
		return "";
}
private double getGUIValue(HttpServletRequest request)
{
	if(null != request.getParameter("value"))
		return Double.parseDouble(request.getParameter("value"));
	else
		return 0;
}
%>
<%
ClasseCRUD crud = (ClasseCRUD)application.getContext(application.getContextPath()).getAttribute("SCE_CRUD");
System.out.println("CLASSE CRUD : "+crud+"\nMAP : "+Data.getDataStore());

if(0 != getGUIId(request).compareTo(""))
{
	classe.setId(getGUIId(request).trim());
	classe.setName(getGUIName(request).toUpperCase().trim());
	classe.setValue(getGUIValue(request));
	crud.putData(classe);
}
listeView.addAll(crud.getAllData());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Page JSP</title>
</head>
<body>
<form id="form1" name="form1" method="post" action="index.jsp">
  <p align="center"><strong>SAISIE DATA  </strong></p>
  <p>ID Classe
  <input name="id" type="text" id="id" value="<%= getGUIId(request).trim()%>"/>
  </p>
  <p>Désignation 
    <input name="name" type="text" id="name" value="<%= getGUIName(request).trim()%>" />
  </p>
  <p>Valeur
    <input name="value" type="text" id="value" value="<%= getGUIValue(request) %>" />
  </p>
  <p>
    <input type="submit" name="valider" id="button" value="Valider" />
  </p>
</form>
  <table width="510" border="1">
    <tr>
      <td width="91"><div align="center"><strong>ID</strong></div></td>
      <td width="252"><div align="center"><strong>Name</strong></div></td>
      <td width="145"><div align="center"><strong>Valeur</strong></div></td>
    </tr>
<%
for(Iterator it = listeView.iterator();it.hasNext();)
{
	classe = (Classe)it.next();
%>      
    <tr>
		<td><%= classe.getId() %></td>
      	<td><%= classe.getName() %></td>
      	<td><%= classe.getValue() %></td>
    </tr>
<%
}
%>      
  </table>
</body>
</html>
