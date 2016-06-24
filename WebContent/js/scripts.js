function checkLogin(){
	var login = $('#inputLogin').val();
	var check = false;
	$.ajax({
		url: '/jornal-v2/usuario/verificarLogin',
		data: {"login": login},
		success: function(data) {
			check = data == true;
			alert(check);
			//alert('Login não está disponível');
			//$('#msgExisteLogin').val = 'não está disponível';	
		},
		error: function(data) {
			check = data == true;
		}
	});
	//alert(check);
	if(check){
		alert('Login não disponível');
	}else{
		alert('Login disponível');
	}
}