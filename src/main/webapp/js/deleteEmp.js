$(document).ready(function()
{
var id = window.location.search.replace("?id=", "");
document.getElementById('idEmp').value = id;
$.get("/carrent/rest/emp/getEmp/" + id, function(data, textStatus)
{
document.getElementById('idEmp').innerHTML = data.idEmp;
});


$('#form1').ajaxForm(function() { 
    alert("Job done!"); 
	 window.location.href = 'http://localhost:8080/carrent/AllEmp.html';            
}); 


});