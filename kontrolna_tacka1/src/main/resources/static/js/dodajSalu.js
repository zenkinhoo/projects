$(document).on("submit","form",function(event){
	event.preventDefault();
	
	var kapacitet=$("#kapacitet").val();
	var oznaka=$("#oznaka").val();
	

	
	var newKorisnikJSON=formToJSON(kapacitet,oznaka);
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/dodajSalu",
		dataType:"json",
		contentType:"application/json",
		data:newKorisnikJSON,
		success:function(){
			alert("Nova sala je uspesno dodata!");
			window.location.href="bioskop.html";
		},
		error:function(data){
			alert("Greska! Pokušajte ponovo.");
		}
	});
	
});

//pomocna funkcija koja od polja praavi JSON
function formToJSON(kapacitet,oznaka){
	return JSON.stringify({
		"kapacitet":kapacitet,
		"oznaka":oznaka
		
	});
}
	
