var pageNumber = 0;
//efeito infinie scroll
$(window).scroll(function() {
	var scrollTop = $(this).scrollTop();
	var conteudo = $(document).height() - $(window).height(); 
	
	console.log('scrollTop: ', scrollTop, ' | ', 'conteudo ', conteudo);
	
	//verificando se a barra de rolagem passou por todo o conteudo 
	//do tamanho de uma tela
	if(scrollTop >= conteudo){
	pageNumber++;
	setTimeout(function() {
		loadByScroolBar(pageNumber);
	}, 200);
	
	}
});


function loadByScroolBar(pageNumber) {
	
	$.ajax({
		method: "GET",
		url: "list/ajax",
		data: {
			page: pageNumber
		},
		success: function(response){
			//console.log("resposta > ", response);
			$(".row").fadeIn(250, function() {
				$(this).append(response);
			});
		}
	})
}