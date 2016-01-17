$(document).ready(function()
{
var id = window.location.search.replace("?id=", "");
document.getElementById('idEmp').value = id;
$.get("/carrent/rest/emp/getEmp/" + id, function(data, textStatus)
{
document.getElementById('id').innerHTML = data.idEmp;
document.getElementById('firstName').value = data.firstName;
document.getElementById('lastName').value = data.lastName;
document.getElementById('position').value = data.position;
document.getElementById('pin').value = data.pin;
document.getElementById('salary').value = data.salary;
});
});