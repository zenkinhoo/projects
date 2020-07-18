$(document).on("submit","form",function(event){
	event.preventDefault();
	
	var dan=$("#dan").val();
	var cena=$("#cena").val();
	var vreme=$("#vreme").val();

	
	var newKorisnikJSON=formToJSON(dan,cena,vreme);
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/dodajRaspored",
		dataType:"json",
		contentType:"application/json",
		data:newKorisnikJSON,
		success:function(){
			alert("Novi raspored  je uspesno dodata!");
			window.location.href="bioskop.html";
		},
		error:function(data){
			alert("Greska! Pokušajte ponovo.");
		}
	});
	
});

//pomocna funkcija koja od polja praavi JSON
function formToJSON(dan,cena,vreme){
	return JSON.stringify({
		"dan":dan,
		"cena":cena,
		"vreme":vreme
	});
}
	
