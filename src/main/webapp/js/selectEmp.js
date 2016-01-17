$(document).ready(function()
{
var id = window.location.search.replace("?id=", "");
$.get("/carrent/rest/emp/getEmp/" + id, function(data, textStatus)
{
document.getElementById('id').innerHTML = data.idEmp;
document.getElementById('firstName').innerHTML = data.firstName;
document.getElementById('lastName').innerHTML = data.lastName;
document.getElementById('position').innerHTML = data.position;
document.getElementById('pin').innerHTML = data.pin;
document.getElementById('salary').innerHTML = data.salary;
});
});