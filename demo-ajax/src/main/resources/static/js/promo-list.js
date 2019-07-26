var pageNumber = 0;

//ao iniciar a pagina
$(document).ready(function() {
	//ocultando esse itens (.hide)
	$("#loader-img").hide();
	$("#fim-btn").hide();
});


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
		beforeSend: function() {
			$("#loader-img").show();
		},
		success: function(response){
			//console.log("resposta > ", response);
			
			if (response.length > 150) {
				
			
			$(".row").fadeIn(250, function() {
				$(this).append(response);
			});
			}else{
				$("#fim-btn").show();
				$("#loader-img").removeClass("loader");
			}
		},
		error: function(xhr) {
			alert("Ops, ocorreu um erro: " + xhr.status + " - " + xhr.statusText);
		},
		complete: function() {
			$("#loader-img").hide();
		}
	})
}

//autocomplete
$("#autocomplete-input").autocomplete({
	source: function(request, response) {
		$.ajax({
			method: "GET",
			url: "/promocao/site",
			data: {
				termo: request.term
			},
			success: function(result) {
				response(result);  
			}
		});
	}
});


//adicionar likes
$(document).on("click","button[id*='likes-btn-']",function() {
	var id = $(this).attr("id").split("-")[2];
	console.log("id ", id);
	
	$.ajax({
		 method: "POST",
		 url: "/promocao/likes/" + id,
		 success: function(response) {
				$("#likes-count-" + id).text(response);
		},
		error: function(xhr) {
			alert("Ops... Ocorreu um erro: " + xhr.status + ", "+ xhr.statusText);
		}
	});
});