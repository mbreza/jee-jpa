$(document).ready(
		function() {
			$.get("/carrent/rest/emp/getAllEmp", function(data, textStatus)

			{
				var table = document.getElementById('presentationTable');

				for ( var i in data) {
					var row = document.createElement("tr");

					var cellID = document.createElement("td");
					var cellIDText = document.createTextNode(data[i].idEmp);
					var cellfirstName = document.createElement("td");
					var cellfirstNameText = document.createTextNode(data[i].firstName);
					var celllastName = document.createElement("td");
					var celllastNameText = document.createTextNode(data[i].lastName);
					var cellposition = document.createElement("td");
					var cellpositionText = document.createTextNode(data[i].position);
					var cellPIN = document.createElement("td");
					var cellPINText = document.createTextNode(data[i].pin);
					var cellsalary = document.createElement("td");
					var cellsalaryText = document.createTextNode(data[i].salary);
					
					
					cellID.appendChild(cellIDText);
					cellfirstName.appendChild(cellfirstNameText);
					celllastName.appendChild(celllastNameText);
					cellposition.appendChild(cellpositionText);
					cellPIN.appendChild( cellPINText);
					cellsalary.appendChild(cellsalaryText);

					row.appendChild(cellID);
					row.appendChild(cellfirstName);
					row.appendChild(celllastName);
					row.appendChild(cellposition);
					row.appendChild(cellPIN);
					row.appendChild(cellsalary);
					table.appendChild(row);
				}
			});
		});