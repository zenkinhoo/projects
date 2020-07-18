$(document).ready(function(){
	$.ajax({
		type:"GET",
		url:"http://localhost:8080/api/pregledSala",
		dataType:"json",
		success:function(data){
			console.log("SUCCESS:",data);
			for(i=0;i<data.length;i++){
				var row="<tr>";
				
				row+="<td>"+data[i]['kapacitet']+"</td>";
				row+="<td>"+data[i]['oznaka']+"</td>"
				
				var btn = "<button class='obrisiSalu' id = " + data[i]['id'] + ">Obrisi</button>";
	              row += "<td>" + btn + "</td>"; 
	              var izmena = "<button class='izmeniSalu' id = " + data[i]['id'] + ">Izmeni</button>";
	              row += "<td>" + izmena + "</td>"; 
	              row+="</tr>";
	             row+="<br>";
	             
	             $('#pregledSala').append(row);

			}
		},
		error:function(data){
			console.log("ERROR:",data);
		}
	});
});

$(document).on('click', '.obrisiSalu', function () {       
    

	 
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/obrisiSalu/" + this.id,  
        dataType: "json",
        success: function (data) {
        	console.log("SUCCESS : ", data);
        	alert("Sala je uspesno obrisana");
        	//location.reload(true);
        	
                           
        	window.location.href="bioskop.html";
        },
        error: function (data) {
        	alert("Doslo je do greske");
            console.log("ERROR : ", data);
        }
    });
});

$(document).on('click', '.izmeniSalu', function () {       
    
	 $('#pregledSala').hide();
	 
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/izmeniSalu/" + this.id,  
        dataType: "json",
        success: function (data) {
        	console.log("SUCCESS : ", data);
        	var row+="<label for="kapacitet"><b>Kapacitet</b></label><input type='text'   id='kapacitet' required>" +
        	"<label for="oznaka"><b>Oznaka</b></label><input type='text'   id='oznaka' required>	";
        	row+="<button type='submit' class='registerbtn'>Dodaj salu</button>";
        	 $('#izmenaSale').append(row);
        },
        error: function (data) {
        	alert("Doslo je do greske");
            console.log("ERROR : ", data);
        }
    });
});