$(document).ready(function()
{
      $.get("/carrent/rest/car/getAllCars", function(data, textStatus)
    		  
      {
              var table = document.getElementById('presentationTable');

              for(var i in data) {
                    var row = document.createElement("tr");

                    var cellID = document.createElement("td");
                    var cellIDText = document.createTextNode(data[i].idCar);
                    var cellBrand = document.createElement("td");
                    var cellBrandText = document.createTextNode(data[i].brand);
                    var cellModel = document.createElement("td");
                    var cellModelText = document.createTextNode(data[i].model);
                    var cellDescription = document.createElement("td");
                    var cellDescriptionText = document.createTextNode(data[i].description);

                    cellID.appendChild(cellIDText);
                    cellBrand.appendChild(cellBrandText);
                    cellModel.appendChild(cellModelText);
                    cellDescription.appendChild(cellDescriptionText);
                    
                    
                    
                    row.appendChild(cellID);
                    	row.appendChild(cellBrand);
                    		row.appendChild(cellDescription);
                    table.appendChild(row);
              }
      });
});