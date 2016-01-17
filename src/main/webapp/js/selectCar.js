$(document).ready(function()
{
var id = window.location.search.replace("?id=", "");
$.get("/carrent/rest/car/getCar/" + id, function(data, textStatus)
{
document.getElementById('id').innerHTML = data.idCar;
document.getElementById('brand').innerHTML = data.brand;
document.getElementById('model').innerHTML = data.model;
document.getElementById('description').innerHTML = data.description;
});
});