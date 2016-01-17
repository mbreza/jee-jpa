$(document).ready(function()
{
var id = window.location.search.replace("?id=", "");
$.get("/carrent/rest/rent/getRent/" + id, function(data, textStatus)
{
document.getElementById('id').innerHTML = data.idRent;
document.getElementById('car').innerHTML = data.car.idCar;
document.getElementById('emp').innerHTML = data.emp.idEmp;
document.getElementById('price').innerHTML = data.price;
document.getElementById('dor').innerHTML = data.dor;
});
});