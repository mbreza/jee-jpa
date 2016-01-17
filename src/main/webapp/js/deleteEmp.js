$(document).ready(function()
{
var id = window.location.search.replace("?id=", "");
document.getElementById('idEmp').value = id;
$.get("/carrent/rest/emp/getEmp/" + id, function(data, textStatus)
{
document.getElementById('idEmp').innerHTML = data.idEmp;
});
});