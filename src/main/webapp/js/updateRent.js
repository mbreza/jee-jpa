$(document).ready(function()
{
var id = window.location.search.replace("?id=", "");
document.getElementById('idRent').value = id;

$.get("/carrent/rest/car/getAllCars", function(data, textStatus)
{
var customerSelect = document.getElementById('carID');
for(var i in data) {
var list = document.createElement('option');
list.value = data[i].idCar;
list.innerHTML = data[i].idCar;
customerSelect.appendChild(list);
}
});
//Load employees
$.get("/carrent/rest/emp/getAllEmp", function(data, textStatus)
{
var employeeSelect = document.getElementById('empID');
for(var i in data) {
var list = document.createElement('option');
list.value = data[i].idEmp;
list.innerHTML = data[i].idEmp;
employeeSelect.appendChild(list);
}
});
//Load rest of shop order data
$.get("/carrent/rest/rent/getRent/" + id, function(data, textStatus)
{
document.getElementById('id').innerHTML = data.idRent;
document.getElementById('price').value = data.price;
document.getElementById('dorPicker').value = data.dor;
//Setting proper select's values
document.getElementById('carID').value = data.car.idCar;
document.getElementById('empID').value = data.emp.idEmp;
});
});