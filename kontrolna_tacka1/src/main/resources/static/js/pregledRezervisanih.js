$(document).ready(function(){
	$.ajax({
		type:"GET",
		url:"http://localhost:8080/api/pregledRezervisanih",
		dataType:"json",
		success:function(data){
			console.log("SUCCESS:",data);
			for(i=0;i<data.length;i++){
				var row="<tr>";
				
				row+="<td>"+data[i]['dan']+"</td>";
				row+="<td>"+data[i]['vreme']+"</td>";
				row+="<td>"+data[i]['cena']+"</td>"
				
				var btn = "<button class='otkaziRez' id = " + data[i]['id'] + ">Otkazi rezervaciju</button>";
	              row += "<td>" + btn + "</td>"; 
	             
	              row+="</tr>";
	             row+="<br>";
	             
	             $('#pregledRezervisanih').append(row);

			}
		},
		error:function(data){
			console.log("ERROR:",data);
		}
	});
});

$(document).on('click', '.otkaziRez', function () {       
    
//	var rezervisan=$("#rezervisan").val();
//	var newKorisnikJSON=formToJSON(rezervisan);
	//var userName=$("#dan").val();
	//var password=$("#vreme").val();
	//var name=$("#cena").val();
	//var newKorisnikJSON=formToJSON(dan,vreme,cena);
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/otkazi/" + this.id,
        dataType: "json",
        success: function (data) {
        	console.log("SUCCESS : ", data);
        	//alert("Karta je uspesno rezervisana");
        	//location.reload(true);
        	//window.location.href="filmovi.html";
        	var row="<label for='id'><b>id</b></label><input type='text'   id='id'  value="+data['id']+"  disabled='disabled'>"+"<label for='rezervisan'><b>Kapacitet</b></label><input type='text'   id='rezervisan' value="+data['rezervisan']+">"               
        	var row2="<button type='submit' class='potvrdiOtkaz' style='color:black'>Potvrdi otkaz</button>";
        	$('#podaci').append(row);
        	$('#podaci').hide();
        	$('#potvrdi').append(row2);
        	$('#pregledRezervisanih').hide();
        	$('#naslov').hide();
        	
        },
        error: function (data) {
        	alert("Doslo je do greske");
            console.log("ERROR : ", data);
        }
    });
});
$(document).on('click', '.potvrdiOtkaz', function () {       
    
	var id=$("#id").val();
	var rezervisan=$("#rezervisan").val();
	



	var newSalaJSON=formToJSON2(id,rezervisan);

	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/otkaziRezervaciju",
		dataType:"json",
		contentType:"application/json",
		data:newSalaJSON,
		success:function(){
			alert("Rezervacija je uspesno otkazana");
			window.location.href="filmovi.html";
		},
		error:function(data){
			alert("Greska! Pokušajte ponovo.");
		}
	});

	});

function formToJSON2(id,rezervisan){
	return JSON.stringify({
		"id":id,
		"rezervisan":rezervisan
	
		
	});
}
/*function formToJSON(dan,vreme,cena){
	return JSON.stringify({
		"dan":dan,
		"vreme":vreme,
		"cena":cena
		
	});
}
/*
$(document).on('click', '.izmeniSalu', function () {       
    

	 
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/izmeniSalu/" + this.id,  
        dataType: "json",
        success: function (data) {
        	console.log("SUCCESS : ", data);
        	alert("Menjam salu");
        	//location.reload(true);
        	window.location.href="izmenaSale.html";
        	
                           
           
        },
        error: function (data) {
        	alert("Doslo je do greske");
            console.log("ERROR : ", data);
        }
    });
});*/

