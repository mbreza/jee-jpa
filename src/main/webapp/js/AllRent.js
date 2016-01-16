$(document).ready(function()
{
$.get("/carrent/rest/rent/getAllRent", function(data, textStatus)
{
var table = document.getElementById('presentationTable');
for(var i in data) {
var row = document.createElement("tr");
var cellID = document.createElement("td");
var cellIDText = document.createTextNode(data[i].idRent);
var cellCarID = document.createElement("td");
var cellCarIDText = document.createTextNode(data[i].car.idCar);
var cellEmpID = document.createElement("td");
var cellEmpIDText = document.createTextNode(data[i].emp.idEmp);
var cellPrice = document.createElement("td");
var cellPriceText = document.createTextNode(data[i].price);
var cellDor = document.createElement("td");
var cellDorText = document.createTextNode(data[i].dor);
cellID.appendChild(cellIDText);
cellCarID.appendChild(cellCarIDText);
cellEmpID.appendChild(cellEmpIDText);
cellPrice.appendChild(cellPriceText);
cellDor.appendChild(cellDorText);



row.appendChild(cellID);
row.appendChild(cellCarID);
row.appendChild(cellEmpID);
row.appendChild(cellPrice);
row.appendChild(cellDor);
table.appendChild(row);
}
});
});