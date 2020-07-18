$(document).ready(function(){
	$.ajax({
		type:"GET",
		url:"http://localhost:8080/api/pregledRasporeda",
		dataType:"json",
		success:function(data){
			console.log("SUCCESS:",data);
			for(i=0;i<data.length;i++){
				var row="<tr>";
				
				row+="<td>"+data[i]['dan']+"</td>";
				row+="<td>"+data[i]['vreme']+"</td>";
				row+="<td>"+data[i]['cena']+"</td>"
				
				var btn = "<button class='izmeniRaspored' id = " + data[i]['id'] + ">Izmeni raspored</button>";
	              row += "<td>" + btn + "</td>"; 
	             
	              row+="</tr>";
	             row+="<br>";
	             
	             $('#pregledRasporeda').append(row);

			}
		},
		error:function(data){
			console.log("ERROR:",data);
		}
	});
});


$(document).on('click', '.izmeniRaspored', function () {       
    
	 //$('#pregledSala').hide();
	 
   $.ajax({
       type: "GET",
       url: "http://localhost:8080/api/izmeniRaspored/" + this.id,  
       dataType: "json",
       success: function (data) {
       	console.log("SUCCESS : ", data);
       	var row="<label for='id'><b>id</b></label><input type='text'   id='id'  value="+data['id']+"  disabled='disabled'>"+"<label for='dan'><b>Dan</b></label><input type='text'   id='dan' value="+data['dan']+">" +
       	"<label for='cena'><b>Cena</b></label><input type='text'   id='cena'  value="+data['cena']+">"+"<label for='vreme'><b>Vreme</b></label><input type='text'   id='vreme'  value="+data['vreme']+">";
       	row+="<button type='submit' class='izmenaRasp'>Izmeni raspored</button>";
   
       	$('#naslov').hide();
       	 $('#izmenaRasporeda').append(row);
       	$('#pregledRasporeda').hide();
       },
       error: function (data) {
       	alert("Doslo je do greske");
           console.log("ERROR : ", data);
       }
   });
});

$(document).on('click', '.izmenaRasp', function () {       
    
	var id=$("#id").val();
	var dan=$("#dan").val();
	var cena=$("#cena").val();
	var vreme=$("#vreme").val();


	var newSalaJSON=formToJSON2(id,dan,cena,vreme);

	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/izmenaRasp",
		dataType:"json",
		contentType:"application/json",
		data:newSalaJSON,
		success:function(){
			alert("Raspored je uspesno izmenjen");
			window.location.href="bioskop.html";
		},
		error:function(data){
			alert("Greska! Pokušajte ponovo.");
		}
	});

	});

function formToJSON2(id,dan,cena,vreme){
	return JSON.stringify({
		"id":id,
		"dan":dan,
		"cena":cena,
		"vreme":vreme
		
	});
}




