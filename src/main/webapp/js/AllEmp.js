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

					
					var cellDelete = document.createElement("td");
					var cellDeleteLink = document.createElement("a");
					var cellDeletePicture = document.createElement("img");
					cellDeletePicture.setAttribute('src', 'graphic/delete.png');
					cellDeleteLink.appendChild(cellDeletePicture);
					cellDeleteLink.href = "/carrent/deleteEmp.html?id=" + data[i].idEmp;
					cellDelete.appendChild(cellDeleteLink);
					

					var cellUpdate = document.createElement("td");
					var cellUpdateLink = document.createElement("a");
					var cellUpdatePicture = document.createElement("img");
					cellUpdatePicture.setAttribute('src', 'graphic/update.png');
					cellUpdateLink.appendChild(cellUpdatePicture);
					cellUpdateLink.href = "/carrent/updateEmp.html?id=" + data[i].idEmp;
					cellUpdate.appendChild(cellUpdateLink);
					
					
					var cellSelect = document.createElement("td");
					var cellSelectLink = document.createElement("a");
					var cellSelectPicture = document.createElement("img");
					cellSelectPicture.setAttribute('src', 'graphic/select.png');
					cellSelectLink.appendChild(cellSelectPicture);
					cellSelectLink.href = "/carrent/selectEmp.html?id=" + data[i].idEmp;
					cellSelect.appendChild(cellSelectLink);
					
					
					row.appendChild(cellID);
					row.appendChild(cellfirstName);
					row.appendChild(celllastName);
					row.appendChild(cellposition);
					row.appendChild(cellPIN);
					row.appendChild(cellsalary);
					row.appendChild(cellDelete);
					row.appendChild(cellUpdate);
					row.appendChild(cellSelect);
					table.appendChild(row);
				}
			});
		});