$(document).ready(function()
{
	
$.get("/carrent/rest/car/getAllCars", function(data, textStatus)
{
var carSelect = document.getElementById('carID');
for(var i in data) {
var list = document.createElement('option');
list.value = data[i].idCar;
list.innerHTML = data[i].idCar;
carSelect.appendChild(list);
}
});
-
$.get("/carrent/rest/emp/getAllEmp", function(data, textStatus)
{
var empSelect = document.getElementById('empID');
for(var i in data) {
var list = document.createElement('option');
list.value = data[i].idEmp;
list.innerHTML = data[i].idEmp;
empSelect.appendChild(list);
}
});


});