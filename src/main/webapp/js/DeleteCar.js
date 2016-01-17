$(document).ready(function()
{
var id = window.location.search.replace("?id=", "");
document.getElementById('idCar').value = id;
$.get("/carrent/rest/car/getCar/" + id, function(data, textStatus)
{
document.getElementById('id').innerHTML = data.idCar;
});
});