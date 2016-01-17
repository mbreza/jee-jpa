$(document).ready(function()
{
var id = window.location.search.replace("?id=", "");
document.getElementById('idRent').value = id;
$.get("/carrent/rest/rent/getRent/" + id, function(data, textStatus)
{
document.getElementById('id').innerHTML = data.idRent;

});


$('#form1').ajaxForm(function() { 
    alert("Job done!"); 
	 window.location.href = 'http://localhost:8080/carrent/AllRent.html';            
}); 

});