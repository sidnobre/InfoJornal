function PreviewImagem() {
	var oFReader = new FileReader();
	var imagem = document.getElementById("inputImagem").files[0];
	oFReader.readAsDataURL(imagem);
	oFReader.onload = function (oFREvent) {
		//document.getElementById("inputImagem").name = "imagem";
		document.getElementById("imagemPreview").src = oFREvent.target.result;
		document.getElementById('fake-file-input-name').value = imagem.name;
	};
};

function InputImagemClick() {
	document.getElementById('inputImagem').click();
}