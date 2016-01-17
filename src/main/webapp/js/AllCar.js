$(document).ready(
		function() {
			$.get("/carrent/rest/car/getAllCars", function(data, textStatus)

			{
				var table = document.getElementById('presentationTable');

				for ( var i in data) {
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
					

					var cellDelete = document.createElement("td");
					var cellDeleteLink = document.createElement("a");
					var cellDeletePicture = document.createElement("img");
					cellDeletePicture.setAttribute('src', 'graphic/delete.png');
					cellDeleteLink.appendChild(cellDeletePicture);
					cellDeleteLink.href = "/carrent/deleteCar.html?id=" + data[i].idCar;
					cellDelete.appendChild(cellDeleteLink);
					

					var cellUpdate = document.createElement("td");
					var cellUpdateLink = document.createElement("a");
					var cellUpdatePicture = document.createElement("img");
					cellUpdatePicture.setAttribute('src', 'graphic/update.png');
					cellUpdateLink.appendChild(cellUpdatePicture);
					cellUpdateLink.href = "/carrent/updateCar.html?id=" + data[i].idCar;
					cellUpdate.appendChild(cellUpdateLink);
					
					
					var cellRead = document.createElement("td");
					var cellReadLink = document.createElement("a");
					var cellReadPicture = document.createElement("img");
					cellReadPicture.setAttribute('src', 'graphic/select.png');
					cellReadLink.appendChild(cellReadPicture);
					cellReadLink.href = "/carrent/selectCar.html?id=" + data[i].idCar;
					cellRead.appendChild(cellReadLink);
					
					row.appendChild(cellID);
					row.appendChild(cellBrand);
					row.appendChild(cellModel);
					row.appendChild(cellDescription);
					row.appendChild(cellDelete);
					row.appendChild(cellUpdate);
					row.appendChild(cellRead);
					table.appendChild(row);
				}
			});
		});