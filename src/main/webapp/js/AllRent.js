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



var cellDelete = document.createElement("td");
var cellDeleteLink = document.createElement("a");
var cellDeletePicture = document.createElement("img");
cellDeletePicture.setAttribute('src', 'graphic/delete.png');
cellDeleteLink.appendChild(cellDeletePicture);
cellDeleteLink.href = "/carrent/deleteRent.html?id=" + data[i].idRent;
cellDelete.appendChild(cellDeleteLink);


var cellUpdate = document.createElement("td");
var cellUpdateLink = document.createElement("a");
var cellUpdatePicture = document.createElement("img");
cellUpdatePicture.setAttribute('src', 'graphic/update.png');
cellUpdateLink.appendChild(cellUpdatePicture);
cellUpdateLink.href = "/carrent/updateRent.html?id=" + data[i].idRent;
cellUpdate.appendChild(cellUpdateLink);


var cellSelect = document.createElement("td");
var cellSelectLink = document.createElement("a");
var cellSelectPicture = document.createElement("img");
cellSelectPicture.setAttribute('src', 'graphic/select.png');
cellSelectLink.appendChild(cellSelectPicture);
cellSelectLink.href = "/carrent/selectRent.html?id=" + data[i].idRent;
cellSelect.appendChild(cellSelectLink);


row.appendChild(cellID);
row.appendChild(cellCarID);
row.appendChild(cellEmpID);
row.appendChild(cellPrice);
row.appendChild(cellDor);
row.appendChild(cellDelete);
row.appendChild(cellUpdate);
row.appendChild(cellSelect);
table.appendChild(row);
}
});
});