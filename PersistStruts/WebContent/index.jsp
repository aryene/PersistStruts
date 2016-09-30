<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="s" uri="/struts-tags"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 
 <tiles:insertDefinition name="padrao">
 
 <tiles:putAttribute name="corpo">
<br>
<br>
<br>
	
	<s:form action="processaRel">
		<input type="hidden" name="codigo" value="rel01" >
		<input type="submit" value="rel01"  >
	</s:form>


 </tiles:putAttribute> 


</tiles:insertDefinition> 
	
