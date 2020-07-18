$(document).ready(function(){
	$('#profilMenadzer').hide();
	$.ajax({
		type:"GET",
		url:"http://localhost:8080/api/pregledMenadzera",
		dataType:"json",
		success:function(data){
			console.log("SUCCESS:",data);
			for(i=0;i<data.length;i++){
				var row="<tr>";
		row+="<td>"+data[i]['name']+"</td>";
				row+="<td>"+data[i]['surname']+"</td>"
				row+="<td>"+data[i]['userName']+"</td>";
				
				
				 var btn = "<button class='obrisiMenadzera' id = " + data[i]['id'] + ">Obrisi</button>";
	              row += "<td>" + btn + "</td>"; 
	              var profil = "<button class='profilMenadzer' id = " + data[i]['id'] + ">Profil</button>";
	              row += "<td>" + profil + "</td>";
	              row+="</tr>";
	             row+="<br>";
	             
	             $('#pregledMenadzera').append(row);

			}
		},
		error:function(data){
			console.log("ERROR:",data);
		}
	});
});

$(document).on('click', '.obrisiMenadzera', function () {       
    

 
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/obrisiMenadzera/" + this.id,  
        dataType: "json",
        success: function (data) {
        	console.log("SUCCESS : ", data);
        	alert("Menadzer obrisan uspesno");
        	location.reload(true);
                           
           
        },
        error: function (data) {
        	alert("Doslo je do greske");
            console.log("ERROR : ", data);
        }
    });
});

$(document).on('click', '.profilMenadzer', function () {       
    

	 
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/profilMenadzer/" + this.id,  
        dataType: "json",
        success: function (data) {
        	console.log("SUCCESS : ", data);
        	
        	var prom = "<p>"+data['name']+"</p>"+"<p>"+data['surname']+"</p>";
        	
        	
        	$('#profilMenadzer').append(prom);  
        	$('#profilMenadzer').show();               
        	$('#pregledMenadzera').hide();
        },
        error: function (data) {
        	alert("Doslo je do greske");
            console.log("ERROR : ", data);
        }
    });
});

